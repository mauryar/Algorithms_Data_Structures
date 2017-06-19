/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiply;

import java.util.*;

/**
 *
 * @author rajan
 */


   
    public class MatrixMultiply {

        
    private static int[][] b;
    private static int[][] c;
    Random r, r1;
    private static int n;
    private static int[][] a;
    

    public static int [][] traditionalMultiply(int[][] mat1, int[][] mat2)
    {
        int row,col;

        for(row=0;row<mat1.length;row++)
        {
            for(col =0; col<mat1.length;col++)
            {   c[row][col]=0;
                for(int k = 0;k<mat1.length;k++)
                {
                    c[row][col] += mat1[row][k] * mat2[k][col];
                }
            }
        }

        return c;
      
    }

    public static int [][] matrixAddStrassenAlgo(int [][] mat1, int [][] mat2)
    {
        int sizeMat = mat1.length;

        int [][] finalMatrix = new int[sizeMat][sizeMat];

        for(int i=0; i<sizeMat; i++)
            for(int j=0; j<sizeMat; j++)
                finalMatrix[i][j] = mat1[i][j] + mat2[i][j];

        return finalMatrix;
    }
    
    
    public static int [][] MultiplyStrassenAlgo(int [][] mat1, int [][] mat2)
    {
        int LEAF_SIZE = 16;
        int n = mat1.length;
        int [][] result = new int[n][n];

        if((n%2 != 0 ) && (n !=1))
        {
            int[][] a1, b1, c1;
            int n1 = n+1;
            a1 = new int[n1][n1];
            b1 = new int[n1][n1];
            c1 = new int[n1][n1];

            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                {
                    a1[i][j] =mat1[i][j];
                    b1[i][j] =mat2[i][j];
                }
            c1 = MultiplyStrassenAlgo(a1, b1);
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    result[i][j] =c1[i][j];
            return result;
        }

        if(n == LEAF_SIZE)
        {
            result[0][0] = mat1[0][0] * mat2[0][0];
            return result;
        }
        else
        {
            int [][] A11 = new int[n/2][n/2];
            int [][] A12 = new int[n/2][n/2];
            int [][] A21 = new int[n/2][n/2];
            int [][] A22 = new int[n/2][n/2];

            int [][] B11 = new int[n/2][n/2];
            int [][] B12 = new int[n/2][n/2];
            int [][] B21 = new int[n/2][n/2];
            int [][] B22 = new int[n/2][n/2];

            matrixDivideStrassenAlgo(mat1, A11, 0 , 0);
            matrixDivideStrassenAlgo(mat1, A12, 0 , n/2);
            matrixDivideStrassenAlgo(mat1, A21, n/2, 0);
            matrixDivideStrassenAlgo(mat1, A22, n/2, n/2);

            matrixDivideStrassenAlgo(mat2, B11, 0 , 0);
            matrixDivideStrassenAlgo(mat2, B12, 0 , n/2);
            matrixDivideStrassenAlgo(mat2, B21, n/2, 0);
            matrixDivideStrassenAlgo(mat2, B22, n/2, n/2);

            int [][] P1 = MultiplyStrassenAlgo(matrixAddStrassenAlgo(A11, A22), matrixAddStrassenAlgo(B11, B22));
            int [][] P2 = MultiplyStrassenAlgo(matrixAddStrassenAlgo(A21, A22), B11);
            int [][] P3 = MultiplyStrassenAlgo(A11, matrixSubStrassenAlgo(B12, B22));
            int [][] P4 = MultiplyStrassenAlgo(A22, matrixSubStrassenAlgo(B21, B11));
            int [][] P5 = MultiplyStrassenAlgo(matrixAddStrassenAlgo(A11, A12), B22);
            int [][] P6 = MultiplyStrassenAlgo(matrixSubStrassenAlgo(A21, A11), matrixAddStrassenAlgo(B11, B12));
            int [][] P7 = MultiplyStrassenAlgo(matrixSubStrassenAlgo(A12, A22), matrixAddStrassenAlgo(B21, B22));

            int [][] C11 = matrixAddStrassenAlgo(matrixSubStrassenAlgo(matrixAddStrassenAlgo(P1, P4), P5), P7);
            int [][] C12 = matrixAddStrassenAlgo(P3, P5);
            int [][] C21 = matrixAddStrassenAlgo(P2, P4);
            int [][] C22 = matrixAddStrassenAlgo(matrixSubStrassenAlgo(matrixAddStrassenAlgo(P1, P3), P2), P6);

            matrixCopyStrassenAlgo(C11, result, 0 , 0);
            matrixCopyStrassenAlgo(C12, result, 0 , n/2);
            matrixCopyStrassenAlgo(C21, result, n/2, 0);
            matrixCopyStrassenAlgo(C22, result, n/2, n/2);
        }
        return result;
    }

    

    public static int [][] matrixSubStrassenAlgo(int [][] mat1, int [][] mat2)
    {
        int sizeMat = mat1.length;

        int [][] finalMatrix = new int[sizeMat][sizeMat];

        for(int i=0; i<sizeMat; i++)
            for(int j=0; j<sizeMat; j++)
                finalMatrix[i][j] = mat1[i][j] - mat2[i][j];

        return finalMatrix;
    }

    

    


    public static void matrixDisplay(int [][] matrixToDisplay)
    {
        int sizeMat = matrixToDisplay.length;

        System.out.println();
        for(int i=0; i<sizeMat; i++)
        {
            for(int j=0; j<sizeMat; j++)
            {
                System.out.print(matrixToDisplay[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void matrixCopyStrassenAlgo(int[][] mat1, int[][] mat2, int m1, int m2)
    {
        for(int m3 = 0, m4=m1; m3<mat1.length; m3++, m4++)
            for(int m5 = 0, m6=m2; m5<mat1.length; m5++, m6++)
            {
                mat2[m4][m6] = mat1[m3][m5];
            }
    }

    public static long reDirectAlgoApproach(int matrixSize)
    {   Random getNewData1 = new Random(10000);
        Random getNewData2 = new Random(1000);
        
        a = new int[matrixSize][matrixSize];
        b = new int[matrixSize][matrixSize];
        c = new int[matrixSize][matrixSize];
        int[][] newArr1 = new int[matrixSize][matrixSize];
        int[][] newArr2T=new int[matrixSize][matrixSize];
        int i,j;
        for(i=0;i<matrixSize;i++)
        {
            for(j =0; j<matrixSize;j++)
            {
                a[i][j] = getNewData1.nextInt(10000);
                b[i][j] = getNewData2.nextInt(1000);
            }
        }

        
        long executionStart = System.currentTimeMillis();
        if(matrixSize<512)
        {
            newArr2T =  traditionalMultiply(a,b);
            System.out.print("Traditional method execution time in ms: ");
        }
        else
        {
            newArr1 = MultiplyStrassenAlgo(a,b);
            System.out.print("Strassen matrix multiplication execution time in ms:");
        }
        final long executionTime = System.currentTimeMillis() - executionStart;
        return executionTime;
    }


    public static long selectMatrixSize()
    {
        long executionStart=0;
         long executioDurationTraditional=0;
         long executionDurationStrassen=0;
        for(int matSize=1;matSize<10000;matSize=matSize*2)
        { System.out.println("No. of inputs:" +matSize);
            Random newData1 = new Random(10000);
            Random newData2 = new Random(1000);
            
            a = new int[matSize][matSize];
            b = new int[matSize][matSize];
            c = new int[matSize][matSize];
            int[][] newArrS = new int[matSize][matSize];
            int[][] newArrT=new int[matSize][matSize];
            int i,j;
            for(i=0;i<matSize;i++)
            {
                for(j =0; j<matSize;j++)
                {
                    a[i][j] = newData1.nextInt(10000);
                    b[i][j] = newData2.nextInt(1000);
                }
            }


            executionStart = System.currentTimeMillis();
            newArrT=traditionalMultiply(a,b);
            executioDurationTraditional = System.currentTimeMillis() - executionStart;
            System.out.println("Traditional execution time in milliseconds: "+executioDurationTraditional);

            if(matSize>16)
            {executionStart = System.currentTimeMillis();
            newArrS = MultiplyStrassenAlgo(a,b);
        executionDurationStrassen= System.currentTimeMillis() - executionStart;
        System.out.println("Strassen matrix multiplication execution time in ms:"+executionDurationStrassen);}
        else
            {System.out.println("Matrix division not happening: Ignored Strassen matrix multiplication");}

        if(executioDurationTraditional>executionDurationStrassen && n>16)
        {return matSize;}

        }

        return -1;

    }
    public static void main(String[] args) {
        System.out.println("1 Traditional algorithm \n" +
                "2 Strassen’s matrix multiplication \n" +
                "3 Break point\n" +
                "4 Improved algorithm");
        Scanner sc = new Scanner(System.in);
        int perform = sc.nextInt();
      if(perform==1)
     {   Random getNewData1 = new Random(10000);
         Random getNewData2 = new Random(1000);
         
         System.out.println("Give size of matrix");
         int matSize = sc.nextInt();
         a = new int[matSize][matSize];
         b = new int[matSize][matSize];
         c = new int[matSize][matSize];
         int[][] arr = new int[matSize][matSize];
         int i,j;
         for(i=0;i<matSize;i++)
         {
             for(j =0; j<matSize;j++)
             {
                 a[i][j] = getNewData1.nextInt(10000);
                 b[i][j] = getNewData2.nextInt(1000);
             }
         }
         long startTimeR = System.currentTimeMillis();
         arr= traditionalMultiply(a,b);
        final long durationR = System.currentTimeMillis() - startTimeR;
        System.out.println("Traditional execution time in ms: "+durationR);
       matrixDisplay(arr);

     }else if(perform==2)
      {Random getNewData1 = new Random(10000);
          Random getNewData2 = new Random(1000);
          
          n=16;
          a = new int[n][n];
          b = new int[n][n];
          c = new int[n][n];
          int[][] arr = new int[n][n];
          int i,j;
          for(i=0;i<n;i++)
          {
              for(j =0; j<n;j++)
              {
                  a[i][j] = getNewData1.nextInt(10000);
                  b[i][j] = getNewData2.nextInt(1000);
              }
          }
          long startTime = System.currentTimeMillis();
            arr = MultiplyStrassenAlgo(a,b);
         final long duration = System.currentTimeMillis() - startTime;
       System.out.println("Strassen matrix multiplication execution time in ms: "+duration);
         matrixDisplay(arr);
          System.out.println("Matrix 1");
          matrixDisplay(a);
          System.out.println("Matrix 2");
          matrixDisplay(b);
      }
       else if(perform==3)
        {
            long breakpoint=selectMatrixSize();
            System.out.print("The breakpoint identified is: "+breakpoint+" ");
        }
        else if(perform==4)
        {System.out.print("Give matrix size");
            int size = sc.nextInt();
            long duration=reDirectAlgoApproach( size);
            System.out.print("Overall duration is:  "+duration);
        }
    }
    
    
    public static void matrixDivideStrassenAlgo(int[][] matrix1, int[][] matrix2, int m1, int m2)
    {
        for(int mat1 = 0, mat2=m1; mat1<matrix2.length; mat1++, mat2++)
            for(int mat3 = 0, mat4=m2; mat3<matrix2.length; mat3++, mat4++)
            {
                matrix2[mat1][mat3] = matrix1[mat2][mat4];
            }
    }
    
}
