import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;

@Setter
@Getter
public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "Мия", "Долгова", 37, "Россия");
        User user2 = new User(2, "Александра", "Смирнова", 25, "Молдова");
        User user3 = new User(3, "Василий", "Кузнецов", 42, "Россия");
        User user4 = new User(4, "Лев", "Еремин", 75, "Казахстан");
        User user5 = new User(5, "Илья", "Овсянников", 21, "Россия");
        User user6 = new User(6, "Александр", "Козлов", 30, "Казахстан");
        User user7 = new User(7, "Максим", "Щербаков", 37, "Россия");
        User user8 = new User(8, "Мария", "Корнеева", 25, "Киргизия");
        User user9 = new User(9, "Вера", "Семёнова", 47, "Россия");
        User user10 = new User(10, "Али", "Иванов", 19, "Россия");

        List<User> userList = List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);


        //Сортировка по lastName
        userList.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(System.out::println);

        System.out.println("----------");

        //Сортировка по age
        userList.stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(System.out::println);

        System.out.println("----------");

        //Проверка, что для всех пользователей age > 7
        boolean allSeven = userList.stream()
                .allMatch(user -> user.getAge() > 7);
        System.out.println(allSeven);

        System.out.println("----------");

        //Вычисление среднего возраста пользователей
        double average = userList.stream()
                .mapToInt(User::getAge)
                .average()
                .getAsDouble();
        System.out.println(average);

        System.out.println("----------");

        //Вывод количества разных стран проживания
        long countUniqueCountry = userList.stream()
                .map(User::getCountry)
                .distinct()
                .count();
        System.out.println(countUniqueCountry);

        System.out.println("----------");
    }
}
