package sum25vietnxse184785;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sum25vietnxse184785.pojo.SonyAccount;
import sum25vietnxse184785.pojo.SonyCategorie;
import sum25vietnxse184785.pojo.SonyProduct;
import sum25vietnxse184785.service.SonyAccountService;
import sum25vietnxse184785.service.SonyCategoryService;
import sum25vietnxse184785.service.SonyProductService;

import java.time.LocalDate;

@SpringBootApplication
@ComponentScan({"sum25vietnxse184785.controller", "sum25vietnxse184785.service"})
@EnableJpaRepositories(basePackages = "sum25vietnxse184785.repository")
@EntityScan(basePackages = "sum25vietnxse184785.pojo")
public class Fa25Se184785Application implements CommandLineRunner {

    @Autowired
    private SonyAccountService accountService;

    @Autowired
    private SonyCategoryService categoryService;

    @Autowired
    private SonyProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(Fa25Se184785Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (accountService.getAllAccounts().isEmpty()) {
            SonyAccount acc1 = new SonyAccount("0905111111", "@1", 1);
            SonyAccount acc2 = new SonyAccount("0905222222", "@1", 2);
            SonyAccount acc3 = new SonyAccount("0905333333", "@1", 3);

            accountService.createAccount(acc1);
            accountService.createAccount(acc2);
            accountService.createAccount(acc3);

            System.out.println("Accounts inserted successfully.");
        } else {
            System.out.println("ℹ Accounts already exist.");
        }

        if (categoryService.getAllCategories().isEmpty()) {
            SonyCategorie c1 = new SonyCategorie(1, "HeadPhone", "active");
            SonyCategorie c2 = new SonyCategorie(2, "Cameras", "active");
            SonyCategorie c3 = new SonyCategorie(3, "TVs", "active");

            categoryService.createCategory(c1);
            categoryService.createCategory(c2);
            categoryService.createCategory(c3);

            System.out.println("Categories inserted successfully.");
        } else {
            System.out.println("ℹ Categories already exist.");
        }

        if (productService.getAllProducts().isEmpty()) {
            SonyCategorie c1 = categoryService.findById(1);
            SonyCategorie c2 = categoryService.findById(2);
            SonyCategorie c3 = categoryService.findById(3);

            SonyProduct p1 = new SonyProduct(1, "Alpha 1 II - Full-frame Mirrorless", 6000, 3, LocalDate.of(2025, 3, 3), c2);
            SonyProduct p2 = new SonyProduct(2, "Alpha 7C II – Full-frame", 2000, 5, LocalDate.of(2025, 4, 4), c2);
            SonyProduct p3 = new SonyProduct(3, "BRAVIA 8 OLED 4K HDR TV", 2500, 10, LocalDate.of(2025, 1, 1), c3);
            SonyProduct p4 = new SonyProduct(4, "LinkBuds Fit Truly Wireless Noise Canceling", 180, 15, LocalDate.of(2025, 3, 3), c1);

            productService.createProduct(p1);
            productService.createProduct(p2);
            productService.createProduct(p3);
            productService.createProduct(p4);

            System.out.println("Products inserted successfully.");
        } else {
            System.out.println("ℹ Products already exist.");
        }
    }
}
