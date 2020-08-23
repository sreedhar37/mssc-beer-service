package com.sreedhar.msscbeerservice.bootstrap;

import com.sreedhar.msscbeerservice.domain.Beer;
import com.sreedhar.msscbeerservice.repository.BeerRepository;
import com.sreedhar.msscbeerservice.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class BeerLoader  implements CommandLineRunner {

    public final String BEER_1_UPC = "0631234200036";
    public final String BEER_2_UPC = "0631234200019";
    public final String BEER_3_UPC = "0631234200013";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadObjects();
    }

    private void loadObjects() {
        if(beerRepository.count() ==0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bob")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(10)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.95")).build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(10)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("10.95")).build());
        }

        log.info("Loaded beer {}", beerRepository.count());
    }
}
