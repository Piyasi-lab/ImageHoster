package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * this class denotes a comment that can be posted on any image
 */
@Entity
@Table(name = "comment")
public class Comment {

    /**
     * unique id for comment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * text of the comment posted by user
     */
    @Column(columnDefinition = "TEXT")
    private String text;

    /**
     * date on which the comment was posted
     */
    @Column(name = "createdDate")
    private LocalDate createdDate;

    /**
     * the user who has posted the comment
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * the image on which the comment has been posted
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    public Comment(Integer id, String text, LocalDate createdDate, User user, Image image) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
        this.user = user;
        this.image = image;
    }

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
