package br.com.boleto.apiboleto.dto;

import br.com.boleto.apiboleto.entity.enums.SituacaoBoleto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoletoDTO(String codigoBarras,
                        SituacaoBoleto situacaoBoleto,
                        LocalDateTime dataCriacao,
                        LocalDateTime dataAtualizacao) {
}
