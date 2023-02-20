package com.example.walletservice.Service;

import com.example.walletservice.Entity.Wallet;

import java.util.List;

public interface ServiceWallet {

    List<Wallet> findAll();
    Wallet findById(String id);
    Wallet save(Wallet wallet);
    void deleteById(String id);

    Wallet updet(Wallet wallet);
}
