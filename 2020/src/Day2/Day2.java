package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args){
        ArrayList<List<String>> list = new ArrayList<List<String>>();
        try {
            File myObj = new File("C:\\Users\\Robbe\\IdeaProjects\\AdventOfCode\\2020\\src\\Day2\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data != null){
                    List data2 = Arrays.asList(data.split(" "));
                    list.add(data2);

                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int valid = 0;

        for(List<String> item: list){
            String[] limits = item.get(0).split("-");
            int innerLimit = Integer.parseInt(limits[0]);
            int outerLimit = Integer.parseInt(limits[1]);
            String character = item.get(1);
            character = character.substring(0, character.length() -1);
            String password = item.get(2);
            int counter = 0;
            for(Character ctr: password.toCharArray()){
                if(character.toCharArray()[0] == ctr){
                    counter += 1;
                }
            }
            if(innerLimit <= counter && counter <= outerLimit){
                valid += 1;
            }
        }
        System.out.println("Valid Part 1: " + valid);

        valid = 0;

        for(List<String> item: list){
            String[] limits = item.get(0).split("-");
            int innerLimit = Integer.parseInt(limits[0]);
            int outerLimit = Integer.parseInt(limits[1]);
            String character = item.get(1);
            character = character.substring(0, character.length() -1);
            String password = item.get(2);
            int counter = 0;
            char char1 = password.charAt(innerLimit-1);
            char char2 = password.charAt(outerLimit-1);
            if(char1 != char2 && (char1 == character.toCharArray()[0] || char2 == character.toCharArray()[0])){
                valid +=1;
            }
        }
        System.out.println("Valid Part 2:" + valid);

    }
}

