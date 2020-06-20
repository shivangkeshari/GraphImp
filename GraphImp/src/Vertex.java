import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> adjacenciesList;
    private Map<String,Integer> adl;
    private boolean visited;
    private Vertex predecessor;
    private double distance = Double.MAX_VALUE;
    private double x;
    private double y;
    /*private String pil;
    private String pir;
    private String pif;
    private String pib;*/
    //private Map<String,String> dir;
    //Angle idea

    public Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
        //this.dir = new HashMap< String,String>();
        this.adl = new HashMap< String,Integer>();
    }

    public void addNeighbour(Edge edge) {
        this.adjacenciesList.add(edge);
    }

    public void addNeighbourC(String t, Integer c) {
        adl.put(t,c);
    }

    /*public void addDir(String t, String d) {
        dir.put(t,d);
    }

    public String getDirK(String i){
        return dir.get(i);
    }*/

    public Integer getNeiC(String i){
        return adl.get(i);
    }

    /*public Map<String, String> getDir() {
        return dir;
    }

    public void setDir(Map<String, String> dir) {
        this.dir = dir;
    }*/

    public Map<String, Integer> getAdl() {
        return adl;
    }

    public void setAdl(Map<String, Integer> adl) {
        this.adl = adl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    //    public String getPil() {
//        return pil;
//    }
//
//    public String getPir() {
//        return pir;
//    }
//
//    public String getPif() {
//        return pif;
//    }
//
//    public String getPib() {
//        return pib;
//    }
//
//    public void setPil(String pil) {
//        this.pil = pil;
//    }
//
//    public void setPir(String pir) {
//        this.pir = pir;
//    }
//
//    public void setPif(String pif) {
//        this.pif = pif;
//    }
//
//    public void setPib(String pib) {
//        this.pib = pib;
//    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }
}