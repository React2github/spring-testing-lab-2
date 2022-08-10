package com.example.Springlab2.Service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitCoinService {

    public double getBitcoinPrice(String name) {
        String apiURL = "https://api.coincap.io/v2/assets/" + name;
        RestTemplate restTemplate = new RestTemplate();
        DataDTO result = restTemplate.getForObject(apiURL, DataDTO.class);

        return Double.parseDouble(result.getData().getPriceUsd());
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