import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraMain {

    public static Map<String, List<Double>> pos = new HashMap<String, List<Double>>();

    public static String chk(int x,int y){
        //System.out.println("x:"+x);
        //System.out.println("y:"+y);
        for (Map.Entry mapElement : pos.entrySet()) {
            String key = (String)mapElement.getKey();

            // Add some bonus marks
            // to all the students and print it
            List<Double> value = (List<Double>)mapElement.getValue();

            if(value.get(0).intValue()==x && value.get(1).intValue()==y){
                //System.out.println("vx:"+value.get(0).intValue());
                //System.out.println("vy:"+value.get(1).intValue());
                return key;
            }
        }
        return "";
    }

    public static String retL(int[][] maze,int x,int y){
        if(y>maze.length-1 || x>maze[0].length-1){
            return "";
        }
        else if(y<0 || x<0){
            return "";
        }
        else if(maze[y][x]==0){
            return "";
        }
        //System.out.println("Left Check");
        String retV=chk(x,y);
        if(!retV.equals("")){
            return retV;
        }
        return retL(maze,x-1,y);
    }

    public static String retR(int[][] maze,int x,int y){
        if(y>maze.length-1 || x>maze[0].length-1){
            return "";
        }
        else if(y<0 || x<0){
            return "";
        }
        else if(maze[y][x]==0){
            return "";
        }
        //System.out.println("Right Check");
        String retV=chk(x,y);
        if(!retV.equals("")){
            return retV;
        }
        return retR(maze,x+1,y);
    }

    public static String retF(int[][] maze,int x,int y){
        if(y>maze.length-1 || x>maze[0].length-1){
            return "";
        }
        else if(y<0 || x<0){
            return "";
        }
        else if(maze[y][x]==0){
            return "";
        }
        //System.out.println("Forward Check");
        String retV=chk(x,y);
        if(!retV.equals("")){
            return retV;
        }
        return retF(maze,x,y+1);
    }

    public static String retB(int[][] maze,int x,int y){
        if(y>maze.length-1 || x>maze[0].length-1){
            return "";
        }
        else if(y<0 || x<0){
            return "";
        }
        else if(maze[y][x]==0){
            return "";
        }
        //System.out.println("Backward Check");
        String retV=chk(x,y);
        if(!retV.equals("")){
            return retV;
        }
        return retB(maze,x,y-1);
    }

    public static ArrayList addAD(int[][] maze,String key,List<Double> value){
        Map<String,Integer> temp=new HashMap<String, Integer>();
        Map<String,String> tempd=new HashMap<String, String>();
        //System.out.println("Key-------------------"+key);
        String retLV=retL(maze,value.get(0).intValue()-1,value.get(1).intValue());
        if(!retLV.equals("")){
            temp.put(retLV,value.get(0).intValue()-pos.get(retLV).get(0).intValue());
            tempd.put(retLV,"Left");
        }

        String retRV=retR(maze,value.get(0).intValue()+1,value.get(1).intValue());
        if(!retRV.equals("")){
            temp.put(retRV,pos.get(retRV).get(0).intValue()-value.get(0).intValue());
            tempd.put(retRV,"Right");
        }

        String retFV=retF(maze,value.get(0).intValue(),value.get(1).intValue()+1);
        if(!retFV.equals("")){
            temp.put(retFV,pos.get(retFV).get(1).intValue()-value.get(1).intValue());
            tempd.put(retFV,"Forward");
        }

        String retBV=retB(maze,value.get(0).intValue(),value.get(1).intValue()-1);
        if(!retBV.equals("")){
            temp.put(retBV,value.get(1).intValue()-pos.get(retBV).get(1).intValue());
            tempd.put(retBV,"Backward");
        }

        ArrayList arrayList=new ArrayList();
        arrayList.add(temp);
        arrayList.add(tempd);
        return arrayList;

    }

    public static void main(String[] args) {

        int[][] maze= {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int i,j;

        for(i=0;i<(maze.length+1)/2;i++){
            int [] tmp=maze[i];
            maze[i]=maze[(maze.length-1)-i];
            maze[(maze.length-1)-i]=tmp;
        }

        /*for(i=0;i<maze.length;i++){
            for(j=0;j<maze[i].length;j++){
                System.out.print(maze[i][j]+",");
            }
            System.out.println();
        }*/

        DijkstraShortestPath shortestPath = new DijkstraShortestPath();

        /*Map<String, List<Double>> pos = new HashMap<String, List<Double>>();
        List<Double> tmp = new ArrayList<Double>();
        tmp.clear();
        tmp.add(40.714);
        tmp.add(74.006);
        pos.put("G1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.714);
        tmp.add(74.003);
        pos.put("W1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.758);
        tmp.add(74.003);
        pos.put("R1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.758);
        tmp.add(74.006);
        pos.put("I1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.758);
        tmp.add(74.086);
        pos.put("S1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.758);
        tmp.add(74.112);
        pos.put("I2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.714);
        tmp.add(74.112);
        pos.put("G2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.908);
        tmp.add(74.006);
        pos.put("C1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.998);
        tmp.add(74.006);
        pos.put("C2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.908);
        tmp.add(74.051);
        pos.put("S2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.908);
        tmp.add(74.086);
        pos.put("S3",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.908);
        tmp.add(74.112);
        pos.put("S4",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.998);
        tmp.add(74.051);
        pos.put("M1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.998);
        tmp.add(74.086);
        pos.put("M2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.998);
        tmp.add(74.112);
        pos.put("M3",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add(40.998);
        tmp.add(74.131);
        pos.put("F1",shortestPath.ConvP(tmp));*/

//        Map<String, List<Double>> pos = new HashMap<String, List<Double>>();
        List<Double> tmp = new ArrayList<Double>();
        tmp.clear();
        tmp.add((double)6);
        tmp.add((double)0);
        pos.put("G1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)2);
        tmp.add((double)0);
        pos.put("W1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)2);
        tmp.add((double)3);
        pos.put("R1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)6);
        tmp.add((double)3);
        pos.put("I1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)9);
        tmp.add((double)3);
        pos.put("S1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)10);
        tmp.add((double)3);
        pos.put("I2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)10);
        tmp.add((double)0);
        pos.put("G2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)6);
        tmp.add((double)5);
        pos.put("C1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)6);
        tmp.add((double)7);
        pos.put("C2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)8);
        tmp.add((double)5);
        pos.put("S2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)9);
        tmp.add((double)5);
        pos.put("S3",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)10);
        tmp.add((double)5);
        pos.put("S4",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)8);
        tmp.add((double)7);
        pos.put("M1",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)9);
        tmp.add((double)7);
        pos.put("M2",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)10);
        tmp.add((double)7);
        pos.put("M3",shortestPath.ConvP(tmp));
        tmp.clear();
        tmp.add((double)11);
        tmp.add((double)7);
        pos.put("F1",shortestPath.ConvP(tmp));


        Map<String, Map<String,Integer>> adc = new HashMap<String, Map<String, Integer>>();
        Map<String, Map<String,String>> add = new HashMap<String, Map<String, String>>();
        for (Map.Entry mapElement : pos.entrySet()) {
            String key = (String)mapElement.getKey();

            // Add some bonus marks
            // to all the students and print it
            List<Double> value = (List<Double>)mapElement.getValue();

            ArrayList arrList =new ArrayList();
            arrList=addAD(maze,key,value);

            adc.put(key,shortestPath.Conv((Map<String,Integer>)arrList.get(0)));
            add.put(key,shortestPath.ConvD((Map<String,String>)arrList.get(1)));

        }

//        System.out.println(adc);
//        System.out.println(add);

//        Map<String, Map<String,Integer>> adc = new HashMap<String, Map<String, Integer>>();
        /*Map<String,Integer> temp=new HashMap<String, Integer>();



        temp.clear();
        temp.put("I1",3);
        adc.put("G1",shortestPath.Conv(temp));
        temp.clear();
        temp.put("R1",3);
        adc.put("W1",shortestPath.Conv(temp));
        temp.clear();
        temp.put("I1",4);
        adc.put("R1",shortestPath.Conv(temp));
        temp.clear();
        temp.put("G1",3);
        temp.put("R1",4);
        temp.put("C1",2);
        temp.put("S1",3);
        adc.put("I1",shortestPath.Conv(temp));
        temp.clear();
        temp.put("I1",3);
        temp.put("S3",2);
        temp.put("I2",1);
        adc.put("S1",shortestPath.Conv(temp));
        temp.clear();
        temp.put("S1",1);
        temp.put("G2",3);
        temp.put("S4",2);
        adc.put("I2",shortestPath.Conv(temp));
        temp.clear();
        temp.put("I2",3);
        adc.put("G2",shortestPath.Conv(temp));
        temp.clear();
        temp.put("C2",2);
        temp.put("I1",2);
        temp.put("S2",2);
        adc.put("C1",shortestPath.Conv(temp));
        temp.clear();
        temp.put("C1",2);
        temp.put("M1",2);
        adc.put("C2",shortestPath.Conv(temp));
        temp.clear();
        temp.put("C1",2);
        temp.put("M1",2);
        temp.put("S3",1);
        adc.put("S2",shortestPath.Conv(temp));
        temp.clear();
        temp.put("S2",1);
        temp.put("M2",2);
        temp.put("S1",2);
        temp.put("S4",1);
        adc.put("S3",shortestPath.Conv(temp));
        temp.clear();
        temp.put("S3",1);
        temp.put("M3",2);
        temp.put("I2",2);
        adc.put("S4",shortestPath.Conv(temp));
        temp.clear();
        temp.put("C2",2);
        temp.put("S2",2);
        temp.put("M2",1);
        adc.put("M1",shortestPath.Conv(temp));
        temp.clear();
        temp.put("M1",1);
        temp.put("S3",2);
        temp.put("M3",1);
        adc.put("M2",shortestPath.Conv(temp));
        temp.clear();
        temp.put("M2",1);
        temp.put("S4",2);
        temp.put("F1",1);
        adc.put("M3",shortestPath.Conv(temp));
        temp.clear();
        temp.put("M3",1);
        adc.put("F1",shortestPath.Conv(temp));

        //System.out.println(adc);

//        Map<String, Map<String,String>> add = new HashMap<String, Map<String, String>>();
        Map<String,String> tempd=new HashMap<String, String>();


        tempd.clear();
        tempd.put("I1","Forward");
        add.put("G1",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("R1","Forward");
        add.put("W1",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("I1","Right");
        add.put("R1",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("G1","Backward");
        tempd.put("R1","Left");
        tempd.put("C1","Forward");
        tempd.put("S1","Right");
        add.put("I1",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("I1","Left");
        tempd.put("S3","Forward");
        tempd.put("I2","Right");
        add.put("S1",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("S1","Left");
        tempd.put("G2","Backward");
        tempd.put("S4","Forward");
        add.put("I2",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("I2","Forward");
        add.put("G2",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("C2","Forward");
        tempd.put("I1","Backward");
        tempd.put("S2","Right");
        add.put("C1",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("C1","Backward");
        tempd.put("M1","Right");
        add.put("C2",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("C1","Left");
        tempd.put("M1","Forward");
        tempd.put("S3","Right");
        add.put("S2",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("S2","Left");
        tempd.put("M2","Forward");
        tempd.put("S1","Backward");
        tempd.put("S4","Right");
        add.put("S3",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("S3","Left");
        tempd.put("M3","Forward");
        tempd.put("I2","Backward");
        add.put("S4",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("C2","Left");
        tempd.put("S2","Backward");
        tempd.put("M2","Right");
        add.put("M1",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("M1","Left");
        tempd.put("S3","Backward");
        tempd.put("M3","Right");
        add.put("M2",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("M2","Left");
        tempd.put("S4","Backward");
        tempd.put("F1","Right");
        add.put("M3",shortestPath.ConvD(tempd));
        tempd.clear();
        tempd.put("M3","Left");
        add.put("F1",shortestPath.ConvD(tempd));*/




        //System.out.println(pos);


        Map<String,Vertex> allV=new HashMap<String, Vertex>();

        for (Map.Entry mapElement : pos.entrySet()) {
            String key = (String)mapElement.getKey();

            // Add some bonus marks
            // to all the students and print it
            List<Double> value = (List<Double>)mapElement.getValue();

            Vertex tv = new Vertex(key);
            tv.setX(value.get(0));
            tv.setY(value.get(1));
            allV.put(key,tv);
        }

        for (Map.Entry mapElement : adc.entrySet()) {
            String key = (String)mapElement.getKey();

            Map<String,Integer> val=(Map<String,Integer>)mapElement.getValue();

            for (Map.Entry mapElementi : val.entrySet()) {
                String keyi = (String)mapElementi.getKey();

                Integer vali=(Integer)mapElementi.getValue();
                allV.get(key).addNeighbour(new Edge(vali, allV.get(key),allV.get(keyi)));
                allV.get(key).addNeighbourC(keyi,vali);
            }
        }

        for (Map.Entry mapElement : add.entrySet()) {
            String key = (String)mapElement.getKey();

            Map<String,String> val=(Map<String,String>)mapElement.getValue();

            for (Map.Entry mapElementi : val.entrySet()) {
                String keyi = (String)mapElementi.getKey();

                String vali=(String)mapElementi.getValue();
                allV.get(key).addNeighbourD(keyi,vali);
            }
        }


        /*Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");

        vertexA.addNeighbour(new Edge(10,vertexA,vertexC));
        vertexA.addNeighbourC("C",10);
        vertexC.addNeighbour(new Edge(10,vertexC,vertexA));
        vertexC.addNeighbourC("A",10);
        vertexA.addNeighbour(new Edge(17,vertexA,vertexB));
        vertexA.addNeighbourC("B",17);
        vertexB.addNeighbour(new Edge(17,vertexB,vertexA));
        vertexB.addNeighbourC("A",17);
        //vertexC.addNeighbour(new Edge(5,vertexC,vertexB));
        vertexC.addNeighbour(new Edge(9,vertexC,vertexD));
        vertexC.addNeighbourC("D",9);
        vertexD.addNeighbour(new Edge(9,vertexD,vertexC));
        vertexD.addNeighbourC("C",9);
        vertexC.addNeighbour(new Edge(11,vertexC,vertexE));
        vertexC.addNeighbourC("E",11);
        vertexE.addNeighbour(new Edge(11,vertexE,vertexC));
        vertexE.addNeighbourC("C",11);
        vertexB.addNeighbour(new Edge(1,vertexB,vertexD));
        vertexB.addNeighbourC("D",1);
        vertexD.addNeighbour(new Edge(1,vertexD,vertexB));
        vertexD.addNeighbourC("B",1);*/
        //vertexD.addNeighbour(new Edge(6,vertexD,vertexE));

        /*//vertexA.setPil("#");
        //vertexA.setPir("C");
        vertexA.addDir("C","Right");
        //vertexA.setPif("B");
        vertexA.addDir("B","Forward");
        //vertexA.setPib("#");

        //vertexB.setPil("#");
        //vertexB.setPir("D");
        vertexB.addDir("D","Right");
        //vertexB.setPif("#");
        //vertexB.setPib("A");
        vertexB.addDir("A","Backward");

        //vertexC.setPil("A");
        vertexC.addDir("A","Left");
        //vertexC.setPir("E");
        vertexC.addDir("E","Right");
        //vertexC.setPif("D");
        vertexC.addDir("D","Forward");
        //vertexC.setPib("#");

        //vertexD.setPil("B");
        vertexD.addDir("B","Left");
        //vertexD.setPir("#");
        //vertexD.setPif("#");
        //vertexD.setPib("C");
        vertexD.addDir("C","Backward");

        //vertexE.setPil("C");
        vertexE.addDir("C","Left");
        //vertexE.setPir("#");
        //vertexE.setPif("#");
        //vertexE.setPib("#");*/


        shortestPath.computeShortestPaths(allV.get("G1"));

        System.out.println("======================================");
        System.out.println("Calculating minimum distance");
        System.out.println("======================================");

        System.out.println("Minimum distance from G1 to S2: "+allV.get("S2").getDistance());
//        System.out.println("Minimum distance from A to C: "+vertexC.getDistance());
//        System.out.println("Minimum distance from A to D: "+vertexD.getDistance());
//        System.out.println("Minimum distance from A to E: "+vertexE.getDistance());

        System.out.println("=====================	=================");
        System.out.println("Calculating Paths");
        System.out.println("======================================");

        System.out.println("Shortest Path from G1 to S2: "+shortestPath.getShortestPathTo(allV.get("S2")));
//        System.out.println("Shortest Path from A to C: "+shortestPath.getShortestPathTo(vertexC));
//        System.out.println("Shortest Path from A to D: "+shortestPath.getShortestPathTo(vertexD));
//        System.out.println("Shortest Path from A to E: "+shortestPath.getShortestPathTo(vertexE));

        System.out.println("=====================	=================");
        System.out.println("Full Paths");
        System.out.println("======================================");

        System.out.print("Shortest Path from G1 to S2: ");
        shortestPath.getShortestPathToDir(allV.get("S2"));
//        System.out.print("Shortest Path from A to C: ");
//        shortestPath.getShortestPathToDir(vertexC);
//        System.out.print("Shortest Path from A to D: ");
//        shortestPath.getShortestPathToDir(vertexD);
//        System.out.print("Shortest Path from A to E: ");
//        shortestPath.getShortestPathToDir(vertexE);




    }


}