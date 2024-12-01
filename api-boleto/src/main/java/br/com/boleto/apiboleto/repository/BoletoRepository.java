package br.com.boleto.apiboleto.repository;

import br.com.boleto.apiboleto.entity.BoletoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BoletoRepository extends CrudRepository<BoletoEntity, UUID> {
    Optional<BoletoEntity> findByCodigoBarras(String codigoBarras);
}
