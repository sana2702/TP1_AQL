package TP3.tests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import TP3.* ;
public class ProductServiceTest {

    @Test
    public void testGetProductSuccess() throws Exception {
        // Création d'un mock de ProductApiClient
        ProductApiClient apiClientMock = mock(ProductApiClient.class);

        // Simuler un retour d'un produit en cas de succès
        when(apiClientMock.getProduct("123")).thenReturn("Product 123 details");

        // Création de ProductService en injectant le mock
        ProductService productService = new ProductService(apiClientMock);

        // Appel de la méthode getProduct
        String result = productService.getProduct("123");

        // Vérifier que le résultat est celui attendu
        assertEquals("Product 123 details", result);

        // Vérification que getProduct a été appelé avec le bon argument
        verify(apiClientMock).getProduct("123");
    }

    @Test
    public void testGetProductDataFormatError() throws Exception {
        // Création d'un mock de ProductApiClient
        ProductApiClient apiClientMock = mock(ProductApiClient.class);

        // Simuler une exception liée à un format de données incompatible
        when(apiClientMock.getProduct("123")).thenThrow(new IllegalArgumentException("Incompatible data format"));

        // Création de ProductService en injectant le mock
        ProductService productService = new ProductService(apiClientMock);

        // Vérifier que l'exception est levée pour le mauvais format de données
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productService.getProduct("123");
        });

        // Vérifier le message de l'exception
        assertEquals("Incompatible data format", exception.getMessage());

        // Vérification que getProduct a été appelé avec le bon argument
        verify(apiClientMock).getProduct("123");
    }

    @Test
    public void testGetProductApiFailure() throws Exception {
        // Création d'un mock de ProductApiClient
        ProductApiClient apiClientMock = mock(ProductApiClient.class);

        // Simuler une exception d'appel API (par exemple, un problème réseau)
        when(apiClientMock.getProduct("123")).thenThrow(new RuntimeException("API call failed"));

        // Création de ProductService en injectant le mock
        ProductService productService = new ProductService(apiClientMock);

        // Vérifier que l'exception d'appel API est levée
        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.getProduct("123");
        });

        // Vérifier le message de l'exception
        assertEquals("API call failed", exception.getMessage());

        // Vérification que getProduct a été appelé avec le bon argument
        verify(apiClientMock).getProduct("123");
    }
}

