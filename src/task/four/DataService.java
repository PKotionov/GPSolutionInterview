package task.four;

import java.io.*;

public class DataService {
    private Integer quantityOfMatrixs, sizeOfMatrix, columnNumber, lineNumber, module;
    private int[][] matrix1, matrix2, matrixResult;

    public int[][] getMatrixResult() {
        return matrixResult;
    }

    public void readData() {
        File file = new File(".\\src\\task\\four\\input.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line1 = br.readLine();
                String line2 = br.readLine();
                String line3 = br.readLine();
                br.readLine();

                String[] line1Array = line1.split(" ");
                String[] line2Array = line2.split(" ");

                try {
                    quantityOfMatrixs = Integer.valueOf(line1Array[0]);
                    sizeOfMatrix = Integer.valueOf(line1Array[1]);
                    lineNumber = Integer.valueOf(line2Array[0]);
                    columnNumber = Integer.valueOf(line2Array[1]);
                    module = Integer.valueOf(line3);
                    matrix1 = readMatrix(br);
                    br.readLine();
                    matrix2 = new int[sizeOfMatrix][sizeOfMatrix];
                    matrixResult = new int[sizeOfMatrix][sizeOfMatrix];
                    multiMatrixMultiplying(br);

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

    public void multiMatrixMultiplying(BufferedReader br) throws IOException {
        for (int i = 0; i < quantityOfMatrixs - 1; i++) {
            matrix2 = readMatrix(br);
            br.readLine();
            matrixResult = matrixMultiplication(matrix1, matrix2);
            matrix1 = matrixResult;
        }
    }

    public int[][] moduleCheck(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] >= module) {
                    matrix[i][j] = matrix[i][j] % module;
                }
            }
        }
        return matrix;
    }

    public int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
        int[][] matrixResult = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                for (int k = 0; k < sizeOfMatrix; k++) {
                    matrixResult[i][j] = matrix1[i][k] * matrix2[k][j] + matrixResult[i][j];
                }
            }
        }
        return matrixResult;
    }

    public int[][] readMatrix(BufferedReader br) throws IOException {
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            String line = br.readLine();
            String[] lineArray = line.split(" ");
            for (int j = 0; j < sizeOfMatrix; j++) {
                matrix[i][j] = Integer.valueOf(lineArray[j]);
            }
        }
        return matrix;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void writeResult(int[][] matrixResult) {
        File file = new File(".\\src\\task\\four\\output.txt");
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
            bufferedWriter.write(Integer.toString(matrixResult[lineNumber - 1][columnNumber - 1]));
            System.out.println("Program finished successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
