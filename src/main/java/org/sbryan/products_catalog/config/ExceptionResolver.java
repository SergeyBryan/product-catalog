package org.sbryan.products_catalog.config;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * A component responsible for resolving exceptions that occur during GraphQL data fetching.
 * <p>
 * This class implements {@link DataFetcherExceptionResolver} to handle exceptions globally
 * and convert them into GraphQL errors. It logs the exception and returns a {@link GraphQLError}
 * with the exception message.
 */
@Slf4j
@Component
public class ExceptionResolver implements DataFetcherExceptionResolver {


    /**
     * Resolves a thrown exception into a list of {@link GraphQLError} objects.
     * <p>
     * This method logs the exception and constructs a {@link GraphQLError} with the exception's message.
     *
     * @param exception   the exception that was thrown during data fetching.
     * @param environment the context in which the exception occurred.
     * @return a {@link Mono} containing a list of {@link GraphQLError} objects.
     */
    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable exception, DataFetchingEnvironment environment) {
        GraphQLError error = GraphQLError.newError().message(exception.getMessage()).build();
        log.error("SERVER EXCEPTION: {}", exception.getMessage());
        return Mono.just(List.of(error));
    }
}
