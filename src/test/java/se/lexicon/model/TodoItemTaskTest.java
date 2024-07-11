package se.lexicon.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTaskTest {

    public static final Person TEAM_LEADER = new Person("Mehrdad", "Javan", "mehrdad.javan@lexicon.se", new AppUser("admin", "123456", AppRole.APP_ADMIN));
    public static final TodoItem TASK_1 = new TodoItem("Task1", "task1 description", LocalDate.parse("2022-05-10"), false, TEAM_LEADER);
    public static final TodoItem TASK_2 = new TodoItem("Task2", "task2 description", LocalDate.parse("2022-05-02"), true, TEAM_LEADER);
    public static final Person DEVELOPER_1 = new Person("dev1", "dev1", "dev1.test@lexicon.se", new AppUser("user", "123456", AppRole.APP_USER));
    public static final Person DEVELOPER_2 = new Person("dev2", "dev2", "dev2.test@lexicon.se", new AppUser("user", "123456", AppRole.APP_USER));

    private TodoItemTask testObject1;
    private TodoItemTask testObject2;

    @BeforeEach
    public void setup() {
        testObject1 = new TodoItemTask(TASK_1, DEVELOPER_1);
        testObject2 = new TodoItemTask(TASK_2);
    }

    @Test
    public void testObject_successfully_instantiated() {
        assertEquals(TASK_1, testObject1.getTodoItem());
        assertEquals(DEVELOPER_1, testObject1.getAssignee());

        assertEquals(TASK_2, testObject2.getTodoItem());
        assertNull(testObject2.getAssignee());

    }

    @Test
    public void test_isAssigned_true() {
        assertTrue(testObject1.isAssigned());
    }

    @Test
    public void test_isAssigned_false() {
        assertFalse(testObject2.isAssigned());
    }


}