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

public class Key implements Serializable {
    @Column (name = "student_id")
    @Getter
    @Setter
    private int studentId;

    @Column (name = "course_id")
    @Getter
    @Setter
    private int courseId;

}