package sum25vietnxse184785.service;

import sum25vietnxse184785.pojo.SonyProduct;
import java.util.List;

public interface SonyProductService {
    List<SonyProduct> getAllProducts();
    SonyProduct getProductById(Integer id);
    void saveProduct(SonyProduct product);
    void deleteProduct(Integer id);
    void createProduct(SonyProduct product);
}