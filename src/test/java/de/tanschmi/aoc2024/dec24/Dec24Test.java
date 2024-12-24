package de.tanschmi.aoc2024.dec24;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class Dec24Test {

    @Test
    void task1() throws IOException {
        File fileValues = new File(ClassLoader.getSystemResource("inputs/dec24_values.txt").getFile());
        String inputValues = FileUtils.readFileToString(fileValues, Charset.defaultCharset());

        File fileOperations = new File(ClassLoader.getSystemResource("inputs/dec24_operations.txt").getFile());
        String inputOperations = FileUtils.readFileToString(fileOperations, Charset.defaultCharset());

        Dec24 dec24 = new Dec24();
        long result = dec24.task1(inputValues, inputOperations);
        assertEquals(0, result);

    }
    @Test
    void task1_withExamle() {
        String input1 = """
                x00: 1
                x01: 0
                x02: 1
                x03: 1
                x04: 0
                y00: 1
                y01: 1
                y02: 1
                y03: 1
                y04: 1""";
        String input2 = """
                ntg XOR fgs -> mjb
                y02 OR x01 -> tnw
                kwq OR kpj -> z05
                x00 OR x03 -> fst
                tgd XOR rvg -> z01
                vdt OR tnw -> bfw
                bfw AND frj -> z10
                ffh OR nrd -> bqk
                y00 AND y03 -> djm
                y03 OR y00 -> psh
                bqk OR frj -> z08
                tnw OR fst -> frj
                gnj AND tgd -> z11
                bfw XOR mjb -> z00
                x03 OR x00 -> vdt
                gnj AND wpb -> z02
                x04 AND y00 -> kjc
                djm OR pbm -> qhw
                nrd AND vdt -> hwm
                kjc AND fst -> rvg
                y04 OR y02 -> fgs
                y01 AND x02 -> pbm
                ntg OR kjc -> kwq
                psh XOR fgs -> tgd
                qhw XOR tgd -> z09
                pbm OR djm -> kpj
                x03 XOR y03 -> ffh
                x00 XOR y04 -> ntg
                bfw OR bqk -> z06
                nrd XOR fgs -> wpb
                frj XOR qhw -> z04
                bqk OR frj -> z07
                y03 OR x01 -> nrd
                hwm AND bqk -> z03
                tgd XOR rvg -> z12
                tnw OR pbm -> gnj""";

        Dec24 dec24 = new Dec24();
        long result = dec24.task1(input1, input2);
        assertEquals(42410633905894L, result);
    }
}