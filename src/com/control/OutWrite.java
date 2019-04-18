package com.control;

import java.io.*;
import java.lang.System.*;
import java.util.ArrayList;

public class OutWrite {

    private String computeScore;
    private String outputString;

    public void Write(String name, int score){

        computeScore = Integer.toString(score);
        outputString = name + " " + computeScore + "\n";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Highscores.txt", true));
            writer.write(outputString);
            writer.close();

        } catch(IOException e){
            e.printStackTrace();
        }


    }


}
