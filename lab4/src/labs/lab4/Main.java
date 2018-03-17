package labs.lab4;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static String path = "example.txt";

    private static StringBuffer getString(String path){
        // reads text from given file, returns StringBuffer object
        Scanner in;
        StringBuffer string;
        try {
            in = new Scanner(new File(path));
            string = new StringBuffer();
            while (in.hasNext()){
                string.append(in.nextLine()).append(' ');
            }
            return string;
        } catch (FileNotFoundException e) {
            return new StringBuffer();
        }
    }


    public static void main(String[] args) throws Exception{
        Text text = Text.textParser(getString(path));
        System.out.println(text);
        }
    }

