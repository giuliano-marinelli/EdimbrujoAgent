package agent;

import edimbrujologic.Manager;
import edimbrujologic.Tower;
import conexion.Conexion;
import java.awt.Point;
import java.io.IOException;
import java.security.SecureRandom;

public class RandomAgent {

    private String token;
    private Manager manager;
    private Tower torreObjetivo;

    public RandomAgent(String token, Manager manager) {
	this.token = token;
	this.manager = Manager.getManager();
    }

    public void atack() {
	if (torreObjetivo == null && torreObjetivo.isDead()) {
	    int menorDistancia = 9999;
	    for (Tower tower : manager.getTowers()) {
		int dist;
		dist = calcularDistancia(tower.getPosition(), manager.getPlayer(token).getPosition());
		if (dist <= menorDistancia) {
		    torreObjetivo = tower;
		}
	    }
	}
    }

    public static void main(String[] args) throws IOException {
	Conexion con = new Conexion("http://192.168.200.105:8080/Edimbrujo/webservice/server");
	String[] move = {"up", "down", "left", "right", "upleft", "upright", "downleft", "downright"};
	System.out.println(con.iniciar("walace47"));
	System.out.println(con.getFullStaticState());
	while (true) {
	    con.makeAction("ready");
	    System.out.println(con.getFullState());
	    SecureRandom random = new SecureRandom();
	    int i = random.nextInt(2);
	    switch (i) {
		case (0):
		    con.makeAction(move[random.nextInt(8)]);
		    break;
		case (1):
		    con.makeRangeAtack("" + random.nextInt(40), "" + random.nextInt(40));
		    break;
	    }

	}
    }

    private int calcularDistancia(Point point1, Point point2) {
	double x1, x2, y1, y2;
	x1 = point1.getX();
	y1 = point1.getY();
	x2 = point2.getX();
	y2 = point2.getY();
	return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}
