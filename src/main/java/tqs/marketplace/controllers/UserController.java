package tqs.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tqs.marketplace.entities.User;
import tqs.marketplace.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userPartialName}")
    public ResponseEntity<List<User>> search(@PathVariable("userPartialName") String userPartialName) {
        return new ResponseEntity<List<User>>(userService.findByName(userPartialName), HttpStatus.OK);
    }

    @GetMapping("/id={userId}")
    public ResponseEntity<User> search(@PathVariable("userId") int userId) {
        return new ResponseEntity<User>(userService.findById(userId), HttpStatus.OK);
    }

}