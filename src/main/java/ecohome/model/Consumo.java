package ecohome.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "TB_CONSUMO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consumo")
    private long idConsumo;

    @Column(name = "data_hora")
    private LocalDate dataConsumo;

    @Column(name = "consumo_kwh")
    private Float quantidadeConsumo;

    @Column(name = "gastos")
    private Float gastosConsumo;

    @ManyToOne
    @JoinColumn(name = "id_eletrodomestico")
    private Eletrodomestico eletrodomestico;

    public Consumo(Eletrodomestico eletrodomestico, LocalDate dataConsumo, Float quantidadeConsumo, Float gastosConsumo) {
        this.eletrodomestico = eletrodomestico;
        this.dataConsumo = dataConsumo;
        this.quantidadeConsumo = quantidadeConsumo;
        this.gastosConsumo = gastosConsumo;
    }
}