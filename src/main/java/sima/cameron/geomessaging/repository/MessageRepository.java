package sima.cameron.geomessaging.repository;

import org.springframework.data.repository.CrudRepository;
import sima.cameron.geomessaging.Model.Message;

/**
 * Created by cameronsima on 7/9/17.
 */
public interface MessageRepository extends CrudRepository<Message, Long> {
}
