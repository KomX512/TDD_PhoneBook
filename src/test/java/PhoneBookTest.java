import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
    private PhoneBook testBook;

    @BeforeAll
    static void startTest() {
        System.out.println("Начало тестирования...");
    }

    @BeforeEach
    void addressInit() {
        testBook = new PhoneBook();
    }

    @Test
    void testAddMethod() {
        String[] names = {"Василий", "Петр", "Колбасный", "Кварц-15"};
        String[] numbers = {"2223312", "123456", "234-654", "150015"};
        for (int i = 0; i < names.length; i++) {
            System.out.println("Добавляем " + names[i] + " " + numbers[i]);
            assertEquals(i+1, testBook.add(names[i], numbers[i]));
        }
    }

    @AfterEach
    void endTest() {
        System.out.println("Тестирование завершено!");
    }
}
