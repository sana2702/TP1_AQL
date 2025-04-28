package TP3.tests;

import static org.mockito.Mockito.*;

import TP3.User;
import TP3.UserRepository;
import TP3.UserService;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private UserRepository userRepositoryMock;
    private UserService userService;

    @Before
    public void setUp() {
        userRepositoryMock = mock(UserRepository.class);
        userService = new UserService(userRepositoryMock);
    }

    @Test
    public void testGetUserById() {
        // Préparer un utilisateur simulé
        User user = new User(1L, "John Doe");
        when(userRepositoryMock.findUserById(1L)).thenReturn(user);

        // Appeler la méthode à tester
        User result = userService.getUserById(1L);

        // Vérifier que la méthode findUserById a été appelée avec le bon argument
        verify(userRepositoryMock).findUserById(1L);
        assert result != null;
        assert result.getName().equals("John Doe");
    }
}

