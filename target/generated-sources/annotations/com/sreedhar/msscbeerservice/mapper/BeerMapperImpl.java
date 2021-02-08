package com.sreedhar.msscbeerservice.mapper;

import com.sreedhar.msscbeerservice.domain.Beer;
import com.sreedhar.msscbeerservice.domain.Beer.BeerBuilder;
import com.sreedhar.msscbeerservice.web.model.BeerDto;
import com.sreedhar.msscbeerservice.web.model.BeerDto.BeerDtoBuilder;
import com.sreedhar.msscbeerservice.web.model.BeerStyleEnum;

import javax.annotation.processing.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2020-08-24T22:46:34+0800",
        comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (AdoptOpenJDK)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if (beer == null) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.id(beer.getId());
        if (beer.getVersion() != null) {
            beerDto.version(beer.getVersion().intValue());
        }
        beerDto.lastModifiedDate(dateMapper.asOffSetDateTime(beer.getLastModifiedDate()));
        beerDto.beerName(beer.getBeerName());
        if (beer.getBeerStyle() != null) {
            beerDto.beerStyle(Enum.valueOf(BeerStyleEnum.class, beer.getBeerStyle()));
        }
        beerDto.upc(beer.getUpc());
        beerDto.price(beer.getPrice());

        return beerDto.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if (beerDto == null) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id(beerDto.getId());
        if (beerDto.getVersion() != null) {
            beer.version(beerDto.getVersion().longValue());
        }
        beer.lastModifiedDate(dateMapper.asTimeStamp(beerDto.getLastModifiedDate()));
        beer.beerName(beerDto.getBeerName());
        if (beerDto.getBeerStyle() != null) {
            beer.beerStyle(beerDto.getBeerStyle().name());
        }
        beer.upc(beerDto.getUpc());
        beer.price(beerDto.getPrice());

        return beer.build();
    }
}
