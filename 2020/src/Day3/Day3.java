package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day3 {


    public static void main(String[] args){
        ArrayList<List<String>> matrix = new ArrayList<List<String>>();
        int widthX = 0;
        boolean ranOnce = false;
        try {
            File myObj = new File("C:\\Users\\Robbe\\IdeaProjects\\AdventOfCode\\2020\\src\\Day3\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data != null){
                    List<String> letters = Arrays.asList(data.split(""));
                    matrix.add(letters);
                    if (ranOnce == false){
                        widthX = letters.size() -1;
                        ranOnce = true;
                    }

                }
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int multipliedCount = 1;

        multipliedCount *= countTrees(1, 1, widthX, matrix);
        multipliedCount *= countTrees(3, 1, widthX, matrix);
        multipliedCount *= countTrees(5, 1, widthX, matrix);
        multipliedCount *= countTrees(7, 1, widthX, matrix);
        multipliedCount *= countTrees(1, 2, widthX, matrix);

        System.out.println("Multiplied Count: " + multipliedCount);



    }

    private static int countTrees(int slopeX, int slopeY, int widthX, ArrayList<List<String>> matrix){
        int relativeX = 0;
        int absoluteY = 0;

        int treeCount = 0;
        int freeCount = 0;

        String treeSymbol = "#";
        String freeSymbol = ".";


        for(List<String> currentLine: matrix) {

            if(widthX < relativeX){
                relativeX = relativeX - widthX -1; // -1 for correcting each repetition
            }
            if (absoluteY % slopeY == 0) { //Check for right Y-coordinate
                if(currentLine.get(relativeX).equals(treeSymbol)){
                    treeCount += 1;
                }else if(currentLine.get(relativeX).equals(freeSymbol)){
                    freeCount += 1;
                }
                //System.out.print(absoluteY + ": " + relativeX + " --> " + currentLine.get(relativeX) + " --> " + currentLine); // DEBUGGER
                relativeX += slopeX;
            }
            absoluteY += 1;
        }
        System.out.println("For slope x: "+ slopeX + " y: " + slopeY);
        System.out.println("Trees Counted: " + treeCount);
        System.out.println("Free Space Counted: " + freeCount);
        return treeCount;
    }
}
