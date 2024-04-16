package org.example.exo3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    void getProduct() {
        // Créer un mock ProductApiClient
        ProductApiClient productApiClient = Mockito.mock(ProductApiClient.class);

        // Créer un ProductService avec le mock ProductApiClient
        ProductService productService = new ProductService(productApiClient);

        // Définir le comportement du mock pour simuler le retour d'un produit
        Product product = new Product("23", "Armani Aqua di Gio", 600.0);
        Mockito.when(productApiClient.getProduct("23")).thenReturn(product);

        // Appeler la méthode getProduct de ProductService
        Product ResultProduct = productService.getProduct("23");

        // Vérifier que la méthode getProduct du mock ProductApiClient a été appelée avec le bon argument
        Mockito.verify(productApiClient).getProduct("23");

        // Vérifier que le produit retourné par ProductService est le même que celui retourné par le mock ProductApiClient
        assertEquals(product, ResultProduct);
    }
}