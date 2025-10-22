package sum25vietnxse184785.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25vietnxse184785.pojo.SonyCategorie;
import sum25vietnxse184785.repository.SonyCategoriesRepository;

import java.util.List;

@Service
public class SonyCategoryServiceImpl implements SonyCategoryService {

    @Autowired
    private SonyCategoriesRepository categoriesRepository;

    @Override
    public List<SonyCategorie> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public SonyCategorie getCategoryById(Integer id) {
        return categoriesRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCategory(SonyCategorie category) {
        categoriesRepository.save(category);
    }

    @Override
    public void createCategory(SonyCategorie category) {
        categoriesRepository.save(category);
    }
    @Override
    public SonyCategorie findById(Integer id) {
        return categoriesRepository.findById(id).orElse(null);
    }
}
