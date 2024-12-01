package de.tanschmi.aoc2024.dec1;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

@Slf4j
public class TwoListsDistance {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> lefts = new ArrayList<>();
        ArrayList<Integer> rights = new ArrayList<>();

        File f = new File(ClassLoader.getSystemResource("inputs/dec1.txt").getFile());

        new ListReader().read(f, lefts, rights);

        sortColumns(lefts, rights);

        if (lefts.size() != rights.size()) {
            throw new RuntimeException("Die Länge der Liste ist unterschiedlich!!!");
        }

        ArrayList<Integer> diffs = calcDiffs(lefts, rights);
        int summe = diffs.stream()
                .mapToInt(Integer::intValue)
                .sum();
        log.info("Summe: {}", summe);
    }

    private static ArrayList<Integer> calcDiffs(ArrayList<Integer> lefts, ArrayList<Integer> rights) {
        ArrayList<Integer> diffs = new ArrayList<>();

        for (int i = 0; i < lefts.size(); i++) {
            int left = lefts.get(i);
            int right = rights.get(i);
            int diff;
            if (left > right) {
                diff = left - right;
            } else {
                diff = right - left;
            }
            diffs.add(diff);
        }
        return diffs;
    }

    private static void sortColumns(ArrayList<Integer> lefts, ArrayList<Integer> rights) {

        Comparator<Integer> intComparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        lefts.sort(intComparator);
        rights.sort(intComparator);

//        log.info(lefts.toString());
//        log.info(rights.toString());

    }
}
