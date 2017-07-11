package sima.cameron.geomessaging.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by cameronsima on 7/8/17.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name = "JOINED_AT", insertable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date joinedDate;

    @Column(name="USERNAME")
    private String username;

    @Column(name="EMAIL")
    private String email;

    @Column(name="MESSAGES")
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Message> messages;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public void setMessage(Message message) {
        messages.add(message);
    }
}
