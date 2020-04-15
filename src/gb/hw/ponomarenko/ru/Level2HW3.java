package gb.hw.ponomarenko.ru;

/**
 * @autor Nikolay Ponomarenko
 */

import javax.swing.*;
import java.util.*;

import static gb.hw.ponomarenko.ru.Level2HW3.Person.testPhoneBook;
import static javax.swing.JOptionPane.showInputDialog;
//import java.util.TreeMap;

public class Level2HW3<pb> {
    // Стихи на англ языке
    static final String textExample = "Heart lives in the future, so\n" +
            "What if gloom pervade the present?\n" +
            "All is fleeting, all will go;\n" +
            "What is gone will then be pleasant.";

    public static void main(String[] args){
        System.out.println("1. Подсчет слов:");
        сountWords();
       System.out.println("\n2. Телефонная книга: \n" +
          "Чей номер телефона Вы хотите найти? (Введите имя): " );
      testPhoneBook();
    }



    protected static void сountWords() {
        Map<String, Integer> hm = new HashMap<>();
        String[] words = Level2HW3.textExample.toLowerCase().split("\\W+");
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        System.out.println(hm);
        System.out.println("В этой фразе " + words.length + " слов !" + (words.length - hm.size()) + "Повторяется");
    }
// =================================== //

    public static class Person extends Level2HW3 {
        static void testPhoneBook() {
            Scanner scanner = new Scanner(System.in);
            //String s = scanner.nextLine();
            String s = showInputDialog("Ищем что?");
            String title = "Ваши данные";
            //JOptionPane.showInputDialog(s);

            PhoneBook pb = new PhoneBook();
            pb.add("Иван", " (423) 222-22-22");
            pb.add("Олег", " (423) 333-33-33");
            pb.add("Михаил", " (423) 444-44-44");
            pb.add("Николай", " (423) 555-55-55");
            pb.add("Константин", " (423) 666-66-66");
           // System.out.println(pb.get(s));
            //Collections.singletonList("Введенное значение переменной n:\n" + s); // строка вывода

            int type=JOptionPane.INFORMATION_MESSAGE; // тип значка

            //JOptionPane.showMessageDialog(null, title, type);
            JOptionPane.showMessageDialog(null, pb.get(s), title, type);

            System.out.println("\nВсе номера справочника: \n" + pb);
            //System.out.println("\nВсе номера справочника: \n" + pb);
            // System.out.println(pb.getClass().getName() + "@");
            System.out.println("\n" + pb.getClass().getName() + "@" + Integer.toHexString(pb.hashCode()));
            System.out.println();
        }
    }
}
class PhoneBook {
    Map<String, String> pb;
    private String string;

    PhoneBook() {
        pb = new HashMap<>();
    }

    void add(String name, String phone) {
        pb.put(phone, name);
    }

    List<String> get(String name) {
        //string = name;
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : pb.entrySet()) {
            if (name.equals(entry.getValue()))
                list.add(entry.getKey());
        }
        System.out.print(name);
        return list;

    }

// =========================  //

    @Override
    public String toString() {
        return pb.toString();
    }
}
