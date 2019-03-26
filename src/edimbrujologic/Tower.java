package edimbrujologic;

import java.awt.Point;
import org.json.simple.JSONObject;

public class Tower {

    protected String id;
    protected Point position;
    protected boolean dead;
    protected int team;
    protected int health;
    protected int healthMax;

    public Tower(String id) {
	this.id = id;
    }

    public String getId() {
	return id;
    }

    public Point getPosition() {
	return position;
    }

    public boolean isDead() {
	return dead;
    }

    public int getTeam() {
	return team;
    }

    public int getHealth() {
	return health;
    }

    public int getHealthMax() {
	return healthMax;
    }

    public void fromJSON(JSONObject object) {
	JSONObject entity = (JSONObject) ((JSONObject) object.get("super")).get("Entity");
	this.position = new Point((int) (long) entity.get("x"), (int) (long) entity.get("y"));
	this.dead = (Boolean) object.get("dead");
	this.team = (int) (long) object.get("team");
	this.health = (int) (long) object.get("health");
	this.healthMax = (int) (long) object.get("healthMax");
    }
}
