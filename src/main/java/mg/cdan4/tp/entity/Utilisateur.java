package mg.cdan4.tp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Email(message = "S'il vous plaît, mettez une adresse email valide")
    private String email;

    @NotBlank
    @Size(min = 8, max = 15)
    private String password;

    @NotBlank
    private String gender;

    @Size(max = 100)
    private String note;

    @AssertTrue
    private boolean married;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date birthday;

    @NotBlank
    private String profession;

    @Min(value = 20_000)
    @Max(value = 200_000)
    private long income;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Utilisateur formateur;

}
