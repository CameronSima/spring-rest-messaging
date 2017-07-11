package sima.cameron.geomessaging.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * Created by cameronsima on 7/8/17.
 */
@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="CREATED_AT", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name="BODY")
    private String body;

    @Column(name="COMMENTS")
    @OneToMany(cascade = CascadeType.ALL, mappedBy="message")
    private Set<Comment> comments;

    @JoinColumn(name="AUTHOR_KEY")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComment(Comment comment) {
        comments.add(comment);
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}
