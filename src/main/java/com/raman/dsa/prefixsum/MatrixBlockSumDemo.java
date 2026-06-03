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

        public static void main(String[] args) {
            int[][] mat = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            int k = 1;

            MatrixBlockSumDemo sol = new MatrixBlockSumDemo();
            int[][] result = sol.matrixBlockSumBrute(mat, k);

            System.out.println("Matrix Block Sum:");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }


}
