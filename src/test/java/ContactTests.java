import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import ru.netology.Contact;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.object.HasToString.hasToString;

public class ContactTests {
    static Contact contact;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Начинаем проверку класса");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("Проверка класса окончена");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Начинаем новый тест");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Тест окночен");
    }

    @BeforeAll
    public static void createContact() {
        contact = new Contact("ann", "789");
    }

    @Test
    public void checkProperty() {
        Contact contact = new Contact("ann", "789");
        assertThat(contact, Matchers.<Contact>hasProperty("name"));
    }

    @Test
    public void testToString() {
        Contact contact = new Contact("ann", "789");
        assertThat(contact, hasToString("ann - 789"));
    }
}
