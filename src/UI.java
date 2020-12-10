package com.company;

import java.util.ArrayList;

public class UI {
    private final String SEPERATOR = "---------------------------------------------------------\n";

    public void printUI(String output){
        System.out.print(output);
    }

    public String getOutput(String[][] list){
        String out = "----------------------CLASS FINDER-----------------------\n";
        for(int i = 0; i < list.length; i++){
            if(list[i][0].equals("!-")){
                out += SEPERATOR;
            }
            else{
                out += (i+1) + "- " + list[i][0] + " | " + list[i][1] + "\n";
            }
        }
        return out + SEPERATOR;
    }
}
