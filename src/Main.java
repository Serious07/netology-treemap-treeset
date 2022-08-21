import Person.Person;
import Person.PersonsComparator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Илья", "Великолепный", 17));
        persons.add(new Person("Ольга", "Красивая Поразительная", 15));
        persons.add(new Person("Владимир", "Властный Мощный Обоятельный", 22));
        persons.add(new Person("Татьяна", "Сильная Бвстрая Ловкая", 29));
        persons.add(new Person("Екатерина", "Богатая Смелая", 34));
        persons.add(new Person("Олег", "Умный", 40));

        Collections.sort(persons, new PersonsComparator());

        for(Person p : persons){
            System.out.println(p);
        }
    }
}
