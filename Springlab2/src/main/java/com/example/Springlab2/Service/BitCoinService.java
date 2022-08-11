package com.example.Springlab2.Service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitCoinService {

    public String getBitcoinPrice(String name) {
        String apiURL = "https://api.coincap.io/v2/assets/" + name;
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