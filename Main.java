import java.util.Scanner;

class MultiplicationMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt(); // Чтение первого числа

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt(); // Чтение второго числа

        System.out.println("Выберите способ умножения:");
        System.out.println("1. Сложение (итеративный способ)");
        System.out.println("2. Рекурсия");
        int choice = scanner.nextInt();

        int result = 0;
        switch (choice) {
            case 1:
                result = multiplyUsingAddition(a, b);
                System.out.println("Результат умножения " + a + " и " + b + " (с использованием сложения) = " + result);
                break;
            case 2:
                result = multiplyRecursively(a, b);
                System.out.println("Результат умножения " + a + " и " + b + " (с использованием рекурсии) = " + result);
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите 1 или 2.");
        }

        scanner.close(); // Закрытие сканера
    }

    // Метод умножения с использованием сложения
    public static int multiplyUsingAddition(int a, int b) {
        int result = 0;
        for (int i = 0; i < Math.abs(b); i++) { // Используем Math.abs для поддержки отрицательных чисел
            result += a;
        }
        return (b < 0) ? -result : result; // Если b отрицательное, результат тоже отрицательный
    }

    // Метод умножения с использованием рекурсии
    public static int multiplyRecursively(int a, int b) {
        if (b == 0) {
            return 0; // Базовый случай
        }
        if (b < 0) {
            return -multiplyRecursively(a, -b); // Поддержка отрицательных чисел
        }
        return a + multiplyRecursively(a, b - 1); // Рекурсивный случай
    }
}
