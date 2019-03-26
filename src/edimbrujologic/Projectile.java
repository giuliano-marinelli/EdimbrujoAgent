package edimbrujologic;

import java.awt.Point;
import org.json.simple.JSONObject;

public class Projectile {

    protected String id;    //es el id del player que es duenio
    protected int nroArrow; //clave debil
    protected int team;
    protected Point position;
    protected Point velocity;

    public Projectile(String id) {
	this.id = id;
    }

    public String getId() {
	return id;
    }

    public int getNroArrow() {
	return nroArrow;
    }

    public int getTeam() {
	return team;
    }

    public Point getPosition() {
	return position;
    }

    public Point getVelocity() {
	return velocity;
    }

    public void fromJSON(JSONObject object) {
	JSONObject entity = (JSONObject) ((JSONObject) object.get("super")).get("Entity");
	this.position = new Point((int) (long) entity.get("x"), (int) (long) entity.get("y"));
	this.team = (int) (long) object.get("team");
	this.nroArrow = (int) (long) object.get("number");
	this.velocity = new Point((int) (long) object.get("xVelocity"), (int) (long) object.get("yVelocity"));
    }
}
