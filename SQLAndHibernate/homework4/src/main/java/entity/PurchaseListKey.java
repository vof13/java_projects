package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@ToString
public class PurchaseListKey implements Serializable {

    @Column(name = "student_name")
    @Getter
    @Setter
    private String studentName;

    @Column (name = "course_name")
    @Getter
    @Setter
    private String courseName;
}
