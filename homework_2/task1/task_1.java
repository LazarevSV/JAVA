/*
В файле содержится строка с исходными данными в такой форме: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
 */

package homework_2.task1;

import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;

public class task_1 {
    private static String[] ReadFile(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int ch;
            while ((ch = br.read()) != -1) {
                sb.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] tempArray = sb.toString().split("[\\s\\p{Punct}]+");
        String[] result = new String[tempArray.length - 1];
        System.arraycopy(tempArray, 1, result, 0, 8);
        return result;
    }

    private static String makingQuery(String[] array) {
        StringBuilder result = new StringBuilder("SELECT * FROM students WHERE ");
        for (int i =0; i < array.length; i+=2) {
            if(array[i+1].equals("null") == false) {
                if ((i != 0)&&((i>=4)||(array[i-1].equals("null") == false))) {
                    result.append(" and ");
                    result.append(array[i]);
                    result.append(" = ");
                    result.append(array[i+1]);
                } else {
                    result.append(array[i]);
                    result.append(" = ");
                    result.append(array[i+1]);
                }
            }
            
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] jsonArray = ReadFile("homework_2/task1/test.txt");
        System.out.println(Arrays.toString(jsonArray));
        String request = makingQuery(jsonArray);
        System.out.println(request);
    }

}
    
