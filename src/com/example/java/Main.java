package com.example.java;

import java.io.*;


public class Main {
    public static void main(String args[]) {
        findString("aan");
    }

    public static void findString(String keyWord){
        try {

            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Eppo\\Desktop\\Project OOP\\OOP3\\Boggle\\dict.txt"));
            int linecount = 0;  //Counter to keep track of the line number
            String line;        //String to keep track of the line contents


            // Loop through each line, stashing the line into our line variable.
            while (( line = bf.readLine()) != null)
            {
                // Increment the count and find the index of the word
                linecount++;

                if(line.equals(keyWord)){
                    System.out.println(keyWord);
                }
            }



            // Close the file after done searching
            bf.close();
        }
        catch (IOException e) {
            System.out.println("IO Error Occurred: " + e.toString());
        }
    }
}




