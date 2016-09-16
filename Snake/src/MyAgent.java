/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import za.ac.wits.snake.DevelopmentAgent;



public class MyAgent extends DevelopmentAgent {
    public static int[][] Matrix;
    public int me = 1;
    public int open = 0;
    public int apple =9;
    
    public static void main(String args[]) throws IOException {
        MyAgent agent = new MyAgent();
        MyAgent.start(agent, args);
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String initString = br.readLine();
            String[] temp = initString.split(" ");
            int nSnakes = Integer.parseInt(temp[0]);
            int w = Integer.parseInt(temp[1]);
            int h = Integer.parseInt(temp[2]);
            Matrix = new int[w][h];
            for(int i = 0; i<w; i++)
              for(int j = 0; j<h; j++)
                 Matrix[j][i] = 0;
            int mode = Integer.parseInt(temp[3]);
            while (true) {
                String line = br.readLine();
                if (line.contains("Game Over")) {
                    break;
                }
                String apple1 = line;
                String[] app1 = apple1.split(" ");
                addApple(Integer.parseInt(app1[0]),Integer.parseInt(app1[1]));
                String apple2 = br.readLine();
                String[] app2 = apple2.split(" ");
                addApple(Integer.parseInt(app2[0]),Integer.parseInt(app2[1]));
                //do stuff with apples//add to matrix
                for (int i = 0; i < 3; i++) {
                    String zombie = br.readLine();
                    //use drawsnake
                }
                int mySnakeNum = Integer.parseInt(br.readLine());
                for (int i = 0; i < nSnakes; i++) {
                    String snakeLine = br.readLine();
                    String[]tmp = snakeLine.split(" ");
                    for (int j=0;j<4;j++)
                       tmp = removeElement(tmp,0);
                    
                    if (i == mySnakeNum) {
                        //hey! That's me :) drawsnake with 1
                    }
                    else{}//draw other snakes with same number
                    //do stuff with snakes
                }
                //finished reading, calculate move:
                System.out.println("log calculating...");
                int move = new Random().nextInt(4);
                System.out.println(move);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void addApple(int appx, int appy){
      Matrix[appx][appy] = 9;
    } 
    private static String[] removeElement(String[] arr, int idx){
       for (int k=idx;k<arr.length-1;k++)
           arr[k]=arr[k+1];
       int n = arr.length-1;
       String[] x = new String[n];
       for(int i=0;i<n;i++)
           x[i]=arr[i];
       return x;
    }
}
