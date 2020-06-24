import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintPath{

    private String name;
    private double x;
    private double y;
    private int steps;
    private String direction;
    private String np;

    /*public PrintPath(String name, double x, double y, int steps, String np, String direction) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.steps = steps;
        this.np = np;
        this.direction = direction;
    }*/

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getSteps() {
        return steps;
    }

    public String getNp() {
        return np;
    }

    public String getDirection() {
        return direction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setNp(String np) {
        this.np = np;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}