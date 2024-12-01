package br.com.boleto.apiboleto.mapper;

import br.com.boleto.apiboleto.dto.BoletoDTO;
import br.com.boleto.apiboleto.entity.BoletoEntity;

public class BoletoMapper {
    public static BoletoDTO toDTO(BoletoEntity boletoEntity) {
        return BoletoDTO.builder()
                .situacaoBoleto(boletoEntity.getSituacaoBoleto())
                .codigoBarras(boletoEntity.getCodigoBarras())
                .dataCriacao(boletoEntity.getDataCriacao())
                .dataAtualizacao(boletoEntity.getDataAtualizacao())
                .build();
    }
}
