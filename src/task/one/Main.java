package task.one;

/**
 Задача №579.Модуль суммы
 Дана последовательность целых чисел. Требуется найти подпоследовательность заданной последовательности с максимальным
 модулем суммы входящих в нее чисел. Напомним, что модуль целого числа x равняется x, если x ≥ 0 и -x, если x < 0.
 Входные данные
 Первая строка входного файла INPUT.TXT содержит натуральное число n (1 ≤ n ≤ 10000) - длину последовательности.
 Во второй строке записаны n целых чисел, по модулю не превосходящих 10000.
 Выходные данные
 В первой строке выходного файла OUTPUT.TXT выведите длину k выбранной вами подпоследовательности.
 Во второй строке должны быть записаны k различных чисел, разделенных пробелами - номера выбранных членов последовательности.
                 Пример
 	INPUT.TXT	          OUTPUT.TXT
 	5                       2
    -1 4 -1 6 -7	        2 4

 */

public class Main {
    public static void main(String[] args) {
    DataService fileService = new DataService();
        fileService.readData();
        fileService.findMaxSubsequence();
        fileService.writeResultInFile();
    }
}