package com.company;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        loop();
    }

    public static void loop(){
        Filereader fr = new Filereader();
        UI ui = new UI();
        if(fr.checkAndCreateStartFile())
        {
            ui.printUI(ui.getOutput(fr.getLineContent(fr.getLinelist())));
        }

        int in = 0;
        while(in != -1){
            in = readIntForArray(">");
            if(in < fr.getLineContent(fr.getLinelist()).length){
                try{
                    Desktop dt = java.awt.Desktop.getDesktop();
                    URI url = new URI(fr.getLink(in, fr.getLineContent(fr.getLinelist())));
                    dt.browse(url);
                } catch (Exception e){
                    System.out.println("Website '"+ fr.getLineContent(fr.getLinelist())[in][2] + "' not found");
                }
            }
        }
    }

    public static int readIntForArray(String str){
        System.out.print(str);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            return (Integer.parseInt(br.readLine()) - 1);
        } catch(Exception e){
            System.out.print("not a valid input");
            return 0;
        }
    }
}
