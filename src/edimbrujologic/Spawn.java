package edimbrujologic;

import java.awt.Point;
import org.json.simple.JSONObject;

public class Spawn {

    protected String name;
    protected Point position;

    public Spawn(JSONObject object) {
	fromJSON(object);
    }

    public String getName() {
	return name;
    }

    public Point getPosition() {
	return position;
    }

    private void fromJSON(JSONObject object) {
	this.name = (String) object.get("name");
	this.position = new Point((int) (long) object.get("x"), (int) (long) object.get("y"));
    }
}
