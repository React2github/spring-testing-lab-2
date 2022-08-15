package com.example.Springlab2.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class BitCoinService {

    public String getBitcoinPrice(String name) {
        String apiURL = "https://api.coincap.io/v2/assets/" + name;
        log.info(apiURL);
        RestTemplate restTemplate = new RestTemplate();
        DataDTO result = restTemplate.getForObject(apiURL, DataDTO.class);
        System.out.println(result.getData().getPriceUsd());
        return result.getData().getPriceUsd();
    }




}

@Getter
@Setter
class BitCoin {
    private String id;
    private String symbol;
    private String priceUsd;
}

@Getter
@Setter
class DataDTO {
    private BitCoin data;
}