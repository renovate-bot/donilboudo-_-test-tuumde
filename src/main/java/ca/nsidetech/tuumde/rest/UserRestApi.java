package ca.nsidetech.tuumde.rest;

import ca.nsidetech.tuumde.model.User;
import ca.nsidetech.tuumde.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRestApi {
    private UserService userService;

    @Autowired
    public UserRestApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping(value = "/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/users/{id}")
    public User findUser(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }

    @PutMapping(value = "/users")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
