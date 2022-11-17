package com.dev.dsa.advancedsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMaze {
   
        class Pair{
            int i;
            int j;
            int len;
            Pair(int i,int j,int len)
            {
                this.i=i;
                this.j=j;
                this.len=len;
            }
        }
        
        public int shortestPathBinaryMatrix(int[][] grid) {
        
            if(grid[0][0]==1||grid[grid.length-1][grid.length-1]==1)return -1;
            if(grid.length==1&&grid[0][0]==0)return 1;
            int[] dx={-1, -1, 1, 1, -1, 1, 0, 0};
            int[] dy={-1,  1, -1, 1, 0, 0, 1, -1};
            
            Queue<Pair> q=new LinkedList<>();
            
            q.add(new Pair(0,0,1));
            
            grid[0][0]=-1;
            
            while(!q.isEmpty())
            {
                Pair p=q.remove();
                for(int i=0;i<dx.length;i++)
                {
                    int newx=p.i+dx[i];
                    int newy=p.j+dy[i];
                    if(newx==grid.length-1&&newy==grid[0].length-1)
                    {
                        return p.len+1;
                    }
                    if(newx>=0&&newx<grid.length&&newy>=0&&newy<grid[0].length&&grid[newx][newy]==0)
                    {
                        grid[newx][newy]=-1;
                        q.add(new Pair(newx,newy,p.len+1));
                    }
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            int inputArr[][]={{0,0,0},{1,1,0},{1,1,0}};
            ShortestPathInMaze s=new ShortestPathInMaze();
           int ans= s.shortestPathBinaryMatrix(inputArr);
           System.out.println(ans);

        }
    }
