import org.junit.jupiter.api.*;
import ru.netology.Contact;
import ru.netology.PhoneBook;


import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PhoneBookTests {
    Contact cont1, cont2, cont3, newCont;
    PhoneBook book;
    Map<String, List<Contact>> bookMap;

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

    @BeforeEach
    public void cratePhoneBook() {
        cont1 = new Contact("Ivan", "123");
        cont2 = new Contact("Petr", "345");
        cont3 = new Contact("Semen", "678");
        newCont = new Contact("Ann", "000");
        bookMap = new HashMap<>();
        bookMap.put("family", new ArrayList(Arrays.asList(cont1, cont2)));
        bookMap.put("friends", new ArrayList(Arrays.asList(cont2, cont3)));
        book = new PhoneBook(bookMap);

    }

    @AfterEach
    public void deletePhoneBook() {
        bookMap = null;
        book = null;
    }

    @Test
    public void testFoundGroup() {
        List<Contact> list = Arrays.asList(cont1, cont2);
        assertThat(list, equalTo(book.foundGroup("family")));
    }

    @Test
    public void testFoundContact() {
        assertThat(cont2, equalTo(book.foundContact("345")));
    }

    @Test
    public void testAddContact() {
        assertThat(book.addContact(newCont, new String[]{"family", "friends"}), hasValue(hasItem(newCont)));

    }

    @Test
    public void testDeleteContact() {
        Map<String, List<Contact>> newBook = new HashMap<>();
        newBook.put("family", new ArrayList(Arrays.asList(cont1)));
        newBook.put("friends", new ArrayList(Arrays.asList(cont3)));
        assertThat(book.deleteContact(cont2), equalTo(newBook));
    }
}
