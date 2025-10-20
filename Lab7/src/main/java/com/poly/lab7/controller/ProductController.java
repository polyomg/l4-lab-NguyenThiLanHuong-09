package com.poly.lab7.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.lab7.entity.Product;
import com.poly.lab7.entity.Report; // Hoặc .dto.Report
import com.poly.lab7.repository.ProductDAO;

//Link: Bài 1 & 4 (Tìm kiếm theo giá): http://localhost:8080/product/search
//Link: Bài 2 & 5 (Tìm kiếm và phân trang): http://localhost:8080/product/search-and-page
//Link: Bài 3 (Báo cáo tổng hợp): http://localhost:8080/report/inventory-by-category

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;


    @RequestMapping("/product/search")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {


        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);

        List<Product> items = dao.findByPrice(minPrice, maxPrice);


        model.addAttribute("items", items);


        model.addAttribute("min", min.orElse(null));
        model.addAttribute("max", max.orElse(null));

        return "product/search";
    }


    @RequestMapping("/product/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {

        String kwords = kw.orElse("");


        Pageable pageable = PageRequest.of(p.orElse(0), 5);


        String searchKeywords = "%" + kwords + "%";


        Page<Product> page = dao.findByKeywords(searchKeywords, pageable);


        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);
        return "product/search-and-page";
    }


    @RequestMapping("/report/inventory-by-category")
    public String inventory(Model model) {
        List<Report> items = dao.getInventoryByCategory();
        model.addAttribute("items", items);
        return "report/inventory-by-category";
    }
}
