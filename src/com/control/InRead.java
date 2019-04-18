package com.control;
import java.io.*;
import java.lang.System.*;
import java.util.ArrayList;


public class InRead {


    public ArrayList<String> read(ArrayList scoreLis){
    String indexString;

        try {

            FileReader fr = new FileReader("Highscores.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((indexString = br.readLine()) != null){
                scoreLis.add(indexString);
            }

            br.close();


        }catch (IOException e) {
            e.printStackTrace();
        }



        return scoreLis;
    }
}
