package ru.kogut.enterprise.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.kogut.enterprise.ws.products.*;
import ru.kogut.enterprise.ws.repository.ProductRepositoryWS;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://kogut.ru/ws/products";

    private ProductRepositoryWS productRepository;

    @Autowired
    public ProductEndpoint(ProductRepositoryWS productRepository) {
        this.productRepository = productRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveProductRequest")
    @ResponsePayload
    public GetAnswerResponse saveProduct(@RequestPayload final SaveProductRequest request) {
        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setDiscription(request.getDiscription());
        product.setDelete(request.getDelete());
        return productRepository.saveProduct(product);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductRequest")
    @ResponsePayload
    public GetAnswerResponse updateProduct(@RequestPayload final UpdateProductRequest request) {
        return productRepository.updateProduct(request.getProduct());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductResponse getProductById(@RequestPayload final GetProductByIdRequest request) {
        GetProductResponse response = new GetProductResponse();
        Product product = productRepository.getProductById(request.getId());
        if (product == null){
            response.setStatus("Product not found");
        }else{
            response.setProduct(product);
            response.setStatus("200");
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsResponse")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts() {
        return productRepository.getAllProducts();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductRequest")
    @ResponsePayload
    public GetAnswerResponse deleteProduct(@RequestPayload final DeleteProductRequest request) {
        return productRepository.deleteProduct(request.getProduct());
    }
}
