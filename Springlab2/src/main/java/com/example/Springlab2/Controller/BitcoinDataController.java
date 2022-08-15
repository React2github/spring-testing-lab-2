package com.example.Springlab2.Controller;

import com.example.Springlab2.Service.BitCoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BitcoinDataController {

    @Autowired
    private BitCoinService bitcoinService;

    public BitcoinDataController(BitCoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }

    @GetMapping("/bitcoin")
    public String getPrice() {
        log.trace("");
        String response = "The current price for one Bitcoin is " + (bitcoinService.getBitcoinPrice("bitcoin"));
        log.trace("");
        return response;

    }

}
