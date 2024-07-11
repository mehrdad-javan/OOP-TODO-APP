package se.lexicon.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.impl.AppUserDAOImpl;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserDaoTest {

    AppUserDAO testObject;

    @BeforeEach
    public void setUp() {
        testObject = AppUserDAOImpl.getInstance();
    }

    @Test
    public void test_add_AppUser_and_FindByUsername() {
        AppUser createdUser = testObject.persist(new AppUser("admin", "123456", AppRole.APP_ADMIN));
        assertNotNull(createdUser);
        assertEquals(1, testObject.findAll().size());
        AppUser foundUser = testObject.findByUsername("admin");
        assertEquals(foundUser, createdUser);
        assertNull(testObject.findByUsername("admin12"));
    }


}
