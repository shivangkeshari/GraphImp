import java.util.*;

public class DijkstraShortestPath {

    public Map<String,Integer> Conv(Map<String,Integer> temp){
        Map<String,Integer> t=new HashMap<String, Integer>();
        t.putAll(temp);
        return t;
    }

    public Map<String,String> ConvD(Map<String,String> temp){
        Map<String,String> t=new HashMap<String, String>();
        t.putAll(temp);
        return t;
    }

    public List<Double> ConvP(List<Double> temp){
        List<Double> t=new ArrayList<Double>();
        t.addAll(temp);
        return t;
    }

    public void computeShortestPaths(Vertex sourceVertex){

        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        sourceVertex.setVisited(true);

        while( !priorityQueue.isEmpty() ){
            // Getting the minimum distance vertex from priority queue
            Vertex actualVertex = priorityQueue.poll();

            for(Edge edge : actualVertex.getAdjacenciesList()){

                Vertex v = edge.getTargetVertex();
                if(!v.isVisited())
                {
                    double newDistance = actualVertex.getDistance() + edge.getWeight();

                    if( newDistance < v.getDistance() ){
                        priorityQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setPredecessor(actualVertex);
                        priorityQueue.add(v);
                    }
                }
            }
            actualVertex.setVisited(true);
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex){
        List<Vertex> path = new ArrayList<>();

        for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }

    public void getShortestPathToDir(Vertex targetVertex){
        List<Vertex> path = new ArrayList<>();

        for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
            path.add(vertex);
        }

        int f=0;
        Vertex i=new Vertex("");
        Collections.reverse(path);
        System.out.print("Direction Path: ");
        int c=0;
        for(Vertex v:path){

            if(f==0){
                f=1;
                i=v;
                //System.out.print(i.getName());
                c++;
            }
            else if(path.size()-1==c){
                //System.out.print(i.getName()+"->"+v.getName()+":"+i.getDirK(v.getName())+"("+i.getNeiC(v.getName())+")"+", ");
                System.out.print(i.getName()+"("+i.getX()+", "+i.getY()+")->"+v.getName()+"("+v.getX()+", "+v.getY()+"):"+i.getNeiC(v.getName())+"("+i.getNeiD(v.getName())+")");
                i=v;
            }
            else{
                //System.out.print(i.getName()+"->"+v.getName()+":"+i.getDirK(v.getName())+"("+i.getNeiC(v.getName())+")"+", ");
                System.out.print(i.getName()+"("+i.getX()+", "+i.getY()+")->"+v.getName()+"("+v.getX()+", "+v.getY()+"):"+i.getNeiC(v.getName())+"("+i.getNeiD(v.getName())+")"+"~");
                i=v;
                c++;
            }

            //path.add(v);



        }
        System.out.println();
    }

}