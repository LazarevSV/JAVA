package homework_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Написать простой класс Телефонный Справочник (с помощью HashMap), 
//который хранит в себе список фамилий и телефонных номеров.


public class task_1 {
    public static void main(String[] args) {
        task1();
        
    }

    

    private static void task1() {
        Directory directory = new Directory();
        
        directory.add("ivanov", "8999123321");
        directory.add("ivanov", "8912155326");
        directory.add("petrov", "8917155552");
        directory.add("petrov", "8913455672");
        directory.add("ivanov", "899999999");
        directory.add("sidorov", "899111111");
        directory.add("petrov", "89923231999");
        directory.add("orlov", "8888123113");
        directory.add("sidorov", "8324325234");

        System.out.println(directory.get("ivanov"));
        System.out.println(directory.get("sidorov"));
        System.out.println(directory.get("petrov"));
        System.out.println(directory.get("smetanov"));
    }
}

class Directory {
    private Map<String, List<String>> directory_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory_hm.containsKey(surname)) {
            phone_number_list = directory_hm.get(surname);
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return directory_hm.get(surname);
    }

}
    


