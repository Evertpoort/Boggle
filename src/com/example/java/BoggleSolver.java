package com.example.java;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.List;

/**
 * Created by Eppo on 24-3-2017.
 * Boggle
 *
 * Werkt nog niet erg goed, aangezien hij niet bijhoudt welke tiles benaderd zijn..
 * Wordt aan gewerkt
 *
 * Referentie gebruikt: http://codereview.stackexchange.com/questions/33045/boggle-solver-in-java
 */
public class BoggleSolver {

    private static final NavigableSet<String> dictionary;

    //Edit this variable to filter out words based on amount of characters
    private static final int minimalwordlength = 0;
    private static final char[][] board = {};

    static{
        dictionary = new TreeSet<>();
    }

        public static void main(String[] args){

        try {
            FileReader f = new FileReader("C:\\Users\\Eppo\\Desktop\\Project OOP\\OOP3\\Boggle\\dict.txt");
            BufferedReader b = new BufferedReader(f);
            String line;
            while ((line = b.readLine()) != null) {
                dictionary.add(line.split(":")[0]);
            }
        } catch (Exception e) {
            throw new RuntimeException("Dictionary error");
        }

        createMatrix();

            List<String> list = BoggleSolver.boggleSolver(board);

            if (list.size() > 0){
                for (String str :  list) {
                    System.out.println(str);
                }
            }

            else{
                System.out.println("No words found with " +minimalwordlength+ " or more characters");
                System.out.println("Try reducing minimalwordlength");
            }
    }

    private static List<String> boggleSolver(char[][] m) {
        if (m == null) {
            throw new NullPointerException("Matrix = null");
        }
        final List<String> validWords = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                solve(m, i, j, m[i][j] + "", validWords);
            }
        }
        return validWords;
    }

    public static void createMatrix() {

        //Create two arrays to be filled with 16 random lowercase characters (a..z)
        String[] randomStringArray = new String[16];
        char[] randomCharArray = new char[16];

        Random r = new Random();

        //Fill arrays
        for (int i = 0; i < 16; i++) {
            char c1 = (char) (r.nextInt(26) + 'a');
            String s1 = Character.toString(c1);
            randomStringArray[i] = s1;
            randomCharArray[i] = c1;
        }

        char[][] board = {
                { randomCharArray[0], randomCharArray[1], randomCharArray[2], randomCharArray[3] },
                { randomCharArray[4], randomCharArray[5], randomCharArray[6], randomCharArray[7] },
                { randomCharArray[8], randomCharArray[9], randomCharArray[10], randomCharArray[11] },
                { randomCharArray[12], randomCharArray[13], randomCharArray[14], randomCharArray[15] } };

        createGUI(randomStringArray);

    }

    private static void createGUI(String[]matrixArray){

        JFrame frame1 = new JFrame("Boggle Matrix");
        frame1.setSize(215, 238);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setVisible(true);

        Container pane = frame1.getContentPane();
        pane.setLayout(null);

        JTextField textField1 = new JTextField(matrixArray[0], 1);
        pane.add(textField1);
        textField1.setBounds(0, 0, 50, 50);
        textField1.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField2 = new JTextField(matrixArray[1], 1);
        pane.add(textField2);
        textField2.setBounds(50, 0, 50, 50);
        textField2.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField3 = new JTextField(matrixArray[2], 1);
        pane.add(textField3);
        textField3.setBounds(100, 0, 50, 50);
        textField3.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField4 = new JTextField(matrixArray[3], 1);
        pane.add(textField4);
        textField4.setBounds(150, 0, 50, 50);
        textField4.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField5 = new JTextField(matrixArray[4], 1);
        pane.add(textField5);
        textField5.setBounds(0, 50, 50, 50);
        textField5.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField6 = new JTextField(matrixArray[5], 1);
        pane.add(textField6);
        textField6.setBounds(50, 50, 50, 50);
        textField6.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField7 = new JTextField(matrixArray[6], 1);
        pane.add(textField7);
        textField7.setBounds(100, 50, 50, 50);
        textField7.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField8 = new JTextField(matrixArray[7], 1);
        pane.add(textField8);
        textField8.setBounds(150, 50, 50, 50);
        textField8.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField9 = new JTextField(matrixArray[8], 1);
        pane.add(textField9);
        textField9.setBounds(0, 100, 50, 50);
        textField9.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField10 = new JTextField(matrixArray[9], 1);
        pane.add(textField10);
        textField10.setBounds(50, 100, 50, 50);
        textField10.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField11 = new JTextField(matrixArray[10], 1);
        pane.add(textField11);
        textField11.setBounds(100, 100, 50, 50);
        textField11.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField12 = new JTextField(matrixArray[11], 1);
        pane.add(textField12);
        textField12.setBounds(150, 100, 50, 50);
        textField12.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField13 = new JTextField(matrixArray[12], 1);
        pane.add(textField13);
        textField13.setBounds(0, 150, 50, 50);
        textField13.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField14 = new JTextField(matrixArray[13], 1);
        pane.add(textField14);
        textField14.setBounds(50, 150, 50, 50);
        textField14.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField15 = new JTextField(matrixArray[14], 1);
        pane.add(textField15);
        textField15.setBounds(100, 150, 50, 50);
        textField15.setHorizontalAlignment(JTextField.CENTER);

        JTextField textField16 = new JTextField(matrixArray[15], 1);
        pane.add(textField16);
        textField16.setBounds(150, 150, 50, 50);
        textField16.setHorizontalAlignment(JTextField.CENTER);
    }

    private static void solve(char[][] matrixArray, int i, int j, String prefix, List<String> validWords) {

        assert matrixArray != null;
        assert validWords != null;

        for (int i1 = Math.max(0, i - 1); i1 < Math.min(matrixArray.length, i + 2); i1++) {
            for (int j1 = Math.max(0, j - 1); j1 < Math.min(matrixArray[0].length, j + 2); j1++) {
                // Skip the tile (i, j) itself
                if (i1 == i && j1 == j) continue;

                String word = prefix + matrixArray[i1][j1];

                if (!dictionary.subSet(word, word + Character.MAX_VALUE).isEmpty()) {
                    if (dictionary.contains(word)) {
                        if (word.length() >= minimalwordlength){
                            validWords.add(word);
                        }else {continue;}
                    }
                    solve(matrixArray, i1, j1, word, validWords);
                }
            }
        }
    }
}


