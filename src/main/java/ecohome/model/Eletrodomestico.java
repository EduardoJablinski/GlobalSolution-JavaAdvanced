package ecohome.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.*;
import java.util.Date;
import java.time.LocalDate;

@Entity
@Table(name = "TB_ELETRODOMESTICOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eletrodomestico")
    private long idEletrodomestico;

    @Column(name = "nome")
    private String nomeEletrodomestico;

    @Column(name = "potencia_watt")
    private Float potenciaEletrodomestico;

    @Column(name = "tipo")
    private String tipoEletrodomestico;

    @Column(name = "data_instalacao")
    private LocalDate dataInstalacaoEletrodomestico;

    @ManyToOne
    @JoinColumn(name = "id_comodo")
    private Comodo comodo;

    public Eletrodomestico(String nomeEletrodomestico, Float potenciaEletrodomestico, String tipoEletrodomestico, LocalDate dataInstalacaoEletrodomestico, Comodo comodo) {
        this.nomeEletrodomestico = nomeEletrodomestico;
        this.potenciaEletrodomestico = potenciaEletrodomestico;
        this.tipoEletrodomestico = tipoEletrodomestico;
        this.dataInstalacaoEletrodomestico = dataInstalacaoEletrodomestico;
        this.comodo = comodo;
    }

}