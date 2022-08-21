package Person;

import java.util.Comparator;

public class PersonsComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int o1SurnameWordsAmount = o1.getSurname().split(" ").length;
        int o2SurnameWordsAmount = o2.getSurname().split(" ").length;

        if(o1SurnameWordsAmount > o2SurnameWordsAmount){
            return 1;
        } else if (o1SurnameWordsAmount < o2SurnameWordsAmount){
            return -1;
        } else if (o1SurnameWordsAmount == o2SurnameWordsAmount){
            return Integer.compare(o1.getAge(), o2.getAge());
        }

        return 0;
    }
}
