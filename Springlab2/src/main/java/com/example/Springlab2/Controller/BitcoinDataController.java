package com.example.Springlab2.Controller;

import com.example.Springlab2.Service.BitCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitcoinDataController {

    @Autowired
    private BitCoinService bitcoinService;

    public BitcoinDataController(BitCoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }

    @GetMapping("/bitcoin")
    public String getPrice() {
        String response = "The current price for one Bitcoin is " + Math.round(bitcoinService.getBitcoinPrice("bitcoin"));
        return response;
    }

}
