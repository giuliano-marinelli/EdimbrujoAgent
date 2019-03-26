package edimbrujologic;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Match {

    protected int round;
    protected int countRounds;
    protected boolean endGame;
    protected boolean endRound;
    protected boolean startGame;
    protected int teamAttacker;
    protected int sizeTeam;
    protected ArrayList<String> players;
    protected ArrayList<String> playingPlayers;
    protected ArrayList<String> ready;
    protected ArrayList<Integer> teamPoints;

    public Match() {
	players = new ArrayList<>();
	playingPlayers = new ArrayList<>();
	ready = new ArrayList<>();
	teamPoints = new ArrayList<>();
    }

    public int getRound() {
	return round;
    }

    public int getCountRounds() {
	return countRounds;
    }

    public boolean isEndGame() {
	return endGame;
    }

    public boolean isEndRound() {
	return endRound;
    }

    public boolean isStartGame() {
	return startGame;
    }

    public int getTeamAttacker() {
	return teamAttacker;
    }

    public int getSizeTeam() {
	return sizeTeam;
    }

    public ArrayList<String> getPlayers() {
	return players;
    }

    public ArrayList<String> getPlayingPlayers() {
	return playingPlayers;
    }

    public ArrayList<String> getReady() {
	return ready;
    }

    public int getTeamPoints(int team) {
	return teamPoints.get(team);
    }

    public int getCantPlayers() {
	return players.size();
    }

    public int getCantPlayingPlayers() {
	return playingPlayers.size();
    }

    public int getCantReady() {
	return ready.size();
    }

    public void fromJSON(JSONObject object) {
	JSONArray jsonArray;
	this.round = (int) (long) object.get("round");
	this.countRounds = (int) (long) object.get("countRounds");
	this.endGame = (Boolean) object.get("endGame");
	this.endRound = (Boolean) object.get("endRound");
	this.startGame = (Boolean) object.get("startGame");
	this.teamAttacker = (int) (long) object.get("teamAttacker");
	this.sizeTeam = (int) (long) object.get("sizeTeam");
	jsonArray = (JSONArray) object.get("players");
	for (int i = 0; i < jsonArray.size(); i++) {
	    this.players.add((String) jsonArray.get(i));
	}
	jsonArray = (JSONArray) object.get("playingPlayers");
	for (int i = 0; i < jsonArray.size(); i++) {
	    this.playingPlayers.add((String) jsonArray.get(i));
	}
	jsonArray = (JSONArray) object.get("ready");
	for (int i = 0; i < jsonArray.size(); i++) {
	    this.ready.add((String) jsonArray.get(i));
	}
	jsonArray = (JSONArray) object.get("teamPoints");
	for (int i = 0; i < jsonArray.size(); i++) {
	    this.teamPoints.add((int) (long) jsonArray.get(i));
	}
    }
}
