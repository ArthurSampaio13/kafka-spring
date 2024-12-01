package br.com.boleto.apiboleto.mapper;

import br.com.boleto.apiboleto.dto.BoletoDTO;
import br.com.boleto.apiboleto.entity.BoletoEntity;
import br.com.boleto.avro.Boleto;

public class BoletoMapper {
    public static BoletoDTO toDTO(BoletoEntity boletoEntity) {
        return BoletoDTO.builder()
                .situacaoBoleto(boletoEntity.getSituacaoBoleto())
                .codigoBarras(boletoEntity.getCodigoBarras())
                .dataCriacao(boletoEntity.getDataCriacao())
                .dataAtualizacao(boletoEntity.getDataAtualizacao())
                .build();
    }

    public static Boleto toAVRO(BoletoEntity boletoEntity) {
        return Boleto.newBuilder()
                .setSituacaoBoleto(boletoEntity.getSituacaoBoleto().ordinal())
                .setCodigoBarras(boletoEntity.getCodigoBarras())
                .build();
    }
}
