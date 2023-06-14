package be.ehb.derdehands.controller;

import be.ehb.derdehands.dao.ProductDAO;
import be.ehb.derdehands.dao.UserDAO;
import be.ehb.derdehands.entities.Product;
import be.ehb.derdehands.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private ProductDAO mProductDAO;
    private UserDAO mUserDAO;

    @Autowired
    public ProductController(ProductDAO mProductDAO, UserDAO mUserDAO){
        this.mProductDAO = mProductDAO;
        this.mUserDAO = mUserDAO;
    }

    @ModelAttribute("products")
    public Iterable<Product> getAllProducts(){
        return mProductDAO.findAll();
    }

    @GetMapping({"/", "/index"})
    public String showIndex(){
        return "index";
    }

    @GetMapping("/about")
    public String showAbout(){
        return "about";
    }

    @ModelAttribute("saveProduct")
    private Product productForForm(){
        return new Product();
    }

    @GetMapping({"/newUser"})
    public String newUser(ModelMap modelMap){
        return "newUser";
    }

    @PostMapping("/newUser")
    public String addUser(@Valid @ModelAttribute("addingUser")
                          User user, BindingResult result){
        if (result.hasErrors()){
            return "/newUser";
        }
        mUserDAO.save(user);
        return "redirect:/index";
    }

    @GetMapping({"/newProduct"})
    public String showNewProduct(ModelMap modelMap){
        return "newProduct";
    }

    @PostMapping("/newProduct")
    public String addProduct(@Valid @ModelAttribute("addingProduct")
                                 Product product, BindingResult result){
        if (result.hasErrors()){
            return "/newProduct";
        }
        mProductDAO.save(product);
        return "redirect:/index";
    }
}
