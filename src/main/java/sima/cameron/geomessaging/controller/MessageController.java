package sima.cameron.geomessaging.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sima.cameron.geomessaging.Model.Message;
import sima.cameron.geomessaging.repository.MessageRepository;

import javax.inject.Inject;

/**
 * Created by cameronsima on 7/8/17.
 */

@RequestMapping("/message")
@RestController
public class MessageController {

    @Inject
    private MessageRepository messageRepository;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
        Message message = messageRepository.findOne(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public ResponseEntity<Message> newMessage(@RequestBody Message message) {
        message = messageRepository.save(message);
        return new ResponseEntity<Message>(message, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMessage(@PathVariable Long id) {
        messageRepository.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public ResponseEntity<Message> updateMessage(@RequestBody Message message) {
        Message updated = messageRepository.save(message);
        return new ResponseEntity<Message>(updated, HttpStatus.ACCEPTED);
    }
}
