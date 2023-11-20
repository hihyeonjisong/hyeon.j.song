package practice231106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class consolecolor {
	public static void main(String [] args) throws IOException {



        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.print("TEXT : ");
            String massge = bf.readLine();

            if("x".equals(massge)) return;


            System.out.print("\nColor : ");
            String color = bf.readLine();

            logMassge(massge, color);
            

        }
    }

    public static void logMassge(String massge, String color){
        if     ("Black".equals(color) || "black".equals(color))         color = black;
        else if("Red".equals(color) || "red".equals(color))             color = red;
        else if("Green".equals(color) || "green".equals(color))         color = green;
        else if("Yellow".equals(color) || "yellow".equals(color))       color = yellow;
        else if("Blue".equals(color) || "blue".equals(color))           color = blue;
        else if("Purple".equals(color) || "purple".equals(color))       color = purple;
        else if("Cyan".equals(color) || "cyan".equals(color))           color = cyan;
        else color = white;


        System.out.println(color+massge);
    }
}
