package ru.vsu.cs.baturin_v_a;

import java.util.Objects;

public class FindingWayInMaze {

    public void makeStep (String[][] arr, int[][] arr0, int k) {
        for (int i = 0; i < arr0.length; i++) {
            for (int j = 0; j < arr0[0].length; j++) {
                if (arr0[i][j] == k) {
                    if ((i > 0) && (arr0[i - 1][j] == 0) && (!arr[i - 1][j].equals("#"))) {
                        arr0[i - 1][j] = k + 1;
                    }

                    if ((j > 0) && (arr0[i][j - 1] == 0) && (!arr[i][j - 1].equals("#"))) {
                        arr0[i][j - 1] = k + 1;
                    }

                    if ((i < arr0.length - 1) && (arr0[i + 1][j] == 0) && (!arr[i + 1][j].equals("#"))) {
                        arr0[i + 1][j] = k + 1;
                    }

                    if ((j < arr0[0].length - 1) && (arr0[i][j + 1] == 0) && (!arr[i][j + 1].equals("#"))) {
                        arr0[i][j + 1] = k + 1;
                    }
                }
            }
        }
    }

    public void paintTheWay (int final1, int final2, int[][] arr0, String[][] arr) {
        int k = arr0[final1][final2];
        while (k > 1) {
            if ((final1 > 0) && (arr0[final1 - 1][final2] == k - 1)) {
                final1--;
                arr[final1][final2] = "+";
                k--;
            } else if ((final2 > 0) && (arr0[final1][final2 - 1] == k - 1)) {
                final2--;
                arr[final1][final2] = "+";
                k--;
            } else if ((final1 < arr0.length - 1) && (arr0[final1 + 1][final2] == k - 1)) {
                final1++;
                arr[final1][final2] = "+";
                k--;
            } else if ((final2 < arr0[0].length - 1) && (arr0[final1][final2 + 1] == k - 1)) {
                final2++;
                arr[final1][final2] = "+";
                k--;
            }
        }
    }

    public void layout (String[][] arr) {
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = ".";
            }
        }
    }

    public int findCoordinates (String[][] arr, int coordinate, String Elem) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (Objects.equals(arr[i][j], Elem)) {
                    a = i;
                    b = j;
                }
            }
        }

        if (coordinate == 0) {
            return a;
        }

        if (coordinate == 1) {
            return b;
        }

        return -1;
    }

    public int[][] createEmptyIntArr(String[][] arr) {
        int[][] arr0 = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr0[i][j] = 0;
            }
        }
        return arr0;
    }
}
