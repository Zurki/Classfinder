package com.company;

import java.io.*;
import java.util.ArrayList;
import java.awt.Desktop;

public class Filereader{
    private final File file = new File("link.cf");

    public File getFile() {
        return file;
    }

    public boolean checkAndCreateStartFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("Started the program for the first time.\n please change 'link.cf' file and restart the program");

                FileWriter fw = new FileWriter(file);

                fw.write("Encoding: [Class], [Professor], [Hyperlink] | For speratorline -> '!-'");
                fw.flush();
                fw.close();

                Desktop dt = Desktop.getDesktop();
                if(!Desktop.isDesktopSupported()){
                    System.out.println("Could not open " + file.getPath());
                }
                else{
                    dt.open(file);
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public ArrayList<String> getLinelist() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("link.cf"));
            br.readLine();
            String line = null;

            ArrayList<String> ll = new ArrayList<String>();

            while ((line = br.readLine()) != null) {
                ll.add(line);
            }
            return ll;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[][] getLineContent(ArrayList<String> ll){
        String[] str = new String[ll.size()];
        ll.toArray(str);

        String[][] outputStr = new String[str.length][3];
        for(int i=0; i<str.length; i++){
            String[] parts = str[i].split(", ");

            System.arraycopy(parts, 0, outputStr[i], 0, parts.length);
        }
        return outputStr;
    }

    public String getLink(int line, String[][] str){
        return str[line][2];
    }
}
