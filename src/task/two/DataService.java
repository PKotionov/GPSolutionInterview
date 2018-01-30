package task.two;

import java.io.*;

/**
 * Created by Kotionov_PV on 30.01.18.
 */
public class DataService {
    private Integer numberOfMember, member;

    public void readNumberFromFile() {
        File file = new File(".\\src\\task\\two\\input.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                try {
                    numberOfMember = Integer.valueOf(br.readLine());
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

    public void findNumberInSequence() {
        int i = 1;
        member = 1;
        while (i <= numberOfMember) {
            if (isMatches(member)) {
                member++;
            } else {
                i++;
                member++;
            }
        }
        member--;
    }

    public boolean isMatches(Integer member) {
        String memberString = member.toString();
        for (int j = 0; j < memberString.length(); j++) {
            String currentNumeral = String.valueOf(memberString.charAt(j));
            String number = memberString.substring(j + 1);
            if (!number.isEmpty() && number.contains(currentNumeral)) {
              return true;
            }
        }
        return false;
    }

    public void writeResultInFile() {
        File file = new File(".\\src\\task\\two\\output.txt");
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
            bufferedWriter.write(String.valueOf(member));
            System.out.println("Program finished successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
