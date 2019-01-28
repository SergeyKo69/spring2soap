package ru.kogut.enterprise.ws.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kogut.enterprise.services.ProductService;
import ru.kogut.enterprise.ws.products.GetAllProductsResponse;
import ru.kogut.enterprise.ws.products.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryWS {

    @Autowired
    private ProductService productService;


    public GetAnswerResponse saveProduct(Product product) {
        try {
            ru.kogut.enterprise.models.Product productDb =
                    convertProductXmlToProductDb(product);
            productService.saveProduct(productDb);
            return new GetAnswerResponse("OK", productDb.getId());
        }catch (Exception e){
            return new GetAnswerResponse("ERROR");
        }
     }

    public Product getProductById(String id) {
        return convertProductDbToProductXml(productService.getProductById(id));
    }

    public GetAllProductsResponse getAllProducts() {
        List<ru.kogut.enterprise.models.Product> listProductDb =
                productService.getAllProducts();
        GetAllProductsResponse getAllProductsResponse = new GetAllProductsResponse();
        List<Product> listProductXml = new ArrayList<>();
        for (int i = 0; i < listProductDb.size(); i++) {
            listProductXml.add(convertProductDbToProductXml(listProductDb.get(i)));
        }
        getAllProductsResponse.setProductList(listProductXml);
        return getAllProductsResponse;
    }

    public GetAnswerResponse updateProduct(Product product) {
        return saveProduct(product);
    }

    public GetAnswerResponse deleteProduct(Product product) {
        try {
            productService.deleteProduct(convertProductXmlToProductDb(product));
            return new GetAnswerResponse("OK");
        }catch (Exception e){
            return new GetAnswerResponse("ERROR");
        }
    }

    public ru.kogut.enterprise.models.Product convertProductXmlToProductDb(Product product){
        ru.kogut.enterprise.models.Product productDb = new ru.kogut.enterprise.models.Product();
        if (product.getId() != null){
            productDb.setId(product.getId());
        }
        productDb.setTitle(product.getTitle());
        productDb.setDiscription(product.getDiscription());
        productDb.setDelete(product.getDelete());
        return productDb;
    }

    public Product convertProductDbToProductXml(ru.kogut.enterprise.models.Product product){
        Product productXml = new Product();
        productXml.setId(product.getId());
        productXml.setTitle(product.getTitle());
        productXml.setDiscription(product.getDiscription());
        productXml.setDelete(product.getDelete());
        return productXml;
    }
}
