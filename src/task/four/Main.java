package task.four;

/**
 557.Матрицы
 Аня недавно узнала, что такое квадратная матрица размерности n. Это таблица n×n с целыми числами в ячейках. Число,
 стоящее на пересечении i-ой строки и j-ого столбца матрицы A, кратко обозначается A[i, j]. Матрицы можно умножать, и
 Аня быстро освоила, как запрограммировать эту операцию с помощью циклов. Результатом умножения двух матриц A и B будет
 матрица C, элементы которой определяются следующим образом: ...

 Матрицы ей понадобились для конкретной задачи, в которой надо узнать определенный элемент произведения нескольких матриц.
 Это уже достаточно сложная задача для Ани, но она усложняется тем,
 что все вычисления ведутся по модулю некоторого простого
 числа p, то есть если при арифметических операциях получается число, большее, либо равное p, оно заменяется на остаток при делении на p.
 Помогите Ане вычислить нужный ей элемент.
 Входные данные
 В первой строчке входного файла INPUT.TXT стоят два числа: m - количество матриц, n - размер каждой из матриц
 (1 ≤ m ≤ 130, 1 ≤ n ≤ 130). В следующей строчке содержатся номер строки и столбца, интересующего Аню элемента
 1 ≤ a ≤ n, 1 ≤ b ≤ n. В третьей строке содержится простое число p ≤ 1000. Далее следует описание m матриц.
 Описание каждой матрицы состоит из n строк. В каждой из строк содержится n неотрицательных целых чисел, меньших p.

 Соседние числа в строке разделены пробелом, а перед каждой матрицей пропущена строка.
 Выходные данные
 В выходной файл OUTPUT.TXT выведите нужный Ане элемент произведения матриц.
        Пример
 INPUT.TXT	    OUTPUT.TXT
 3 2
 1 2
 239

 1 2
 3 4

 4 2
 1 3

 1 2
 2 1	        20

 */

public class Main {
    public static void main(String[] args) {
        DataService dataService = new DataService();
        dataService.readData();
        int[][] matrixResult = dataService.moduleCheck(dataService.getMatrixResult());
        dataService.writeResult(matrixResult);
    }
}
