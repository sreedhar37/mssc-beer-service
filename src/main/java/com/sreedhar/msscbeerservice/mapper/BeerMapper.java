package com.sreedhar.msscbeerservice.mapper;

import com.sreedhar.msscbeerservice.domain.Beer;
import com.sreedhar.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
