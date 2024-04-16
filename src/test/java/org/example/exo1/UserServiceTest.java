package org.example.exo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @org.junit.jupiter.api.Test
    void getUserById() {
        // Créer un mock pour l'interface UserRepository
        UserRepository userRepositoryMock = mock(UserRepository.class);

        // Créer un utilisateur
        User user = new User(1, "Ouartsi Fahd");

        // Définir le comportement du mock pour la méthode findUserById
        when(userRepositoryMock.findUserById(1)).thenReturn(user);

        // Créer une instance de la classe UserService en lui passant le mock
        UserService userService = new UserService(userRepositoryMock);

        // Appeler la méthode getUserById avec l'ID de l'utilisateur
        User result = userService.getUserById(1);

        // Vérifier que la méthode findUserById sur l'objet mock est appelée avec le bon argument
        verify(userRepositoryMock).findUserById(1);

        // Vérifier que le résultat correspond à l'utilisateur factice
        assertEquals(user, result);
    }
}