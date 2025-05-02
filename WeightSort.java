import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WeightSort {
    public static void main(String[] args) {
        // Получаем входные данные
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите веса через пробел:");
        String input = scanner.nextLine();
        scanner.close();

        // Разбиваем строку на массив весов
        String[] weights = input.trim().split("\\s+");

        // Сортируем веса по сумме цифр каждого числа
        Arrays.sort(weights, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int sumA = sumOfDigits(a);
                int sumB = sumOfDigits(b);
                
                if (sumA == sumB) {
                    return a.compareTo(b); // Если суммы равны, сортируем по исходному значению
                }
                return Integer.compare(sumA, sumB);
            }

            private int sumOfDigits(String number) {
                int sum = 0;
                for (int i = 0; i < number.length(); i++) {
                    sum += Character.getNumericValue(number.charAt(i));
                }
                return sum;
            }
        });

        // Выводим результат
        System.out.println("Отсортированный список:");
        System.out.println(String.join(" ", weights));
    }
}