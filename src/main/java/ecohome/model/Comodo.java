package ecohome.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TB_COMODO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comodo")
    private long idComodo;

    @Column(name = "nome_comodo")
    private String nomeComodo;

    @ManyToOne
    @JoinColumn(name = "id_residencia")
    private Residencia residencia;

    public Comodo(Residencia residencia, String nomeComodo) {
        this.residencia = residencia;
        this.nomeComodo = nomeComodo;
    }
}