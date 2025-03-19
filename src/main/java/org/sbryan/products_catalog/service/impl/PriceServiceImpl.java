package org.sbryan.products_catalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.sbryan.products_catalog.db.PriceRepository;
import org.sbryan.products_catalog.codegen.types.Price;
import org.sbryan.products_catalog.mapper.PriceMapper;
import org.sbryan.products_catalog.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper mapper;

    @Override
    public List<Price> getPricesByProductId(String productId) {
        return mapper.map(priceRepository.findPriceEntityByProductId(productId));
    }


    @Override
    public List<Price> updatePrices(List<Price> prices) {
        var pricesList = prices.stream().map(mapper::map).toList();
        return StreamSupport.stream(priceRepository.saveAll(pricesList).spliterator(), false)
                .map(mapper::map)
                .toList();
    }

    @Override
    public Price updatePrice(Price price) {
        System.out.println(price.toString());
        var p = mapper.map(price);
        System.out.println(p.getMargin());
        return mapper.map(priceRepository.save(mapper.map(price)));
    }

    @Override
    public Price create(Price price) {
        return mapper.map(priceRepository.save(mapper.map(price)));
    }
}
