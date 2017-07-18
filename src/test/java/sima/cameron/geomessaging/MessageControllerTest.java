package sima.cameron.geomessaging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sima.cameron.geomessaging.controller.MessageController;
import sima.cameron.geomessaging.repository.MessageRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



/**
 * Created by cameronsima on 7/12/17.
 */
@WebMvcTest(MessageController.class)
@RunWith(SpringRunner.class)
public class MessageControllerTest {

    private MockMvc mvc;

    @MockBean
    private MessageRepository messageRepository;

    @Test
    public void testGetMessage() throws Exception {
        this.mvc.perform(get("/message/1").accept(MediaType.APPLICATION_JSON));
    }
}
