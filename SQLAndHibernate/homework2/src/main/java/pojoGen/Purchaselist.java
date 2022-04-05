package pojoGen;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "purchaselist")
public class Purchaselist {
    @Id
    @Getter
    @Setter
    @Column(name = "student_name", length = 500)
    private String studentName;

    @Getter
    @Setter
    @Column(name = "course_name", length = 500)
    private String courseName;

    @Getter
    @Setter
    @Column(name = "price")
    private Integer price;

    @Getter
    @Setter
    @Column(name = "subscription_date")
    private Instant subscriptionDate;

}