package edu.bionic.presentation.controller;

import edu.bionic.domain.Order;
import edu.bionic.service.CommentService;
import edu.bionic.service.OrderService;
import edu.bionic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("products")
@SessionAttributes("currentOrder")
public class ProductController {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm");

    private ProductService productService;
    private CommentService commentService;
    private OrderService orderService;

    @Autowired
    public ProductController(ProductService productService, CommentService commentService, OrderService orderService) {
        this.productService = productService;
        this.commentService = commentService;
        this.orderService = orderService;
    }

    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute("products",  productService.getAll());
        return "product/product-list";
    }

    @GetMapping("{productId}")
    public String showProduct(Model model, @PathVariable("productId") Integer productId) {
        model.addAttribute(productService.getById(productId));
        model.addAttribute("comments", commentService.getByProduct(productId));
        model.addAttribute("dateTimeFormatter", dateTimeFormatter);

        return "product/product";
    }

    @PostMapping("{productId}/addToBasket")
    public String addToBasket(@PathVariable("productId") Integer productId,
                              @SessionAttribute("currentOrder") Order currentOrder) {

        orderService.addProductToOrder(currentOrder, productId);

        return "redirect:/products/" + productId;
    }
}
