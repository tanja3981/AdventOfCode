package de.tanschmi.aoc2024.dec2;

import java.util.ArrayList;

public class Sequence {
    ArrayList<Integer> columns = new ArrayList<Integer>();

    public int get(int i) {
        return columns.get(i);
    }
    public void add(int i, int v) {
        columns.add(i, v);
    }

    public ArrayList<Integer> getColumns() {
        return columns;
    }
}
