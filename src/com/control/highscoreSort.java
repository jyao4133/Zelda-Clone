package com.control;

import java.util.ArrayList;

public class highscoreSort {

    public ArrayList listSort(ArrayList<String> unsortedScore){

        int N = unsortedScore.size();
        int E = N-1;
        String temp;
        boolean sorted = true;

        while(sorted == true){
            sorted=false;

            for(int a = 0 ; a < E ; a++){
                if(Integer.parseInt(unsortedScore.get(a).substring(unsortedScore.get(a).indexOf(" ")+1)) >
                        Integer.parseInt(unsortedScore.get(a+1).substring(unsortedScore.get(a+1).indexOf(" ")+1))) {

                    temp=unsortedScore.get(a);
                    unsortedScore.set(a, unsortedScore.get(a+1));
                    unsortedScore.set(a+1, temp);

                    sorted=true;
                }
            }
            E--;
        }

        return unsortedScore;
    }

}
