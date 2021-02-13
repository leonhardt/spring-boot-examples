package br.com.cameltx.service;

import br.com.cameltx.dto.TransactionCreateRequest;

/**
 * @author felipeleonhardt
 * Spring transactions examples
 */
public interface TransactionService {

    public void save(TransactionCreateRequest request);
}
