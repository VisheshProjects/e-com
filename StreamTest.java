import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        String str = "This is jAva STring";

        char[] charArr = str.toCharArray();

        Map<Character, Long> charMap = new HashMap<Character, Long>();

        for(Character item: charArr){
            Long value = charMap.get(item) == null ? 0 : charMap.get(item);

            charMap.put(item , value+1);
        }
        System.out.println(charMap);


        charMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(charMap);

        List<Person> list = new ArrayList<>();
        list.add(new Person(2, "Sanket1"));
        list.add(new Person(4, "Sanket2"));
        list.add(new Person(2, "Sanket3"));
        list.add(new Person(6, "Sanket4"));
        list.add(new Person(6, "Sanket5"));

        // 2 agr goub me count
        Map<Integer, Long> countmap = list.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() , Collectors.counting()));

        System.out.println(countmap);

        Map<Integer, List<Person>> countmapList = list.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() , Collectors.toList()));

        System.out.println(countmapList);

        List<Person> sortedlist = list.stream()
                .sorted(Comparator.comparing(person -> person.getAge()))
                .toList();

        //System.out.println(sortedlist);

        sortedlist.forEach(p -> System.out.println(p.getAge() +"  -  "+p.getName()));

        System.out.println("////////////////////////////////////");


        sortedlist = list.stream()
                .filter(p -> p.age >= 3 && p.age <= 8)
                .sorted(Comparator.comparing(person -> person.getAge()))
                .toList();

        sortedlist.forEach(p -> System.out.println(p.getAge() +"  -  "+p.getName()));

        Integer age = list.stream()
                //.max(Comparator.comparingInt(Person::getAge));
                .map(Person::getAge)
                .distinct()
                .sorted(Comparator.reverseOrder())
                        .skip(1)
                                .findFirst().orElseThrow(() -> new IllegalArgumentException("Does not exist!"));
                //.collect(Collectors.maxBy(Comparator.comparingInt(Person::getAge)));

        System.out.println("////////////////////////////////////");

        System.out.println(age);

        List<Integer> dAges = list.stream()
                .map(Person::getAge)
                .distinct().toList();

        System.out.println("////////////////////////////////////");
        System.out.println(dAges);



        System.out.println("////////////////////////////////////");

        Integer[] intArr = { 3, 4, 6, 67, 6, 34, 4, 23, 34, 1 ,7, 88, 9, 6, 88};

        List<Integer> intList = Arrays.stream(intArr).toList();

        Set<Integer> uinqueSet = new HashSet<Integer>();
//        List<Integer> resultList = Arrays.stream(intArr)
//                .filter(p -> !uinqueSet.add(p))
//                .peek(System.out::println) //logging or debugger
//                .distinct()
//                .toList();


        List<Integer> duplicateList = intList.stream()
                        .filter(i-> Collections.frequency(intList, i) > 1)
                .distinct()
                                .toList();

        //IntStream

        System.out.println(duplicateList);




    }

    public static class Person{
        int age;
        String name;
        public Person(int age, String  name){
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
