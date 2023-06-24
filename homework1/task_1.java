import java.util.Scanner;
// Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
public class task_1 {
    public static void main(String[] args){
        Scanner ch = new Scanner(System.in);
        System.out.println("Input number:  ");
        int num = Integer.parseInt(ch.nextLine());
        triangle_num(num);
        System.out.println();
        factorial(num);
    }

    static void triangle_num(int n) {
        int tr_num = 0;
        for (int i = 0; i <= n; i++) {
            tr_num += i;
        }
        System.out.printf("%d triangular number: %d", n, tr_num);
    }
    static void factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        System.out.printf("Factorial of a number %d: %d", n, f);
    }
}
    
