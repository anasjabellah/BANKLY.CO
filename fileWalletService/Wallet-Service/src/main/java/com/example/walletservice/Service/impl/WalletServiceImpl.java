package com.example.walletservice.Service.impl;


import com.example.walletservice.Entity.Wallet;
import com.example.walletservice.Reposetry.WalletReposetry;
import com.example.walletservice.Service.ServiceWallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements ServiceWallet {

    @Autowired
    private WalletReposetry walletRepository ;

    @Override
    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet findById(String id) {
        return walletRepository.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void deleteById(String id) {
        walletRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Wallet updet(Wallet wallet) {
        return walletRepository.save(wallet);
    }
}
