package ftc.shift.sample.api;

import ftc.shift.sample.models.User;
import ftc.shift.sample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private static final String USER_PATH = "/api/v001/users";
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(USER_PATH + "/{userId}")
    public ResponseEntity<User> getUser(
            @PathVariable String userId
    )
    {
        var result = service.provideUser(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping(USER_PATH)
    public ResponseEntity<User> createUser(
            @RequestBody User user
    )
    {
        var result = service.createUser(user);
        return ResponseEntity.ok(result);
    }

    @PatchMapping(USER_PATH + "/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable String userId,
            @RequestBody User user
    )
    {
        var result = service.updateUser(userId, user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(USER_PATH + "/{userId}")
    public void deleteUser(
            @PathVariable String userId
    )
    {
        service.deleteUser(userId);
    }
}
