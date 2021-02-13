package br.com.springtx.service;

/**
 * @author felipeleonhardt
 * Spring transactions examples
 */
public interface TransactionService {

    public void saveWithTransaction(String info) throws Exception;
    public void saveWithoutTransaction() throws Exception;
    public void saveWithTransactionTemplate(String info);
}
