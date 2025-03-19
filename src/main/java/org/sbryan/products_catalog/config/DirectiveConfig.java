package org.sbryan.products_catalog.config;

import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link SchemaDirectiveWiring} that adds string length validation
 * to GraphQL fields using a custom directive.
 * <p>
 * The directive must be applied to a GraphQL field and should include three arguments:
 * <ul>
 *   <li>{@code min} - the minimum allowed length of the string (type {@code int}).</li>
 *   <li>{@code max} - the maximum allowed length of the string (type {@code int}).</li>
 *   <li>{@code message} - the error message to be thrown if validation fails (type {@code String}).</li>
 * </ul>
 * <p>
 * Example of using the directive in a GraphQL schema:
 * <pre>
 * type Query {
 *   user: User
 * }
 *
 * type User {
 *   name: String @length(min: 3, max: 10, message: "Name must be between 3 and 10 characters")
 * }
 * </pre>
 * <p>
 * If the field value does not meet the length constraints, an {@link IllegalArgumentException}
 * will be thrown with the specified error message.
 */
@Component
public class DirectiveConfig implements SchemaDirectiveWiring {


    /**
     * Method called to process a GraphQL field with the applied directive.
     * <p>
     * This method adds string length validation to the field using the directive's arguments.
     *
     * @param environment the context containing information about the field and the applied directive.
     * @return the modified GraphQL field with added validation.
     * @throws IllegalArgumentException if the field value does not meet the length constraints.
     */
    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> environment) {
        GraphQLFieldDefinition field = environment.getElement();
        int min = environment.getAppliedDirective().getArgument("min").getValue();
        int max = environment.getAppliedDirective().getArgument("max").getValue();
        String message = environment.getAppliedDirective().getArgument("message").getValue();

        return field.transform(builder -> builder.dataFetcher(env -> {
            Object value = env.getArgument(field.getName());
            if (value instanceof String strValue) {
                if (strValue.length() < min || strValue.length() > max) {
                    throw new IllegalArgumentException(message);
                }
            }
            return env.getSource();
        }));
    }

}
