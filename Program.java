
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert
 */
public class Program {
    public static int[][] myMatrix;
    //public static int rows,cols;
    public static void drawSnake(String in, int numSnake, int[][] matrix){
      String[] coord = in.split(" ");
      for(int j=0;j<coord.length-1;j++)
        drawLine(myMatrix,coord[j],coord[j+1],numSnake);  
    }
    
     public static void drawLine(int[][] matrix, String s1,String s2, int snakenum){
     String[] p1 = s1.split(",");
     int[] intp1 = new int[p1.length];
     for(int p =0;p<p1.length;p++)
       intp1[p]=Integer.parseInt(p1[p]);
     String[] p2 = s2.split(",");
     int[] intp2 = new int[p2.length];
     for(int p =0;p<p2.length;p++)
       intp2[p]=Integer.parseInt(p2[p]);
     
     myMatrix[intp1[0]][intp1[1]] = snakenum;
     myMatrix[intp2[0]][intp2[1]] = snakenum;
     int corrx,corry;
     int minx= Min(intp1[0],intp2[0]);
      if (minx==intp1[0])
          corry=intp1[1];
      else corry = intp2[1];
     int maxx= Max(intp1[0],intp2[0]);  
     int miny =Min(intp1[1],intp2[1]);
     if (miny==intp1[1])
          corrx=intp1[0];
     else corrx =intp2[0];
     int maxy = Max(intp1[1],intp2[1]);
    
     for(int i=minx;i<maxx+1;i++)
       {
         myMatrix[i][corry]=snakenum;
         corrx = i;
       }
     for(int i=miny;i<maxy+1;i++)
         myMatrix[corrx][i]=snakenum;
     
   
    }
    public static void printBoard(int[][] Board){
        
        int r = Board.length;
        int c = Board.length;
        
        String[] out = new String[r];
        for (int i =0;i<r;i++){
           out[i] = ""+Board[0][i];
           for(int j =1;j<c;j++){
             out[i] += " "+Board[j][i];     
           }
         }
        for(int p=0;p<r;p++)
            System.out.println(out[p]);

    }
    public static int Min(int a,int b){
      if (a<b)
          return a;
      else return b;           
    }
    public static int Max(int a,int b){
     if (a>b)
         return a;
     else return b;
    }
     public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("enter");
        Scanner in = new Scanner(System.in);
        String s;
        s = in.nextLine();
        String[] out = s.split(" ");
        int[] intArray = new int[4];
        for (int i = 0; i < 3; i++) {
          intArray[i] = Integer.parseInt(out[i]);
        }
        int col = intArray[1];
        int row = intArray[2];
         
        //rows = row;
        //cols = col;
       myMatrix = new int[col][row];
        // myMatrix = new int[col][row];
       for(int i = 0; i<row; i++)
         for(int j = 0; j<col; j++)
        myMatrix[j][i] = 0;
         
       for(int i=1;i<intArray[0]+1;i++){
           //System.out.println("Enter line");
           s=in.nextLine();

           drawSnake(s, i, myMatrix);
       }
        printBoard(myMatrix);
    }
}
