package edimbrujologic;

import java.awt.Point;
import org.json.simple.JSONObject;

public class Player {

    protected String id;
    protected boolean dead;
    protected boolean leave;
    protected Point position;
    protected Integer team;
    protected int role; //1 ataca 0 defiende
    protected int health;
    protected int healthMax;

    public Player(String id) {
	this.id = id;
    }

    public String getId() {
	return id;
    }

    public boolean isDead() {
	return dead;
    }

    public boolean isLeave() {
	return leave;
    }

    public Point getPosition() {
	return position;
    }

    public Integer getTeam() {
	return team;
    }

    public int getRole() {
	return role;
    }

    public int getHealth() {
	return health;
    }

    public int getHealthMax() {
	return healthMax;
    }

    public void fromJSON(JSONObject object) {
	this.dead = (Boolean) object.get("dead");
	this.leave = (Boolean) object.get("leave");
	JSONObject entity = (JSONObject) ((JSONObject) object.get("super")).get("Entity");
	this.position = new Point((int) (long) entity.get("x"), (int) (long) entity.get("y"));
	this.team = (int) (long) object.get("team");
	this.role = (int) (long) object.get("role");
	this.health = (int) (long) object.get("health");
	this.healthMax = (int) (long) object.get("healthMax");
    }
}
