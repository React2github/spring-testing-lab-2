package Integrationtests;

import com.example.Springlab2.Service.BitCoinService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BitcoinServiceIntegrationTest {

    @Test
    void shouldReturnPrice() {
        BitCoinService bitCoinService = new BitCoinService();
        String currentPrice = bitCoinService.getBitcoinPrice("bitcoin");
        assertThat(currentPrice).isNotNull();
    }
}