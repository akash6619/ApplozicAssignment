package com.applozic.parser.main;

import com.applozic.parser.Parser.LocationParser;
import com.applozic.parser.Parser.TimeParser;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static Scanner sc=new Scanner(System.in);


    public static void main(String[] args) {
        try {
            LocationParser locationParser = new LocationParser();
            TimeParser timeParser = new TimeParser();

            System.out.println("Enter Input text or \"end\" to terminate :--");
            while(true){
                String text = sc.nextLine();
                if(text.toLowerCase().equals("end")) break;
                locationParser.parseTextForLocation(text);
                timeParser.parseTextForDate(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
