package de.tanschmi.aoc2024.dec1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Dec1Test {
    Dec1 task = new Dec1();

    @Test
    void step1() throws IOException {
        final long expected = 1603498L;
        File f = new File(ClassLoader.getSystemResource("inputs/dec1.txt").getFile());
        long result = task.step1(f);
        assertEquals(expected, result);
    }

    @Test
    void step2() throws IOException {
        final long expected = 25574739L;
        File f = new File(ClassLoader.getSystemResource("inputs/dec1.txt").getFile());
        long result = task.step2(f);
        assertEquals(expected, result);
    }

    @Test
    void testStep1() {
    }

    @Test
    void testStep2() {
    }
}