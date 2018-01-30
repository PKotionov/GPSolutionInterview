package task.one;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kotionov_PV on 30.01.18.
 */

public class DataService {
    private Integer[] sequence;
    private Integer sequenceLength;
    private List<Integer> subsequence;

    public void readData() {
        File file = new File(".\\src\\task\\one\\input.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String lineOne = br.readLine();
                String lineTwo = br.readLine();
                String[] sequenceString = lineTwo.split(" ");
                Integer[] sequence = new Integer[sequenceString.length];
                try {
                    sequenceLength = Integer.valueOf(lineOne);
                    for (int i = 0; i < sequenceLength; i++) {
                        try {
                            sequence[i] = Integer.valueOf(sequenceString[i]);
                        } catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("Error: check your input file.");
                        }
                    }
                    this.sequence = sequence;
                } catch (NumberFormatException e) {
                    System.out.println("Check input data. It should be numbers only.");
                }
            } catch (IOException e1) {
                System.out.println("File can't read.");
                e1.printStackTrace();
            }
        } else {
            System.out.println("File not found.");
        }
    }

    public void findMaxSubsequence() {
        int sumPositive = 0, sumNegative = 0;
        List<Integer> subsequencePositive = new ArrayList<>();
        List<Integer> subsequenceNegative = new ArrayList<>();
        for (int i = 0; i < sequenceLength; i++) {
            if (sequence[i] > 0) {
                sumPositive += sequence[i];
                subsequencePositive.add(i);
            }else if (sequence[i] < 0) {
                sumNegative += sequence[i];
                subsequenceNegative.add(i);
            }
        }
        if (sumPositive > Math.abs(sumNegative)) {
            subsequence = subsequencePositive;
        } else {
            subsequence = subsequenceNegative;
        }
    }

    public void writeResultInFile() {
        File file = new File(".\\src\\task\\one\\output.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Can't create output file.");
                e.printStackTrace();
            }
        }
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(String.valueOf(subsequence.size()));
            bufferedWriter.write("\n");
            for (Integer integer : subsequence) {
                bufferedWriter.write(integer + 1 + " ");
            }
            System.out.println("Program finished successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







