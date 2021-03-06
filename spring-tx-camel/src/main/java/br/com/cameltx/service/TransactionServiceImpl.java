package br.com.cameltx.service;

import br.com.cameltx.domain.Transaction;
import br.com.cameltx.dto.TransactionCreateRequest;
import br.com.cameltx.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author felipeleonhardt
 * Spring transactions examples
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private final String rollbackForInfo = "force-rollback";

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * Running in different cenarios
     * @param request
     */
    public void save(TransactionCreateRequest request){
        try{
            saveWithTransaction(request.getInfo());
            saveWithTransactionTemplate(request.getInfo());
            saveWithoutTransaction();
        }catch (Exception ex){
            // only for learn purposes
            ex.printStackTrace();
        }
    }

    /**
     * Rollback only an Exception occurs
     *
     * @param info
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveWithTransaction(String info) throws Exception {
        transactionRepository.save(new Transaction(info));
        // forcing rollback
        if (info.equals(rollbackForInfo))
            throw new Exception("Rolling back");
    }

    /**
     * Saving with TransactionTemplate
     * @param info
     */
    private void saveWithTransactionTemplate(String info){
        transactionTemplate.execute(callback ->{
            Transaction transaction;
            try {
                transaction = transactionRepository.save(new Transaction(String.format("transaction-template: %s", info)));
                if (info.equals(rollbackForInfo))
                    throw new Exception("Rolling back inside transaction template");
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
            return transaction;
        });
    }

    /**
     * Rollback will not work if an exception occurs, because is running without @Transactional annotation
     *
     * @throws Exception
     */
    private void saveWithoutTransaction() throws Exception {
        transactionRepository.save(new Transaction("will save forever without @Transactional annotation"));
        // rollback will not work
        if (rollbackForInfo.equals(rollbackForInfo))
            throw new Exception("rollback will not work because it's running without @Transactional annotation");
    }
}
