package TP3;

public class ProductService {
    private ProductApiClient apiClient;

    public ProductService(ProductApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public String getProduct(String productId) throws Exception {
        // Appel à l'API pour récupérer les données du produit
        return apiClient.getProduct(productId);
    }
}

