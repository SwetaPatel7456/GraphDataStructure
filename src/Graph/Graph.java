package Graph;

import java.util.*;

public class Graph {

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {

        addEdge(1,2,false);
        addEdge(1,3,false);
        display();


    }

    public static void addEdge(int u,int v,boolean direction){
            List<Integer> list;
            List<Integer> list1;
            if(map.get(u)==null){
               list = new ArrayList<>();
            }
            else{
                list = map.get(u);
            }
            list.add(v);
            map.put(u,list);

            if(!direction){
                if(map.get(v)==null){
                    list1 = new ArrayList<>();
                }
                else{
                    list1 = map.get(v);
                }
                list1.add(u);
                map.put(v,list1);
            }


    }
    public static void display(){
       Set<Integer> keys =  map.keySet();
       for(Integer key :keys){
           List<Integer> list = new ArrayList<>();
           list = map.get(key);
           System.out.println(key + "->" + list);
       }

    }

}
