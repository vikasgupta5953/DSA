package com.dev.dsa.advancedsa.twodmatrice;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
		int val=1;
		int L=0;
		int R=n-1;
		int B=n-1;
		int T=0;
		int dir=0;
		int[][] ans=new int[n][n];
		while(L<=R&&T<=B&&val<=n*n)
		{
			if(dir==0)
			{
				for(int i=L;i<=R;i++)
				{
					ans[T][i]=val;
					val++;
				}
				T++;
				dir=1;

				if(dir==1)
				{
					for(int i=T;i<=B;i++)
					{
						ans[i][R]=val;
						val++;
					}
				}
				dir=2;
				R--;
				if(dir==2)
				{
					for(int i=R;i>=L;i--)
					{
						ans[B][i]=val;
						val++;
					}
				}
				B--;
				dir=3;
				if(dir==3)
				{
					for(int i=B;i>=T;i--)
					{
						ans[i][L]=val;
						val++;
					}
				}
				dir=0;
				L++;
			}
		}
		return ans;
	}
    
    public static void main(String[] args) {
        int n=5;
        SpiralMatrixII s=new SpiralMatrixII();
        int[][] ans=s.generateMatrix(n);
        for(int[] a:ans)
        {
            for(int a1:a)
            {
                System.out.print(a1+" ");
            }
            System.out.println();
        }
    }
}