package agent;

import edimbrujologic.Projectile;
import edimbrujologic.Player;
import edimbrujologic.Manager;
import edimbrujologic.Match;
import edimbrujologic.Spawn;
import edimbrujologic.Tower;
import edimbrujologic.Map;
import conexion.Conexion;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

public class EdimbrujoAgent {

    public static void main(String[] args) throws IOException {
	Manager manager;
	Player myAgent;
	Map map;
	Match match;
	ArrayList<Player> players;
	ArrayList<Projectile> projectiles;
	ArrayList<Spawn> spawns;
	ArrayList<Tower> towers;
	String myID;
	//conexion Conexion = new Conexion("http://192.168.200.105:8080/edimbrujo/webservice/server");
	Conexion conexion = new Conexion("http://localhost:8080/Edimbrujo/webservice/server");
	manager = Manager.getManager();
	System.out.println(manager);
	myID = conexion.iniciar("gonza");
	manager.updateStaticState(conexion.getFullStaticState());
	while (true) {
	    conexion.makeAction("ready");
	    manager.updateState(conexion.getFullState());
	    myAgent = manager.getPlayer(myID);
	    map = manager.getMap();
	    match = manager.getMatch();
	    players = manager.getPlayers();
	    projectiles = manager.getProjectiles();
	    spawns = manager.getSpawns();
	    towers = manager.getTowers();
	    //hacer lo que quieran hacer   
	}
    }
}
