import java.util.*;

public class Program{
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", "Johnson", 25));
        people.add(new Person("Bob", "Smith", 30));
        people.add(new Person("Charlie", "Brown", 28));
        people.add(new Person("Diana", "Evans", 9));
        people.add(new Person("Ethan", "Miller", 27));
        people.add(new Person("Fiona", "Davis", 24));
        people.add(new Person("George", "Clark", 35));
        people.add(new Person("Hannah", "Lewis", 29));
        people.add(new Person("Bob", "Walker", 47));
        people.add(new Person("Jasmine", "Hall", 26));

        //display matching name
        List<Person> matchName = new ArrayList<>();

        //Method 1:
//        for(int i = 0; i < people.size(); i++){
//            Person thisPerson = people.get(i);
//
//            for (int x = 0; x < people.size(); x++){
//                if (i == x) continue; //skips self comparison and compares .get(i) to .get(x)
//                Person thatPerson = people.get(x);
//
//                if (thisPerson.getFirstName().equalsIgnoreCase(thatPerson.getFirstName())){
//                    if(!matchName.contains(thisPerson)){
//                        matchName.add(thisPerson);
//                    }
//                    if (!matchName.contains(thatPerson)){
//                        matchName.add(thatPerson);
//                    }
//                }
//            }
//        }

        //Method 2:
        for(int i = 0; i < people.size(); i++){
            Person thisPerson = people.get(i);

            for (int x = i + 1; x < people.size(); x++){
                //compares .get(i) to .get(x)
                //starting from different index which skips comparing to self
                Person thatPerson = people.get(x);

                if (thisPerson.getFirstName().equalsIgnoreCase(thatPerson.getFirstName())){
                    if(!matchName.contains(thisPerson)){ //skips adding it twice
                        matchName.add(thisPerson);
                    }
                    if (!matchName.contains(thatPerson)){
                        matchName.add(thatPerson);
                    }
                }
            }
        }
        for (Person p : matchName) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }

        //Method 3 (HashMap):
        Map<String, Integer> nameCount = new HashMap<>();
        //assigns String as key and Integer as value
        for (Person p : people){
            String keyName = p.getFirstName().toLowerCase();
            nameCount.put(keyName, nameCount.getOrDefault(keyName, 0) +1);
            //.put adds key/value to nameCount HashMap collection
            //.getOrDefault searches for value associated with key (in this case name)
            // if key is not found returns "default value", which is 0 in this case
            // each time key is found add +1 to the value
        }

        List<Person> matchName2 = new ArrayList<>();
        for (Person p : people){
            if(nameCount.get(p.getFirstName().toLowerCase()) > 1) {
                matchName2.add(p);
                //looks up the name (key) IN THE MAP and returns its paired value (count)
                //compares the paired value to > 1
                // if greater than 1 (meaning matching name) adds to new ArrayList
            }
        }

        for (Person p : matchName2) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }

        //display average age
        int total = 0;
        double average = 0;
        for(Person person:people){
            total += person.getAge();
            average = total / people.size();
        }
        System.out.println("Average age of all people: " + average);

        //display oldest & youngest
        Collections.sort(people);
        System.out.println("Lowest Age: " + people.get(0).getAge());
        System.out.println("Highest Age: " + people.get(people.size()-1).getAge());
    }

}
