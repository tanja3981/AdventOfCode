package de.tanschmi.aoc2024.dec2;

import de.tanschmi.aoc2024.ListReader;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Dec2 {

    public int step1(File file) throws IOException {

        ListReader reader = new ListReader();
        List<Sequence> sequences = reader.readSequences(file);

        int sum = countSafe(sequences);
        log.info("Summe: {}", sum);
        return sum;
    }


    private int countSafe(List<Sequence> sequences) {
        int sum = 0;
        for (Sequence seq : sequences) {
            boolean safe = isSequenceSafe(seq.getColumns());
            if (safe) {
                sum++;
            }
        }
        return sum;
    }

    boolean isSequenceSafe(ArrayList<Integer> columns) {

        Boolean increasing = null;
        for (int i = 1; i < columns.size(); i++) {
            int previous = columns.get(i - 1);
            int current = columns.get(i);
            if (increasing == null) {
                increasing = previous > current;
            } else {
                //Wert würde sich ändern -> unsafe
                if (increasing != previous > current) {
                    return false;
                }
            }
            if (previous > current) {
                int diff = previous - current;
                if (diff > 3 || diff < 1) {
                    return false;
                }
            } else {
                int diff = current - previous;
                if (diff > 3 || diff < 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
