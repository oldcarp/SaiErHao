package com.example.saierhao.converter;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author
 * @date 2023年06月28日 16:25
 */
public class Converter {
    public static void main(String[] args) throws Exception {
        List<IConverter> converters = Lists.newArrayList(new BigDecimalConverter(), new NumberConverter());
        List<String> result = Stream.of(1, BigDecimal.TEN).map(it -> {
            for (IConverter converter : converters) {
                try {
                    return converter.convert(it);
                } catch (Exception ignored) {
                }
            }
            return "null";
        }).collect(Collectors.toList());
        System.out.println(result);
    }

    private static class BigDecimalConverter implements IConverter {

        @Override
        public String convert(Object obj) {
            return ((BigDecimal) obj).toPlainString();
        }
    }

    private static class NumberConverter implements IConverter {

        @Override
        public String convert(Object obj) {
            return ((Number) obj).intValue() + "";
        }
    }

    private interface IConverter {
        String convert(Object obj);
    }
}
