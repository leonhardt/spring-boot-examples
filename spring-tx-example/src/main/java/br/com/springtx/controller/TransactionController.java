package br.com.springtx.controller;

import br.com.springtx.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author felipeleonhardt
 * Spring transactions examples
 */
@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity create(@RequestBody CreateRequest createRequest) throws Exception{
        try{
            transactionService.saveWithTransaction(createRequest.getInfo());
            transactionService.saveWithTransactionTemplate(createRequest.getInfo());
            transactionService.saveWithoutTransaction();
        }catch (Exception ex){
            // only for learn purposes
            ex.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }

}
