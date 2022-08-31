import Person.Person;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Илья", "Великолепный", 17));
        persons.add(new Person("Ольга", "Красивая Поразительная", 30));
        persons.add(new Person("Владимир", "Властный Мощный Обоятельный", 22));
        persons.add(new Person("Татьяна", "Сильная Бвстрая Ловкая", 29));
        persons.add(new Person("Екатерина", "Богатая Смелая", 34));
        persons.add(new Person("Олег", "Умный", 40));

        Comparator<Person> personsComparator = (o1, o2) -> {
            int minSurnameLength = -1;

            int o1SurnameWordsAmount = o1.getSurname().split(" ").length;
            int o2SurnameWordsAmount = o2.getSurname().split(" ").length;

            if(minSurnameLength == -1) {
                return standardCompare(o1, o2, o1SurnameWordsAmount, o2SurnameWordsAmount);
            } else {
                if(o1SurnameWordsAmount >= minSurnameLength &&
                        o2SurnameWordsAmount >= minSurnameLength){
                    return Integer.compare(o1.getAge(), o2.getAge());
                } else {
                    return standardCompare(o1, o2, o1SurnameWordsAmount, o2SurnameWordsAmount);
                }
            }
        };

        Collections.sort(persons, personsComparator);

        for(Person p : persons){
            System.out.println(p);
        }
    }

    private static int standardCompare(Person o1, Person o2, int o1SurnameWordsAmount, int o2SurnameWordsAmount){
        if (o1SurnameWordsAmount > o2SurnameWordsAmount) {
            return 1;
        } else if (o1SurnameWordsAmount < o2SurnameWordsAmount) {
            return -1;
        } else if (o1SurnameWordsAmount == o2SurnameWordsAmount) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }

        return 0;
    }
}
