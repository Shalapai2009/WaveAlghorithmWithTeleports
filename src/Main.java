import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferRead br1 =  new BufferRead(new BufferedReader(new FileReader("field.txt")));


        /*Cell[][] Labyrinth9X9 = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i  == 0 | j==0) | (i == 8 | j ==8)) {
                    Labyrinth9X9[i][j] = new Cell(-1, Cell.Type.FULL);
                } else {
                    Labyrinth9X9[i][j] = new Cell(0, Cell.Type.EMPTY);
                }
            }
        }*/

        Labyrinth labyrinth = br1.doMagic();

        System.out.println(labyrinth.getShortestWayTest());
        labyrinth.printThis();
        labyrinth.printColor();
        /*labyrinth.setStart(1,1);
        labyrinth.setFinish(7,7);
        labyrinth.getCell(3,1).doCellFull();
        labyrinth.getCell(1,3).doCellFull();
        //labyrinth.SpawnEntryAndExit(2,2,6,6);
        labyrinth.getShortestWayTest();
        printColor(labyrinth.getLabyrinth());
        System.out.println("Hello world!");
        printThis(labyrinth.getLabyrinth());*/
    }

    public static void printThis(Cell[][] laburinth){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 8){
                    System.out.print(laburinth[i][j].getPosition()+" ");
                    System.out.println();
                } else
                    if (laburinth[i][j].getPosition() == -1){
                    System.out.print(laburinth[i][j].getPosition()+" ");}
                    else {
                        System.out.print(" "+laburinth[i][j].getPosition()+" ");
                    }
            }
        }
    }
    public static void printColor(Cell[][] laburinth){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 8){
                   if  (laburinth[i][j].getColor() == Cell.Paint.NOTSHADED){
                        System.out.print("N"+" ");
                    } else {System.out.print("S"+" ");}
                    System.out.println();
                } else{
                    if  (laburinth[i][j].getColor() == Cell.Paint.NOTSHADED){
                        System.out.print("N"+" ");
                    } else {System.out.print("S"+" ");}
                }
            }
        }
    }


}