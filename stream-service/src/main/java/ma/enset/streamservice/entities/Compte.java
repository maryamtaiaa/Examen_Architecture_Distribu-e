package ma.enset.streamservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Compte {
    private long code;
    private double solde;
    private Date dateC;
    private String type;
    private String etat;
    private List<Operation> operations;
}
