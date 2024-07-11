package se.lexicon.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTest {

    public static final String TITLE = "Task1";
    public static final String DESCRIPTION = "task1 description";
    public static final LocalDate DEADLINE = LocalDate.parse("2024-09-10");
    public static final Person TEAM_LEADER = new Person("Mehrdad", "Javan", "mehrdad.javan@lexicon.se", new AppUser("admin", "123456", AppRole.APP_ADMIN));

    private TodoItem testObject;

    @BeforeEach
    public void setup() {
        testObject = new TodoItem(TITLE, DESCRIPTION, DEADLINE, false, TEAM_LEADER);
    }

    @Test
    public void testObject_successfully_instantiated() {
        assertEquals(TITLE, testObject.getTitle());
        assertEquals(DESCRIPTION, testObject.getDescription());
        assertEquals(DEADLINE, testObject.getDeadLine());
        assertEquals(TEAM_LEADER, testObject.getCreator());
    }

    @Test
    public void test_constructor_setTitle_throws_exception_on_null_title() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TodoItem(null, DESCRIPTION, DEADLINE, false, TEAM_LEADER)
        );
    }

    @Test
    public void test_constructor_setCreator_throws_exception_on_null_creator() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TodoItem(TITLE, DESCRIPTION, DEADLINE, false, null)
        );
    }


    @Test
    public void test_isOverdue_false() {
        assertFalse(testObject.isOverdue());
    }


    @Test
    public void test_isOverdue_true() {
        testObject.setDeadLine(LocalDate.parse("2022-05-01"));
        assertTrue(testObject.isOverdue());
    }


    @Test
    public void test_equal_successfully() {
        TodoItem expected = new TodoItem(TITLE, DESCRIPTION, DEADLINE, false, TEAM_LEADER);
        assertEquals(expected, testObject);
    }


    @Test
    public void test_hashCode_successfully() {
        TodoItem expected = new TodoItem(TITLE, DESCRIPTION, DEADLINE, false, TEAM_LEADER);
        assertEquals(expected.hashCode(), testObject.hashCode());
    }

    @Test
    public void test_hashCode_failed() {
        TodoItem expected = new TodoItem("New Title", DESCRIPTION, DEADLINE, false, TEAM_LEADER);
        assertNotEquals(expected.hashCode(), testObject.hashCode());
    }

}