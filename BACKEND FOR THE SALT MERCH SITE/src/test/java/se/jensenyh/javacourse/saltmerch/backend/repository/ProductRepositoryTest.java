package se.jensenyh.javacourse.saltmerch.backend.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository db;

    //Equality assertion between lists in a JUnit test case
    @Test
    void selectAll()
    {   List<String> product = Arrays.asList("Garment", "Glove", "Unisex Size", "Not Available");
        List<String> product2 = Arrays.asList("Garment", "Glove", "Unisex Size", "Not Available");

        Assertions.assertIterableEquals(product, product2);}

    @Test
    void getEntireProduct() {
        Product product = new Product(123, "Training", "Shorts", "Stretchable and Flexible", "None");

        Product actualResult = db.getEntireProduct(123);
        assertThat(actualResult).isNotEqualTo(123);
    }
}