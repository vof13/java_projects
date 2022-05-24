package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "name", length = 500)
    private String name;

    @Getter
    @Setter
    @Column(name = "duration")
    private Integer duration;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column (columnDefinition = "enum")
    private CourseType type;

    @Getter
    @Setter
    @Column(name = "description", length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    @Getter
    @Setter
    private Teacher teacher;

    @Column(name = "students_count")
    @Getter
    @Setter
    private Integer studentsCount;

    @Column(name = "price")
    @Getter
    @Setter
    private Integer price;

    @Column(name = "price_per_hour")
    @Getter
    @Setter
    private Double pricePerHour;
}