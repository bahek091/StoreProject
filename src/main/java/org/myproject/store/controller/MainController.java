package org.myproject.store.controller;

import org.apache.log4j.Logger;
import org.myproject.store.domain.Product;
import org.myproject.store.domain.ResultTable;
import org.myproject.store.domain.Shop;
import org.myproject.store.service.storeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/main")
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    /**
     * Handles and retrieves all shops or product and show it in a JSP page
     * @return the name of the JSP page
     */

    @Resource(name="storeService")
    private storeService storeService;



    @RequestMapping(value = "/shops", method = RequestMethod.GET)
    public String getShops(Model model) {

        List<Shop> shopList = storeService.getAllShops();
        model.addAttribute("shops", shopList);

        return "shopspage";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(Model model) {

        List<Product> productList = storeService.getAllProducts();
        model.addAttribute("products", productList);

        return "productspage";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<ResultTable> resultList = storeService.getAll();
        model.addAttribute("all", resultList);

        return "allpage";
    }





}