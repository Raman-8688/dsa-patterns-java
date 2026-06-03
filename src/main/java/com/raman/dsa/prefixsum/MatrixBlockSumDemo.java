package com.raman.dsa.prefixsum;

public class MatrixBlockSumDemo {


    public int[][] matrixBlockSumBrute(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int [] [] answer =new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum=0;
                for(int r=i-k;r<=i+k;r++){
                    for(int c=j-k;c<=j+k;c++){
                        if(r>=0 && r<m && c>=0 && c<n){
                            sum+=mat[r][c];
                        }
                    }
                }
                answer[i][j]=sum;
            }
        }
        return answer;

    }

    public int[][] matrixBlockSumOptimal(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int [] [] answer =new int[m][n];
        /*for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum=0;
                for(int r=i-k;r<=i+k;r++){
                    for(int c=j-k;c<=j+k;c++){
                        if(r>=0 && r<m && c>=0 && c<n){
                            sum+=mat[r][c];
                        }
                    }
                }
                answer[i][j]=sum;
            }
        }
        return answer;*/
        int[][] prefix = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                prefix[i][j]=mat[i-1][j-1]
                        + prefix[i-1][j]
                        + prefix[i][j-1]
                        -prefix[i-1][j-1];
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r1=Math.max(0,i-k);
                int c1=Math.max(0,j-k);
                int r2=Math.min(m-1,i+k);
                int c2=Math.min(n-1,j+k);
                r1++;
                c1++;
                r2++;
                c2++;
                answer[i][j] = prefix[r2][c2]
                        -prefix[r1-1][c2]
                        -prefix[r2][c1-1]
                        + prefix[r1-1][c1-1];
            }
        }
        return answer;

    }


    public static void main(String[] args) {
            int[][] mat = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            int k = 1;

            MatrixBlockSumDemo sol = new MatrixBlockSumDemo();
            int[][] result = sol.matrixBlockSumBrute(mat, k);

            System.out.println("Matrix Block Sum Brute:");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
            int[][] result1 = sol.matrixBlockSumOptimal(mat, k);
            System.out.println("Matrix Block Sum Optimal:");
            for (int i = 0; i < result1.length; i++) {
                for (int j = 0; j < result1[0].length; j++) {
                    System.out.print(result1[i][j] + " ");
                }
                System.out.println();
            }
        }


}
