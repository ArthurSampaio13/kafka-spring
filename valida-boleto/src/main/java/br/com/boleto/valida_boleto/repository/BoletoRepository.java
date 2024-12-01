package br.com.boleto.valida_boleto.repository;

import br.com.boleto.valida_boleto.entity.BoletoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BoletoRepository extends CrudRepository<BoletoEntity, UUID> {
}
