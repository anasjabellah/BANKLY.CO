package com.example.walletservice.Reposetry;

import com.example.walletservice.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletReposetry  extends JpaRepository<Wallet , Long> {
}
