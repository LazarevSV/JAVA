
// Вывести все простые числа от 1 до 1000

public class task_2 {
public static void main(String[] args){
        for (int i = 2; i < 1000; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) System.out.printf("%d ", i);
        }
    }
}
    
