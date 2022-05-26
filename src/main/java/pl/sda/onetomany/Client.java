package pl.sda.onetomany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String nick;

//    @JoinColumn(name = "client_id")
    @OneToMany(mappedBy = "client", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Order> orders;



}
