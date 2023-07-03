package homework_4;

import java.util.Arrays;
import java.util.LinkedList;

//Пусть дан LinkedList с несколькими элементами. 
 //Реализуйте метод, который вернет “перевернутый” список.

public class Task_1 {
    public static void main(String[] args) {
        LinkedList<Integer> ls = new LinkedList<>(Arrays.asList(7,9,11,25,35,14,25));
        System.out.println(reverse(ls));
    }
    
    public static LinkedList<Integer> reverse(LinkedList<Integer> ls) {
        LinkedList<Integer> rev_ls = new LinkedList<>();
        for(int i=ls.size()-1;i>=0;i--){
            rev_ls.add(ls.get(i));
        }
        return rev_ls;

        
    } 

        
}
