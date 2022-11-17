package com.dev.dsa.advancedsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInMaze2 {
    class Pair{
        int i;
        int j;
        int dist;
        Pair(int i,int j,int dist)
        {
            this.i=i;
            this.j=j;
            this.dist=dist;
        }
    }

    int dx[]={1,0,-1,0};
    int dy[]={0,1,0,-1};
    public int solve(int[][] A, int[] B, int[] C) {
        int distance[][]=new int[A.length][A[0].length];
        if(C[0]==B[0]&&C[1]==B[1])return 0;
        for(int i=0;i<distance.length;i++)
        {
            for(int j=0;j<distance[0].length;j++)
            {
                distance[i][j]=(int)1e9;
            }
        }
        distance[B[0]][B[1]]=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(B[0],B[1],0));


        while(!q.isEmpty())
        {
            Pair p=q.remove();
            for(int i=0;i<4;i++)
            {
                int newx=p.i+dx[i];
                int newy=p.j+dy[i];

                int dist=0;
                while(newx>=0&&newy>=0&&newx<A.length&&newy<A[0].length&&A[newx][newy]!=1)
                {
                    newx+=dx[i];
                    newy+=dy[i];
                    dist++;
                }
                newx-=dx[i];
                newy-=dy[i];


                if(p.dist+dist < distance[newx][newy]) {
                    q.add(new Pair(newx, newy,p.dist+dist));
                    distance[newx][newy]=p.dist+dist;
                }

            }
        }

        return (distance[C[0]][C[1]] == (int)1e9) ? -1 : distance[C[0]][C[1]];
    }

    public static void main(String[] args) {
        int inputArr[][]={{1,1,0,1},{0,0,0,1},{1,0,0,1},{0,0,1,0}};
        int B[]={1,1};
        int C[]={2,1};
        ShortestDistanceInMaze2 s=new ShortestDistanceInMaze2();
        int ans=s.solve(inputArr, B, C);
        System.out.println(ans);
    }
}