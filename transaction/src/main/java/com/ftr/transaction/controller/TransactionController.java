package com.ftr.transaction.controller;

import com.ftr.transaction.DTO.TransactionDTO;
import com.ftr.transaction.response.TransactionResponse;
import com.ftr.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    private  TransactionService transactionService;

    @PostMapping(value = "/save")
    public ResponseEntity<TransactionResponse> saveTransaction(@RequestBody TransactionDTO transaction) {

        return ResponseEntity.ok().body(transactionService.saveTransaction(transaction));
    }
}
