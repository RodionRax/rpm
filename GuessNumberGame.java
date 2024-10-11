import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    
    // Метод для генерации случайного числа
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // Метод для обработки игры
    private static void playGame() {
        int targetNumber = generateRandomNumber(1, 100); // Загадать число от 1 до 100
        int attempts = 0;
        int guess = -1;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");

        // Основной игровой цикл
        while (guess != targetNumber) {
            System.out.print("Введите ваше число: ");
            try {
                guess = Integer.parseInt(scanner.nextLine());
                attempts++;
                
                if (guess > targetNumber) {
                    System.out.println("Ваше число больше загаданного.");
                } else if (guess < targetNumber) {
                    System.out.println("Ваше число меньше загаданного.");
                } else {
                    System.out.println("Поздравляю! Вы угадали число.");
                    System.out.println("Число попыток: " + attempts);
                }
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
            }
        }
    }

    // Метод для предложения новой игры
    private static boolean wantToPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Хотите сыграть снова? (да/нет): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("да")) {
                return true;
            } else if (response.equals("нет")) {
                return false;
            } else {
                System.out.println("Пожалуйста, введите 'да' или 'нет'.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру 'Угадай число'!");

        // Основной цикл игры
        do {
            playGame();
        } while (wantToPlayAgain());

        System.out.println("Спасибо за игру! До встречи.");

    }
}
