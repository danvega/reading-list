package dev.danvega.readinglist.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@Testcontainers
@ActiveProfiles("test")
class BookControllerIntTest {

    @Container
//    private static PostgreSQLContainer psql = new PostgreSQLContainer("postgres:alpine");
//
//    @DynamicPropertySource
//    static void configure(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url",psql::getJdbcUrl);
//        registry.add("spring.datasource.username",psql::getUsername);
//        registry.add("spring.datasource.password",psql::getPassword);
//    }

//    @Container
//    private static GenericContainer db = new GenericContainer<>(DockerImageName.parse("postgres:alpine"))
//            .withExposedPorts(5432)
//            .withEnv("POSTGRES_PASSWORD","password")
//            .withEnv("POSTGRES_DB","reading_list");
//
//    @BeforeAll
//    static void beforeAll() {
//        System.out.println(db.getMappedPort(5432));
//        db.start();
//    }

//    @DynamicPropertySource
//    static void configure(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url",() -> {
//            return "jdbc:postgresql://localhost:" + db.getMappedPort(5432) + "/reading_list";
//        });
//    }

    @Autowired
    MockMvc mvc;

    @Test
    void contextLoads() throws InterruptedException {
        assertNotNull(mvc);
    }

    @Test
    void findAllBooks() throws Exception {
        mvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(3)));

    }

}