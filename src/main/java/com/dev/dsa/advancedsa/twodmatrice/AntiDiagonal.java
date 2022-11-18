package com.dev.dsa.advancedsa.twodmatrice;

import java.util.ArrayList;

public class AntiDiagonal {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<2*A.size();i++)
        {
            ArrayList<Integer> alist=new ArrayList<>();
            ans.add(alist);
        }
        for(int i=0;i<A.size();i++)
        {
            for(int j=0;j<A.get(0).size();j++)
            {
                int val=A.get(i).get(j);
                ans.get(i+j).add(val);
            }
        }
        for(int i=0;i<A.size();i++)
        {
            int remainingZeroes=A.get(0).size()-ans.get(i).size();
            while(remainingZeroes>0)
            {
                ans.get(i).add(0);
                remainingZeroes--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<ArrayList<Integer>> alist=new ArrayList<>();
        for(int a[]:arr)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            for(int a1:a)
            {
                temp.add(a1);
            }
            alist.add(temp);
        }

        AntiDiagonal d=new AntiDiagonal();
        ArrayList<ArrayList<Integer>> ans=d.diagonal(alist);
       System.out.println(ans); 
    }
}