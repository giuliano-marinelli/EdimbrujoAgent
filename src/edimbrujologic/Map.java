package edimbrujologic;

import java.awt.Point;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Map {

    private HashMap<Point, Integer> cells;
    private int width;
    private int height;

    public Map() {
	this.cells = new HashMap<>();
    }

    public Integer getCell(Point point) {
	return cells.get(point);
    }

    public Integer setCell(Point point, Integer integer) {
	return cells.put(point, integer);
    }

    public int getWidth() {
	return width;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	this.height = height;
    }

    public boolean canWalk(Point point) {
	//si es 1 es piso por lo que se puede caminar
	//si es 0 es una pared
	boolean res;
	res = (cells.containsKey(point) && cells.get(point) == 1);
	return res;
    }

    public void fromJSON(JSONObject object) {
	height = (int) (long) object.get("height");
	width = (int) (long) object.get("width");
	JSONArray cellsArray = (JSONArray) object.get("cells");
	for (int i = 0; i < cellsArray.size(); i++) {
	    JSONObject cell = (JSONObject) cellsArray.get(i);
	    Point point = new Point((int) (long) cell.get("x"), (int) (long) cell.get("y"));
	    this.cells.put(point, (int) (long) cell.get("val"));
	}
    }
}
