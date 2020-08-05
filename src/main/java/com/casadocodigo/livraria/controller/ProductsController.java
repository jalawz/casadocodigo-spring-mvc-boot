package com.casadocodigo.livraria.controller;

import com.casadocodigo.livraria.models.BookType;
import com.casadocodigo.livraria.models.Product;
import com.casadocodigo.livraria.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/products/list");
        modelAndView.addObject("products", productsRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("products/form");
        modelAndView.addObject("types", BookType.values());
        return modelAndView;
    }

    @PostMapping
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productsRepository.save(product);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        return "redirect:produtos";
    }
}
