package de.tanschmi.aoc2024.dec2;

import java.util.ArrayList;

public class Sequence {
    ArrayList<Integer> columns = new ArrayList<Integer>();

    public Sequence() {

    }

    public Sequence(ArrayList<Integer> columns) {
        this.columns = columns;
    }

    public int get(int i) {
        return columns.get(i);
    }

    public void add(int i, int v) {
        columns.add(i, v);
    }

    public ArrayList<Integer> getColumns() {
        return columns;
    }

    public int size() {
        return columns.size();
    }

    public ArrayList<Integer> getWithoutCol(int except) {
        ArrayList<Integer> sublist = new ArrayList<>();
        for (int i = 0; i < columns.size(); i++) {
            if (i != except) {
                sublist.add(columns.get(i));
            }
        }
        return sublist;
    }
}
