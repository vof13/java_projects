package entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {
    public LinkedPurchaseList(Key id) {
        this.id = id;
    }

    public LinkedPurchaseList() {
    }

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
}
