package com.example.java;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.List;

/**
 * Created by Eppo on 23-3-2017.
 *  Boggle
 */

public final class BoggleSolver {

        private static final NavigableSet<String> dictionary;
        private final Map<Character, List<Character>> graph = new HashMap<>();


    static {
            dictionary = new TreeSet<String>();
            try {
                FileReader fr = new FileReader("C:\\Users\\Eppo\\Desktop\\Project OOP\\OOP3\\Boggle\\dict.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    dictionary.add(line.split(":")[0]);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error while reading dictionary");
            }
        }

        private static List<String> boggleSolver(char[][] m) {
            if (m == null) {
                throw new NullPointerException("The matrix cannot be null");
            }
            final List<String> validWords = new ArrayList<>();
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    solve(m, i, j, m[i][j] + "", validWords);
                }
            }
            return validWords;
        }

        private static void createGUI(String[] someArray){

            JFrame frame1 = new JFrame("Boggle Solver");
            frame1.setSize(215, 238);
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame1.setVisible(true);

            Container pane = frame1.getContentPane();
            pane.setLayout(null);

            JTextField textField1 = new JTextField(someArray[0], 1);
            pane.add(textField1);
            textField1.setBounds(0, 0, 50, 50);
            textField1.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField2 = new JTextField(someArray[1], 1);
            pane.add(textField2);
            textField2.setBounds(50, 0, 50, 50);
            textField2.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField3 = new JTextField(someArray[2], 1);
            pane.add(textField3);
            textField3.setBounds(100, 0, 50, 50);
            textField3.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField4 = new JTextField(someArray[3], 1);
            pane.add(textField4);
            textField4.setBounds(150, 0, 50, 50);
            textField4.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField5 = new JTextField(someArray[4], 1);
            pane.add(textField5);
            textField5.setBounds(0, 50, 50, 50);
            textField5.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField6 = new JTextField(someArray[5], 1);
            pane.add(textField6);
            textField6.setBounds(50, 50, 50, 50);
            textField6.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField7 = new JTextField(someArray[6], 1);
            pane.add(textField7);
            textField7.setBounds(100, 50, 50, 50);
            textField7.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField8 = new JTextField(someArray[7], 1);
            pane.add(textField8);
            textField8.setBounds(150, 50, 50, 50);
            textField8.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField9 = new JTextField(someArray[8], 1);
            pane.add(textField9);
            textField9.setBounds(0, 100, 50, 50);
            textField9.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField10 = new JTextField(someArray[9], 1);
            pane.add(textField10);
            textField10.setBounds(50, 100, 50, 50);
            textField10.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField11 = new JTextField(someArray[10], 1);
            pane.add(textField11);
            textField11.setBounds(100, 100, 50, 50);
            textField11.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField12 = new JTextField(someArray[11], 1);
            pane.add(textField12);
            textField12.setBounds(150, 100, 50, 50);
            textField12.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField13 = new JTextField(someArray[12], 1);
            pane.add(textField13);
            textField13.setBounds(0, 150, 50, 50);
            textField13.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField14 = new JTextField(someArray[13], 1);
            pane.add(textField14);
            textField14.setBounds(50, 150, 50, 50);
            textField14.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField15 = new JTextField(someArray[14], 1);
            pane.add(textField15);
            textField15.setBounds(100, 150, 50, 50);
            textField15.setHorizontalAlignment(JTextField.CENTER);

            JTextField textField16 = new JTextField(someArray[15], 1);
            pane.add(textField16);
            textField16.setBounds(150, 150, 50, 50);
            textField16.setHorizontalAlignment(JTextField.CENTER);

        }

        private static void solve(char[][] m, int i, int j, String prefix, List<String> validWords) {
            assert m != null;
            assert validWords != null;

            for (int i1 = Math.max(0, i - 1); i1 < Math.min(m.length, i + 2); i1++) {
                for (int j1 = Math.max(0, j - 1); j1 < Math.min(m[0].length, j + 2); j1++) {
                    // Skip the tile (i, j) itself
                    if (i1 == i && j1 == j) continue;

                    String word = prefix + m[i1][j1];
                    if (!dictionary.subSet(word, word + Character.MAX_VALUE).isEmpty()) {
                        if (dictionary.contains(word)) {
                            validWords.add(word);
                        }
                        solve(m, i1, j1, word, validWords);
                    }
                }
            }
        }

        public static void main (String[] args) {


            String[] randomStringArray = new String[16];
            char[] randomCharArray = new char[16];

            Random r = new Random();

            for (int i = 0; i < 16; i++) {
                char c1 = (char)(r.nextInt(26) + 'a');  String s1 = Character.toString(c1);

                randomStringArray[i] = s1;
                randomCharArray[i] = c1;
            }
            createGUI(randomStringArray);

            char[][] board = {  { randomCharArray[0], randomCharArray[1], randomCharArray[2], randomCharArray[3] },
                                { randomCharArray[4], randomCharArray[5], randomCharArray[6], randomCharArray[7] },
                                { randomCharArray[8], randomCharArray[9], randomCharArray[10], randomCharArray[11] },
                                { randomCharArray[12], randomCharArray[13], randomCharArray[14], randomCharArray[15] } };

            List<String> list = BoggleSolver.boggleSolver(board);
            for (String str :  list) {
                System.out.println(str);
            }
        }
    }
