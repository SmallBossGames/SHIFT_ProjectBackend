package ftc.shift.sample.services;

import ftc.shift.sample.models.User;
import ftc.shift.sample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User provideUser(String userId)
    {
        return userRepository.fetchUser(userId);
    }

    public Collection<User> provideUsers()
    {
        return userRepository.fetchUsers();
    }

    public User createUser(User user)
    {
        return userRepository.createUser(user);
    }

    public User updateUser(String userId, User user)
    {
        return userRepository.updateUser(userId, user);
    }

    public void deleteUser(String userId)
    {
        userRepository.deleteUser(userId);
    }
}
