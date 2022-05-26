package pl.sda.onetoone;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String firstName;

    private String surname;

    private LocalDate birthDate;

    @OneToOne(mappedBy = "student")
    private StudentIndex studentIndex;


}
