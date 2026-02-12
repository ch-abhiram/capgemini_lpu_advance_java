package com.product;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDaoTest {

    static ProductDao dao;

    @BeforeAll
    public static void setup() {
        dao = new ProductDao();
    }

    @Test
    @Order(1)
    public void testInsertProduct() {

        Product product = new Product(200, "Mobile", 25000);

        String result = dao.insertProduct(product);

        assertEquals("Data Inserted", result);
    }

    @Test
    @Order(2)
    public void testInsertProductNull() {

        String result = dao.insertProduct(null);

        assertEquals("Invalid Argument", result);
    }

    @Test
    @Order(3)
    public void testFindByIdExists() {

        Product p = dao.findById(200);

        assertNotNull(p);
        assertEquals("Mobile", p.getName());
    }

    @Test
    @Order(4)
    public void testFindByIdNotExists() {

        Product p = dao.findById(9999);

        assertNull(p);
    }

    @Test
    @Order(5)
    public void testClose() {

        dao.close();

        assertTrue(true); // Just to cover close method
    }
}
