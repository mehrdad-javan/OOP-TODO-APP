package se.lexicon.model;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTest {

    public static final String FIRST_NAME = "Mehrdad";
    public static final String LAST_NAME = "Javan";
    public static final String EMAIL = "mehrdad.javan@lexicon.se";
    private static final AppUser CREDENTIALS = new AppUser("admin", "123456", AppRole.APP_ADMIN);
    private Person testObject;

    @BeforeEach
    public void setUp() {
        testObject = new Person(FIRST_NAME, LAST_NAME, EMAIL, CREDENTIALS);
    }

    @Test
    @Order(1)
    public void testObject_successfully_instantiated() {
        assertEquals(FIRST_NAME, testObject.getFirstName());
        assertEquals(LAST_NAME, testObject.getLastName());
        assertEquals(EMAIL, testObject.getEmail());
        assertEquals(CREDENTIALS, testObject.getCredentials());
    }

    @Test
    public void test_constructor_setFirstName_throws_exception_on_null_firstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Person(null, LAST_NAME, EMAIL, CREDENTIALS)
        );
    }


    @Test
    @Order(2)
    public void test_setFirstName_successfully() {
        testObject.setFirstName("Test");
        assertEquals("Test", testObject.getFirstName());
    }


    @Test
    public void test_equal_successfully() {
        Person expected = new Person("Mehrdad", "Javan", "mehrdad.javan@lexicon.se", CREDENTIALS);
        assertEquals(expected, testObject);
    }


    @Test
    public void test_hashCode_successfully() {
        Person expected = new Person("Mehrdad", "Javan", "mehrdad.javan@lexicon.se", CREDENTIALS);
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    @Order(3)
    public void test_hashCode_failed() {
        Person expected = new Person("mehrdad", "javan", "mehrdad.javan@lexicon.se", CREDENTIALS);
        assertNotEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    @Order(4)
    public void test_toString() {
        Person expected = new Person("Mehrdad", "Javan", "mehrdad.javan@lexicon.se", CREDENTIALS);
        String expectedToString = "Person{id=null, firstName='Mehrdad', lastName='Javan', email='mehrdad.javan@lexicon.se'}";
        //assertEquals(expected.toString(), testObject.toString());
        assertEquals(expectedToString, testObject.toString());
    }


}