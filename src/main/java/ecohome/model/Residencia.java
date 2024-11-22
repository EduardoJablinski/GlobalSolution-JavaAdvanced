package ecohome.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TB_RESIDENCIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Residencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residencia")
    private long idResidencia;

    @Column(name = "nome_residencia")
    private String nomeResidencia;

    @Column(name = "endereco")
    private String enderecoResidencia;

    @Column(name = "numero")
    private long numeroResidencia;

    @Column(name = "cidade")
    private String cidadeResidencia;

    @Column(name = "estado")
    private String estadoResidencia;

    @Column(name = "cep")
    private String cepResidencia;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private MyAppUser usuario;

    public Residencia(MyAppUser usuario, String nomeResidencia, String enderecoResidencia,
                      long numeroResidencia, String cidadeResidencia, String estadoResidencia,
                      String cepResidencia) {
        this.usuario = usuario;
        this.nomeResidencia = nomeResidencia;
        this.enderecoResidencia = enderecoResidencia;
        this.numeroResidencia = numeroResidencia;
        this.cidadeResidencia = cidadeResidencia;
        this.estadoResidencia = estadoResidencia;
        this.cepResidencia = cepResidencia;
    }
}