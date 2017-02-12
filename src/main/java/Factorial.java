/**
 * Created by Vova_Levitski on 09.02.2017.
 */
/**
 * Обчислення значення факторіала числа.
 */
public class Factorial {
    /**
     * Функція для обчислення факторіала числа за допомогою
     * рекурсивного виклику.
     * n - вхідне число.
     */
    static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}

