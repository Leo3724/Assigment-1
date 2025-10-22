package sum25vietnxse184785.service;

import sum25vietnxse184785.pojo.SonyCategorie;

import java.util.List;

public interface SonyCategoryService {
    List<SonyCategorie> getAllCategories();
    SonyCategorie getCategoryById(Integer id);
    void saveCategory(SonyCategorie category);
    void createCategory(SonyCategorie category);
    SonyCategorie findById(Integer id);
}
