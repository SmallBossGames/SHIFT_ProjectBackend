package ftc.shift.sample.repositories;

import ftc.shift.sample.models.User;

import java.util.Collection;

public interface UserRepository {
    User fetchUser(String userId);

    Collection<User> fetchUsers();

    User authUser(String name);

    User createUser(User user);

    User updateUser(String userId, User user);

    void deleteUser(String userId);
}
