package Person;

import java.util.Comparator;

public class PersonsComparator implements Comparator<Person> {
    private int minSurnameLength;

    public PersonsComparator(){
        minSurnameLength = -1;
    }

    public PersonsComparator(int minWordsInSurname){
        this.minSurnameLength = minWordsInSurname;
    }

    @Override
    public int compare(Person o1, Person o2) {
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
    }

    private int standardCompare(Person o1, Person o2, int o1SurnameWordsAmount, int o2SurnameWordsAmount){
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
