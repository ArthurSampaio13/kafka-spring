package br.com.boleto.apiboleto.service.kafka;

import br.com.boleto.avro.Boleto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoletoProducer {

    @Value("${spring.kafka.topico-boleto}")
    public String topico;

    private final KafkaTemplate<String, Boleto> kafkaTemplate;

    public void enviarMensagem(Boleto boleto) {
        kafkaTemplate.send(topico, getKey(boleto), boleto);
    }

    private String getKey(Boleto boleto) {
        if (boleto.getCodigoBarras().toString().substring(0, 1).equals("2")) {
            return "chave1";
        }
        return "chave2";
    }
}
