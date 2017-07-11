package sima.cameron.geomessaging.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sima.cameron.geomessaging.Model.User;
import sima.cameron.geomessaging.repository.UserRepository;

import javax.inject.Inject;

/**
 * Created by cameronsima on 7/11/17.
 */

@RequestMapping("/user")
@RestController
public class UserController {

    @Inject
    private UserRepository userRepository;

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public ResponseEntity<User> newUser(@RequestBody User user) {
        user = userRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
