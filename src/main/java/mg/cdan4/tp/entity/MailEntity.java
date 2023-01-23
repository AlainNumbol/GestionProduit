package mg.cdan4.tp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailEntity {
    String mailadresse;
    String subject;
    String contenue;
}
