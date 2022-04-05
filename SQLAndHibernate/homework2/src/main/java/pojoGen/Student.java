package pojoGen;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int age;

    @Column (name = "registration_date")
    @Getter
    @Setter
    private LocalDateTime registrationDate;

}
