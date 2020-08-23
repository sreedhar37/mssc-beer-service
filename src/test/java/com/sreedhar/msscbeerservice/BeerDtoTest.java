package com.sreedhar.msscbeerservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sreedhar.msscbeerservice.web.model.BeerDto;
import com.sreedhar.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.math.BigDecimal;
import java.util.UUID;

@JsonTest
public class BeerDtoTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("ALE")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("12.99"))
                .upc("1234232323")
                .build();

        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

}
