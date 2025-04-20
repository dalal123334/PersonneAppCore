package org.sid.personnecore.service;

import org.sid.personnecore.module.User;
import java.util.List;

public interface IUserService {
    User enregistrerUtilisateur(User user);
    User trouverParEmail(String email);
    List<User> getAllUsers();
    User updateUserRole(Long id, String role);
}
