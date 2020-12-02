package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {


    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        try {
            File myObj = new File("C:\\Users\\Robbe\\IdeaProjects\\AdventOfCode\\2020\\src\\Day1\\numbers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data != null){
                    numbers.add(Integer.parseInt(data));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        int iteration = 0;
        for(int number : numbers){
            int secondparse = 0;
            for(int number2 : numbers){
                if(iteration == secondparse){}
                else{
                    if((number + number2) == 2020){
                        System.out.println(number*number2);
                    }
                }
                secondparse +=1;
            }
            iteration += 1;
        }
        iteration = 0;
        for(int number : numbers){
            int secondparse = 0;
            for(int number2 : numbers){
                int thirdparse = 0;
                for(int number3 : numbers){
                    if(iteration == secondparse && iteration == thirdparse && secondparse == thirdparse){}
                    else {
                        if ((number + number2 + number3) == 2020) {
                            System.out.println(number * number2 * number3);
                        }
                    }
                    thirdparse += 1;
                }
                secondparse +=1;
            }
            iteration += 1;
        }
    }
}
