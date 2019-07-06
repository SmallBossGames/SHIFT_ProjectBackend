package ftc.shift.sample.repositories;

import ftc.shift.sample.models.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class DatabseUserRepository implements UserRepository {
    @Override
    public User fetchUser(String userId) {
        return null;
    }

    @Override
    public Collection<User> fetchUsers() {
        return null;
    }

    @Override
    public User authUser(String name) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(String userId, User user) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }
}
