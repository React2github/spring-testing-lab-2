package com.example.Springlab2;


import com.example.Springlab2.Controller.BitcoinDataController;
import com.example.Springlab2.Service.BitCoinService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Springlab2ApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Test
//	void checkPrice(BitCoinService bitCoinService) {
//	BitcoinDataController bitcoinDataController = new BitcoinDataController(bitCoinService);
//	Boolean isGreater;
//		if (bitcoinDataController.getPrice() > 2.0) {
//			isGreater = true;
//		} else isGreater = false;
//	}


}
