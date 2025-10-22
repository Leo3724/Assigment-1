package sum25vietnxse184785.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sum25vietnxse184785.pojo.SonyAccount;
import sum25vietnxse184785.pojo.SonyProduct;
import sum25vietnxse184785.service.SonyCategoryService;
import sum25vietnxse184785.service.SonyProductService;

import java.time.LocalDate;

@Controller
@RequestMapping("/products")
public class SonyProductController {

    @Autowired
    private SonyProductService productService;

    @Autowired
    private SonyCategoryService categoryService;

    @GetMapping
    public String listProducts(HttpSession session, Model model) {
        SonyAccount user = (SonyAccount) session.getAttribute("loggedUser");
        if (user == null || (user.getRoleID() != 1 && user.getRoleID() != 2)) {
            return "redirect:/login";
        }

        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("role", user.getRoleID());
        model.addAttribute("loggedUser", user);
        return "products"; //
    }

    @GetMapping("/add")
    public String addForm(HttpSession session, Model model) {
        SonyAccount user = (SonyAccount) session.getAttribute("loggedUser");
        if (user == null || user.getRoleID() != 1) {
            return "redirect:/products";
        }
        model.addAttribute("product", new SonyProduct());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "add";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute("product") SonyProduct product, Model model) {
        if (!isValidProduct(product, model)) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "add";
        }
        product.setCreatedAt(LocalDate.now());
        productService.saveProduct(product);
        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, HttpSession session, Model model) {
        SonyAccount user = (SonyAccount) session.getAttribute("loggedUser");
        if (user == null || user.getRoleID() != 1) {
            return "redirect:/products";
        }
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") SonyProduct product,
                                @RequestParam("cateID") Integer cateID,
                                Model model) {
        if (!isValidProduct(product, model)) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "edit";
        }

        product.setCategory(categoryService.getCategoryById(cateID));
        product.setCreatedAt(LocalDate.now());

        productService.saveProduct(product);
        return "redirect:/products";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, HttpSession session) {
        SonyAccount user = (SonyAccount) session.getAttribute("loggedUser");
        if (user == null || user.getRoleID() != 1) {
            return "redirect:/products";
        }
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    private boolean isValidProduct(SonyProduct product, Model model) {
        if (product.getProductName() == null || product.getProductName().length() < 5 || product.getProductName().length() > 50) {
            model.addAttribute("error", "Product Name must be between 5 and 50 characters");
            return false;
        }
        if (product.getPrice() == null || product.getPrice() <= 100) {
            model.addAttribute("error", "Price should be greater than or equal to 100 ");
            return false;
        }
        if (product.getStock() <=0 || product.getStock() >= 1000) {
            model.addAttribute("error", "Stock should be between 0 and 1000 ");
            return false;
        }
        return true;
    }
}
