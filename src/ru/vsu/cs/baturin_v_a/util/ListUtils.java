package ru.vsu.cs.baturin_v_a.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            list.add(i, array[i]);
        }
        return list;
    }

    public static int[] intListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}