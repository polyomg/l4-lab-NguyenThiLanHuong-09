package poly.edu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import poly.edu.entity.Product;

import java.util.Arrays;
import java.util.List;

@Controller

public class ProductController {

    //Link: http://localhost:8080/product/form

    @GetMapping("/product/form")
    public String form(Model model) {
        Product p1 = new Product();
        p1.setName("iPhone 30");
        p1.setPrice(5000.0);
        model.addAttribute("product1", p1);

        Product p2 = new Product();
        model.addAttribute("product2", p2);

        return "Lab2/bai34";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product2") Product p, Model model) {
        Product p1 = new Product();
        p1.setName("iPhone 30");
        p1.setPrice(5000.0);
        model.addAttribute("product1", p1);

        model.addAttribute("product2", p);
        return "Lab2/bai34";
    }

    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(new Product("A", 1.0), new Product("B", 12.0));
    }
}
