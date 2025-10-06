import java.util.*;
public class Main{
    static int[][] dp;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr=new int[n][m];
        for (int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int x=sc.nextInt();
        int y=sc.nextInt();
        dp=new int[n][m];
        int result=fun(x, y, arr);
        System.out.println(result);
        sc.close();
    }
    static int fun(int i, int j, int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        if(dp[i][j]!=0) return dp[i][j];
        int maxlen=1;
        if(i>0 && arr[i-1][j]<arr[i][j]){
            maxlen=Math.max(maxlen, 1+fun(i-1, j, arr));
        }
        if(i<n-1 && arr[i+1][j]<arr[i][j]){
            maxlen=Math.max(maxlen, 1+fun(i+1, j, arr));
        }
        if(j>0 && arr[i][j-1]<arr[i][j]){
            maxlen=Math.max(maxlen, 1+fun(i, j-1, arr));
        }
        if(j<m-1 && arr[i][j+1]<arr[i][j]){
            maxlen=Math.max(maxlen, 1+fun(i, j+1, arr));
        }
        dp[i][j]=maxlen;
        return maxlen;
    }
}