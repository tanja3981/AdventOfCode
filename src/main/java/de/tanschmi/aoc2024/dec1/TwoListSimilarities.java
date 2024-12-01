package de.tanschmi.aoc2024.dec1;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class TwoListSimilarities {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> lefts = new ArrayList<>();
        ArrayList<Integer> rights = new ArrayList<>();

        File f = new File(ClassLoader.getSystemResource("inputs/dec1.txt").getFile());

        new ListReader().read(f, lefts, rights);

        ArrayList<Long> scores = findSimilarities(lefts, rights);
        long sum = scores.stream().mapToLong(Long::longValue)
                .sum();
        log.info("Summe {}", sum);

    }

    private static ArrayList<Long> findSimilarities(ArrayList<Integer> lefts, ArrayList<Integer> rights) {
        ArrayList<Long> scores = new ArrayList<>();
        for (int i = 0; i < lefts.size(); i++) {
            int left = lefts.get(i);

            long occur = rights.stream()
                    .filter(right -> right == left)
                    .count();
            long score = occur * left;
            scores.add(score);
        }
        return scores;
    }
}
