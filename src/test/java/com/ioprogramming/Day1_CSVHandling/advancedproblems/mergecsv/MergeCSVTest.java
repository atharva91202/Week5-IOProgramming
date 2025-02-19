package com.ioprogramming.Day1_CSVHandling.advancedproblems.mergecsv;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MergeCSVTest {

    private static final String OUTPUT_FILE = "src/test/resources/merged_students.csv";

    @Test
    public void testMergeCSVFiles() throws IOException {
        String file1Path = "E:/Capg/Week5_IO_Programming/Day1/src/test/resources/students1.csv";
        String file2Path = "E:/Capg/Week5_IO_Programming/Day1/src/test/resources/students2.csv";

        MergeCSV.mergeCSVFiles(file1Path, file2Path, OUTPUT_FILE);


        File outputFile = new File(OUTPUT_FILE);
        assert(outputFile.exists());


        List<String> lines = java.nio.file.Files.readAllLines(outputFile.toPath());
        assert (lines.get(1).contains("101,Anand,21,85.5,A"));
     assert(lines.get(2).contains("102,Ankit,22,78.0,B"));
    }
}
