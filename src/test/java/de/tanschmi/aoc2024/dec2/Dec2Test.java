package de.tanschmi.aoc2024.dec2;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Dec2Test {

    @Test
    void step1() throws IOException {
        final int expected = 432;
        File f = new File(ClassLoader.getSystemResource("inputs/dec2.txt").getFile());
        Dec2 task = new Dec2();
        assertEquals(expected, task.step1(f));
    }

    @Test
    void isSequenceSafe_incr() {
        ArrayList<Integer> list = createList(1, 2, 3, 6);

        Dec2 task = new Dec2();
        assertTrue(task.isSequenceSafe(list));
    }

    @Test
    void isSequenceSafe_decr() {
        ArrayList<Integer> list = createList(6, 3, 2, 1);


        Dec2 task = new Dec2();
        assertTrue(task.isSequenceSafe(list));
    }


    @Test
    void isSequenceSafe_unsafeOrder() {
        ArrayList<Integer> list = createList(6, 3, 2, 3);

        Dec2 task = new Dec2();
        assertFalse(task.isSequenceSafe(list));
    }

    @Test
    void isSequenceSafe_unsafeDiff() {
        ArrayList<Integer> list = createList(7, 3, 2, 1);

        Dec2 task = new Dec2();
        assertFalse(task.isSequenceSafe(list));
    }

    private ArrayList<Integer> createList(int i1, int i2, int i3, int i4) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        return list;
    }
}