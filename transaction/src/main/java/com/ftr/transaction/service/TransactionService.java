package com.ftr.transaction.service;

import com.ftr.transaction.DTO.TransactionDTO;
import com.ftr.transaction.repository.TransactionRepository;
import com.ftr.transaction.response.TransactionResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void saveTransaction(TransactionDTO transactionDTO) {
    }

    public List<TransactionResponse> listAllTransactions() {
        return null;
    }
}
