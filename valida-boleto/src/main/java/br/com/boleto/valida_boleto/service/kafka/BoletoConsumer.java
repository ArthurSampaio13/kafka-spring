package br.com.boleto.valida_boleto.service.kafka;

import br.com.boleto.avro.Boleto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class BoletoConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoletoConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topico-boleto}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeBoleto(@Payload Boleto boleto) {
        LOGGER.info("Consumindo mensagem -> {}", boleto);
        System.out.println(boleto.toString());
    }

}
