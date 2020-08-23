package com.sreedhar.msscbeerservice.services;

import com.sreedhar.msscbeerservice.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface BeerService {

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateById(UUID beerId, BeerDto beerDto);
}
