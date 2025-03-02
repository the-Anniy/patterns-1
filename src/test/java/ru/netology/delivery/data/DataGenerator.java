package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = new String[]{"Майкоп", "Санкт-Петербург", "Москва", "Ростов", "Ростов-на-Дону", "Абакан", "Грозный", "Нальчик",
                "Великий Новгород", "Нижний Новгород", "Ставрополь", "Брянск", "Курск", "Орел", "Балашиха", "Реутов", "Волгоград", "Мурманск",
                "Тамбов", "Владимир", "Ярославль", "Смоленск", "Владивосток", "Казань", "Чита", "Пенза", "Тула", "Тверь",
                "Омск", "Оренбург", "Нарьян-Мар", "Ханты-Мансийск", "Анандырь"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
