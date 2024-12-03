package de.tanschmi.aoc2024.dec3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Dec3Test {
    final Dec3 dec3 = new Dec3();

    @Test
    void task1() throws IOException {
        File f = new File(ClassLoader.getSystemResource("inputs/dec3.txt").getFile());

        int result = dec3.task1(f);
        assertEquals(171183089, result);
    }
}