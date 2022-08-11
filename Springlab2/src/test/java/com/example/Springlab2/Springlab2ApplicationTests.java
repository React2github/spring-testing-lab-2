package com.example.Springlab2;


import com.example.Springlab2.Controller.BitcoinDataController;
import com.example.Springlab2.Service.BitCoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class Springlab2ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void returnBasicSearch() {
		BitCoinService bitCoinService = Mockito.mock(BitCoinService.class);
		String bitcoinPrice = "506.022";
		BitcoinDataController bitcoinDataController = new BitcoinDataController(bitCoinService);
		when(bitCoinService.getBitcoinPrice("bitcoin")).thenReturn(bitcoinPrice);
		String expected = "The current price for one Bitcoin is " + bitcoinPrice;
		String actual = bitcoinDataController.getPrice();
		assertEquals(expected, actual);
}

}
