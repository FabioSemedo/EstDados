package Prac3;
import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matriz
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }
   
   public static Matrix identity(int n){
        Matrix mat = new Matrix(n,n);
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if(i==j){
                    mat.data[i][j] = 1;
                }else{
                    mat.data[i][j] = 0;
                }
            }
        }
        return mat;
   }
   public Matrix transpose(){
    Matrix mat = new Matrix(this.cols,this.rows);
        for(int i =0; i<this.rows; i++){ //in every row
            for(int j=i; j< this.cols; j++){// at this element
                mat.data[j][i] = this.data[i][j];
            }
        }
      return mat;
   }

    public Matrix sum(Matrix m){
      for(int i = 0; i<this.rows; i++){
        for(int j=0; j<this.cols; j++){
            m.data[i][j] += this.data[i][j];
        }
      }
      return m;
    }

   public Matrix multiply(Matrix m){
    // this.cols = m.rows
    int a=0;
    String terms = "";
    Matrix res = new Matrix(this.rows, m.cols);

    for(int i=0; i< this.rows; i++){
        for(int j = 0; j< m.cols; j++){
            for(int k=0; k< this.cols; k++){
                res.data[i][j] += this.data[i][k]* m.data[k][j]; 
            }
        }
    }
    
    return res;
   }
   
}

