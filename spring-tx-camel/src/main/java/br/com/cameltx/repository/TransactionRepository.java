package br.com.cameltx.repository;

import br.com.cameltx.domain.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author felipeleonhardt
 * Spring transactions examples
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
