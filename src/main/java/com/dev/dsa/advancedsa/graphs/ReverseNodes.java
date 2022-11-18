package com.dev.dsa.advancedsa.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReverseNodes {
    class Pair{
        int x;int y;
        int cost;
        Pair(int x,int y,int cost)
        {
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    public int reverseEdges(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> modifiedGraph=new ArrayList<>();
        for(int i=0;i<=A;i++)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            modifiedGraph.add(temp);
        }
        for(int i=0;i<B.length;i++)
        {
            int s=B[i][0];
            int d=B[i][1];
            modifiedGraph.get(s).add(d);
            modifiedGraph.get(s).add(0);
            modifiedGraph.get(d).add(s);
            modifiedGraph.get(d).add(1);
        }   
        Collections.sort(modifiedGraph,new Comparator<ArrayList<Integer>>() {
            /* (non-Javadoc)
             * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
             */
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1)-o2.get(1);
            };
        });

    for(ArrayList<Integer> p1:modifiedGraph)
    {
        System.out.println(p1.get(0)+" "+p1.get(1)+" "+p1.get(2));
    }

    return 0;
    }
    public static void main(String[] args) {
        int A=5;
        int B[][]={{1,2},{2,3},{4,3},{4,5}};
        ReverseNodes r=new ReverseNodes();
        r.reverseEdges(A, B);
    }
}