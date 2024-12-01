package br.com.boleto.apiboleto.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.boleto.apiboleto.entity.enums.SituacaoBoleto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
