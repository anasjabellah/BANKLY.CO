package com.example.operationservice.Liaison;

import com.example.operationservice.Dto.WalletFeuil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient("Wallet-Service")
public interface WalletRequiredRest {

    @GetMapping("wallet/{id}")
    @ResponseBody
    public Optional<WalletFeuil> findByReference(@PathVariable("id") String id);

    @RequestMapping( value = "/wallet/update", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WalletFeuil update(@RequestBody WalletFeuil walletFeuil);
}
