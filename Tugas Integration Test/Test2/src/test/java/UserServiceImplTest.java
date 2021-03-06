import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

public class UserServiceImplTest {
    User user = Mockito.mock(User.class);
    UserDAO userDAO = Mockito.mock(UserDAO.class);
    SecurityService securityService = Mockito.mock(SecurityService.class);

    @Test
    public void assignPasswordTest() throws Exception {
        UserServiceImpl sut = new UserServiceImpl(userDAO,securityService);
        sut.assignPassword(user);
        Mockito.verify(user).getPassword();
    }

    @Test
    public void updateUserTest() throws Exception {
        userDAO.updateUser(user);
        Mockito.verify(userDAO).updateUser(user);
    }
}
