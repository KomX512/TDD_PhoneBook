import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
    private static PhoneBook testBook;

    @BeforeAll
    static void startTest() {
        System.out.println("Начало тестирования...");
    }

    @BeforeEach
    void bookInit() {
        testBook = new PhoneBook();
    }

    @Test
    void testAddMethod() {
        String[] names = {"Василий", "Петр", "Колбасный", "Кварц-15"};
        String[] numbers = {"2223312", "123456", "234-654", "150015"};
        for (int i = 0; i < names.length; i++) {
            System.out.println("Добавляем " + names[i] + " " + numbers[i]);
            assertEquals(i + 1, testBook.add(names[i], numbers[i]));
        }
        System.out.println("Добавляем повторную запись Василий");
        assertEquals(names.length, testBook.add("Василий", "2223312"));
    }

    public static Stream <Arguments> findByNumberTest () {
        return Stream.of(
                Arguments.of("999999", null),
                Arguments.of("2223312", "Василий"),
                Arguments.of("123456", "Петр"),
                Arguments.of("234-654", "Колбасный"),
                Arguments.of("150015", "Кварц-15")
        );
    }

    @ParameterizedTest
    @MethodSource
    void findByNumberTest(String searchParam, String expected){
        fillBook(testBook);
        Assertions.assertEquals(expected, testBook.findByNumber(searchParam));
    }

    public static Stream <Arguments> findByNameTest () {
        return Stream.of(
                Arguments.of("ИИИГОРЬ!", null),
                Arguments.of("Василий", "2223312"),
                Arguments.of("Петр", "123456"),
                Arguments.of("Колбасный", "234-654"),
                Arguments.of("Кварц-15", "150015")
        );
    }

    @ParameterizedTest
    @MethodSource
    void findByNameTest(String searchParam, String expected){
        fillBook(testBook);
        Assertions.assertEquals(expected, testBook.findByNumber(searchParam));
    }

    private void fillBook(PhoneBook testBook) {
        String[] names = {"Василий", "Петр", "Колбасный", "Кварц-15"};
        String[] numbers = {"2223312", "123456", "234-654", "150015"};
        for (int i = 0; i < names.length; i++) {
            testBook.add(names[i], numbers[i]);
        }
    }

    @AfterEach
    void endTest() {
        System.out.println("Тестирование завершено!");
    }
}
