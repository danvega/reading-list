package dev.danvega.readinglist.controller;

import dev.danvega.readinglist.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Testcontainers
@ActiveProfiles("test")
class BookControllerIntTest {

    @Autowired
    TestRestTemplate restTemplate;

//    @Container
//    private static PostgreSQLContainer psql = new PostgreSQLContainer("postgres:alpine");
//
//    @DynamicPropertySource
//    static void configure(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url",psql::getJdbcUrl);
//        registry.add("spring.datasource.username",psql::getUsername);
//        registry.add("spring.datasource.password",psql::getPassword);
//    }
//
//    @Container
//    private static GenericContainer db = new GenericContainer<>(DockerImageName.parse("postgres:alpine"))
//            .withExposedPorts(5432)
//            .withEnv("POSTGRES_PASSWORD","password")
//            .withEnv("POSTGRES_DB","reading_list");

//    @DynamicPropertySource
//    static void configure(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url",() -> {
//            return "jdbc:postgresql://localhost:" + db.getMappedPort(5432) + "/reading_list";
//        });
//    }

    @Test
    void contextLoads() throws InterruptedException {
        assertNotNull(restTemplate);
    }

    @Test
    void findAllBooks() throws Exception {
        ResponseEntity<List<Book>> books = restTemplate.exchange("/api/books", HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {});
        assertEquals(HttpStatus.OK,books.getStatusCode());
        assertEquals(3,books.getBody().size());
    }

}