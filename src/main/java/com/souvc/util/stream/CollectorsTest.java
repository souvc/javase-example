package com.souvc.util.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsTest {

    public static void main(String[] args) {

        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
               new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //group by price
       // Map<BigDecimal, List<Item>> groupByPriceMap =
                //items.stream().collect(Collectors.groupingBy(Item::getPrice));

        Map<String, List<Item>> collect = items.stream().collect(Collectors.groupingBy(i -> i.getName() + i.getPrice()));
        System.out.println(collect);

        //System.out.println("根据价格分组为："+groupByPriceMap);

        // group by price, uses 'mapping' to convert List<item> to Set<string>
        /*Map<BigDecimal, Set<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet()))
                );

        System.out.println(""+result);*/
    }
}
