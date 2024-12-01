package br.com.boleto.apiboleto.service;

import br.com.boleto.apiboleto.controller.exception.ApplicationException;
import br.com.boleto.apiboleto.dto.BoletoDTO;
import br.com.boleto.apiboleto.entity.BoletoEntity;
import br.com.boleto.apiboleto.entity.enums.SituacaoBoleto;
import br.com.boleto.apiboleto.mapper.BoletoMapper;
import br.com.boleto.apiboleto.repository.BoletoRepository;
import br.com.boleto.apiboleto.service.kafka.BoletoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoletoService {
    private final BoletoRepository boletoRepository;
    private final BoletoProducer boletoProducer;

    public BoletoDTO salvar(String codigoBarras) {
        var boletoOptional = boletoRepository.findByCodigoBarras(codigoBarras);
        if (boletoOptional.isPresent()) {
            throw new ApplicationException("Já existe uma solicitação de pagamento para esse boleto");
        }
        var boletoEntity = BoletoEntity.builder()
                .codigoBarras(codigoBarras)
                .situacaoBoleto(SituacaoBoleto.INICIALIZADO)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();
        boletoRepository.save(boletoEntity);
        boletoProducer.enviarMensagem(BoletoMapper.toAVRO(boletoEntity));
        return BoletoMapper.toDTO(boletoEntity);
    }
}
