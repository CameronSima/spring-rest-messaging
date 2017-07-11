package sima.cameron.geomessaging.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by cameronsima on 7/8/17.
 */
@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name = "CREATED_AT", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name="BODY")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MESSAGE", nullable = false)
    private Message message;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARENT_COMMENT")
    private Comment parentComment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AUTHOR", nullable = false)
    private User author;

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
