package pl.sda.onetoone;


import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class StudentIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String number;

    @JoinColumn(name = "student_fk")
    @OneToOne
    private Student student;


}


