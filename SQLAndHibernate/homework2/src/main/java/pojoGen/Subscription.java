package pojoGen;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "subscriptions")

public class Subscription {

    @EmbeddedId
    private Key id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false, insertable = false, updatable = false)
    @Getter
    @Setter
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
    @Getter
    @Setter
    private Course course;

    @Column(name = "subscription_date", nullable = false)
    @Getter
    @Setter
    private Instant subscriptionDate;
}