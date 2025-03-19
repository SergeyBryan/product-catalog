package org.sbryan.products_catalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sbryan.products_catalog.codegen.types.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductsCatalogApplicationTests {


    @Autowired
    private WebApplicationContext context;

    private HttpGraphQlTester httpGraphQlTester;


    @BeforeEach
    public void setUp() {
        WebTestClient client = MockMvcWebTestClient.bindToApplicationContext(context)
                .configureClient()
                .baseUrl("/graphql")
                .build();

        this.httpGraphQlTester = HttpGraphQlTester.create(client);
    }

    @Test
    @Sql(scripts = {"classpath:/scripts/init.sql"})
    @DisplayName(value = "Test find all products")
    void shouldGetAllProductsOk() {
        var query = """
                query {
                    findAllProducts {
                        productId
                        name
                        description
                        modelCode
                    }
                }
                """;
        var res = httpGraphQlTester.document(query)
                .execute()
                .path("data.findAllProducts")
                .entityList(Product.class)
                .hasSizeGreaterThan(0);
        res.satisfies(p ->
        {
            assertThat(p).isNotEmpty();
            assertThat(p.getFirst().getName()).isEqualTo("test");
        });
    }

    @Test
    @Sql(scripts = {"classpath:/scripts/init.sql"})
    @DisplayName(value = "Test create a new product")
    void shouldCreateProductOk() {
        var query = """
                mutation {
                    createProduct(product: {
                        description: "test"
                        name: "tennis shoes w 100 36"
                        modelCode: "1"
                    }){
                        productId
                        name
                        description
                        modelCode
                    }
                }
                """;
        var res = httpGraphQlTester.document(query)
                .execute()
                .path("data.createProduct")
                .entity(Product.class)
                .get();
        assertThat(res.getName()).isEqualTo("TENNIS SHOES W 100 36");
        assertThat(res.getDescription()).isEqualTo("test");
        assertThat(res.getModelCode()).isEqualTo("1");
    }


}
