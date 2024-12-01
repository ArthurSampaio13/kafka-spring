package br.com.boleto.valida_boleto.entity;

import br.com.boleto.valida_boleto.entity.enums.SituacaoBoleto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoletoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="codigo_barras")
    private String codigoBarras;

    @Column(name="sitacao_boleto")
    private SituacaoBoleto situacaoBoleto;
    
    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name="data_atualizacao")
    private LocalDateTime dataAtualizacao;


}
