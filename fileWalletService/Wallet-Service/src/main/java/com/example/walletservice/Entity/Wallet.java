package com.example.walletservice.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Double balance;

    public Wallet(String name,Double balance){
        this.name = name;
        this.balance = balance;
    }
}
