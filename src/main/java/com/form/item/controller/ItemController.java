package com.form.item.controller;

import com.form.item.to.Item;
import com.form.item.to.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ItemController {

    @Autowired(required = true)
    private RestTemplate clientProductService;


    @GetMapping(value = "/custom/findAll")
    public List<Item> findAll() {
        log.info("Inicio findAll");
        List<Item> items = new ArrayList<>();

        List<Product> products = Arrays.asList(clientProductService.getForObject("http://localhost:8001/products/custom/findAll", Product[].class));


        log.info("Fin findAll: ", items);
        return products.stream().map( p -> new Item(1, p)).collect(Collectors.toList());
    }

    @GetMapping(value = "/custom/search/{id}/{cantidad}")
    public Item getItemById(@PathVariable Long id, @PathVariable Integer cantidad) {
        log.info("Inicio getItemById");

        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());

        Product product = clientProductService.getForObject("http://localhost:8001/products/custom/getById/{id}", Product.class, pathVariables);
        log.info("Fin getItemById");

        return new Item(cantidad, product);
    }
}

