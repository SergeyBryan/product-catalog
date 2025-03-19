//package org.sbryan.products_catalog.config;
//
//import graphql.schema.Coercing;
//import graphql.schema.GraphQLScalarType;
//import graphql.schema.idl.RuntimeWiring;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Component
//@Configuration
//public class ScalarConfig {
//
//    @Bean
//    public RuntimeWiring.Builder runtimeWiringBuilder(GraphQLScalarType localDateTimeScalar) {
//        return RuntimeWiring.newRuntimeWiring()
//                .scalar(GraphQLScalarType.newScalar().name("LocalDateTime").coercing(new Coercing<LocalDateTime, Object>() {
//                    @Override
//                    public String serialize(Object input) {
//                        if (input instanceof LocalDateTime) {
//                            return ((LocalDateTime) input).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//                        }
//                        throw new IllegalArgumentException("Expected a LocalDateTime object.");
//                    }
//
//                    @Override
//                    public LocalDateTime parseValue(Object input) {
//                        if (input instanceof String) {
//                            return LocalDateTime.parse((String) input, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//                        }
//                        throw new IllegalArgumentException("Expected a String.");
//                    }
//
//                    @Override
//                    public LocalDateTime parseLiteral(Object input) {
//                        if (input instanceof String) {
//                            return LocalDateTime.parse((String) input, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//                        }
//                        throw new IllegalArgumentException("Expected a String.");
//                    }
//                }).build()); // Регистрируем кастомный скаляр
//    }
//
//    @Bean
//    public GraphQLScalarType localDateTimeScalar() {
//        return GraphQLScalarType.newScalar()
//                .name("LocalDateTime")
//                .description("LocalDateTime scalar")
//                .coercing(new Coercing<LocalDateTime, String>() {
//                    @Override
//                    public String serialize(Object input) {
//                        if (input instanceof LocalDateTime) {
//                            return ((LocalDateTime) input).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//                        }
//                        throw new IllegalArgumentException("Expected a LocalDateTime object.");
//                    }
//
//                    @Override
//                    public LocalDateTime parseValue(Object input) {
//                        if (input instanceof String) {
//                            return LocalDateTime.parse((String) input, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//                        }
//                        throw new IllegalArgumentException("Expected a String.");
//                    }
//
//                    @Override
//                    public LocalDateTime parseLiteral(Object input) {
//                        if (input instanceof String) {
//                            return LocalDateTime.parse((String) input, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//                        }
//                        throw new IllegalArgumentException("Expected a String.");
//                    }
//                })
//                .build();
//    }
//}
