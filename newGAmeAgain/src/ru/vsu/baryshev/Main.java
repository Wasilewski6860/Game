package ru.vsu.baryshev;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String [] array = InputArgs.fileToStringArray("levels/level01.txt");
Cell[][] arr = InputArgs.StringArrayToCellArray(array);
        for (int i=0;i< array.length;i++){
            System.out.println(array[i]);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
