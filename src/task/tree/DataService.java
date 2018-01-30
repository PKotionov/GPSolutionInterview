package task.tree;

import java.io.*;

public class DataService {
    private String dna1, dna2;
    private boolean isEvolutionPossible;

    public void readData() {
        File file = new File(".\\src\\task\\tree\\input.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                dna1 = br.readLine();
                dna2 = br.readLine();
            } catch (IOException e) {
                System.out.println("File can't read.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found.");
        }
    }

    public void analyseData() {
        Integer count = 0, numberOfMatch = 0;
        for (int i = 0; i < dna1.length() ; i++) {
            for (int j = numberOfMatch; j < dna2.length(); j++) {
                if(dna1.charAt(i) == dna2.charAt(j)){
                    count++;
                    numberOfMatch = j+1;
                }
            }
        }
        if(count.equals(dna1.length())){
            isEvolutionPossible = true;
        }
    }

    public void writeResult() {
        File file = new File(".\\src\\task\\tree\\output.txt");
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
           if(isEvolutionPossible){
               bufferedWriter.write("YES");
           } else {
               bufferedWriter.write("NO");
           }
            System.out.println("Program finished successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
