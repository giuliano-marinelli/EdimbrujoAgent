package edimbrujologic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Manager {

    private static Manager manager;
    private HashMap<String, Player> players;
    private HashMap<String, Tower> towers;
    private Map map;
    private Match match;
    private ArrayList<Player> playerList;
    private ArrayList<Projectile> projectileList;
    private ArrayList<Tower> towerList;
    private ArrayList<Spawn> spawnList;

    public static Manager getManager() {
	if (manager == null) {
	    manager = new Manager();
	}
	return manager;
    }

    private Manager() {
	players = new HashMap<>();
	towers = new HashMap<>();
	map = new Map();
	match = new Match();
	playerList = new ArrayList<>();
	projectileList = new ArrayList<>();
	towerList = new ArrayList<>();
	spawnList = new ArrayList<>();
    }

    public Player getPlayer(String id) {
	return players.get(id);
    }

    public ArrayList<Player> getPlayers() {
	return playerList;
    }

    public ArrayList<Projectile> getProjectiles() {
	return projectileList;
    }

    public ArrayList<Tower> getTowers() {
	return towerList;
    }

    public ArrayList<Spawn> getSpawns() {
	return spawnList;
    }

    public Map getMap() {
	return map;
    }

    public Match getMatch() {
	return match;
    }

    public void updateStaticState(String state) {
	try {
	    spawnList = new ArrayList<>();
	    JSONObject json = (JSONObject) new JSONParser().parse(state);
	    for (int i = 0; i < json.size(); i++) {
		JSONObject jsonObject = (JSONObject) json.get(Integer.toString(i));
		JSONObject object;
		if ((object = (JSONObject) jsonObject.get("Map")) != null) {
		    map.fromJSON(object);
		}
		if ((object = (JSONObject) jsonObject.get("Spawn")) != null) {
		    spawnList.add(new Spawn(object));
		}
	    }
	} catch (ParseException ex) {
	    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void updateState(String state) {
	try {
	    projectileList = new ArrayList<>();
	    JSONObject json = (JSONObject) new JSONParser().parse(state);
	    for (int i = 0; i < json.size(); i++) {
		JSONObject jsonObject = (JSONObject) json.get(Integer.toString(i));
		JSONObject object;
		if ((object = (JSONObject) jsonObject.get("Player")) != null) {
		    String id = (String) object.get("id");
		    Player player = players.get(id);
		    if (player == null) {
			player = new Player(id);
			players.put(id, player);
			playerList.add(player);
		    }
		    player.fromJSON(object);
		} else if ((object = (JSONObject) jsonObject.get("Tower")) != null) {
		    String id = (String) object.get("id");
		    Tower tower = towers.get(id);
		    if (tower == null) {
			tower = new Tower(id);
			towers.put(id, tower);
			towerList.add(tower);
		    }
		    tower.fromJSON(object);
		} else if ((object = (JSONObject) jsonObject.get("Projectile")) != null) {
		    String id = (String) object.get("id");
		    Projectile projectile = new Projectile(id);
		    projectileList.add(projectile);
		    projectile.fromJSON(object);
		} else if ((object = (JSONObject) jsonObject.get("Match")) != null) {
		    match.fromJSON(object);
		}
	    }
	} catch (ParseException ex) {
	    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
