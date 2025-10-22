package sum25vietnxse184785.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25vietnxse184785.pojo.SonyProduct;
import sum25vietnxse184785.repository.SonyProductsRepository;

import java.util.List;

@Service
public class SonyProductServiceImpl implements SonyProductService {

    @Autowired
    private SonyProductsRepository productsRepository;

    @Override
    public List<SonyProduct> getAllProducts() {
        List<SonyProduct> list = productsRepository.findAll();
        System.out.println("=== PRODUCTS FOUND: " + list.size() + " ===");
        return list;
    }

    @Override
    public SonyProduct getProductById(Integer id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(SonyProduct product) {
        productsRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productsRepository.deleteById(id);
    }

    @Override
    public void createProduct(SonyProduct product) {
        productsRepository.save(product);
    }
}
