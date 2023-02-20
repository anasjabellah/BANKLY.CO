package com.example.operationservice.Service.impl;

import com.example.operationservice.Dto.WalletFeuil;
import com.example.operationservice.Entity.Operation;
import com.example.operationservice.Entity.Type;
import com.example.operationservice.Liaison.WalletRequiredRest;
import com.example.operationservice.Repository.OperationRepository;
import com.example.operationservice.Service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;


    private  final WalletRequiredRest walletRequiredRest ;

    public OperationServiceImpl(WalletRequiredRest walletRequiredRest) {
        this.walletRequiredRest = walletRequiredRest;
    }


    @Override
    public Operation passerOperation(Operation operation) {
        if(operation.getPortefeuil() ==  null){
            System.out.println("Il faut citer un portefeuil valide");
        }

        Optional<WalletFeuil> walletFeuil  = walletRequiredRest.findByReference(operation.getPortefeuil());

        if(operation.getMontant()!= null  && walletFeuil.isPresent() && walletFeuil.get().getBalance() > 0){
            operation.setDate(LocalDate.now());

            if(operation.getMontant() > 0 ){  operation.setType(Type.Depot); }
            if( operation.getMontant() < 0 ){
                if(walletFeuil.get().getBalance() >-operation.getMontant()){
                    operation.setType(Type.Retrait);
                }
                else {
                    System.out.println("le montant que vous voulez retirer est supérieur à votre solde");
                    return operation ;
                }
            }

            operation.setPortefeuil(walletFeuil.get().getName());
            walletFeuil.get().setBalance(walletFeuil.get().getBalance() + operation.getMontant() );
            System.out.println(walletFeuil.get());
            //walletRequiredRest.update(walletFeuil.get());
            return  operationRepository.save(operation);

        }

        System.out.println("Une erreur s'est produite");
        return operation;
    }

    @Override
    public Optional<Operation> findOperationByPortefeuil(String portefeuil) {
        return operationRepository.findOperationByPortefeuil(portefeuil);
    }
}
