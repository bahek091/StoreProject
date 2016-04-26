package org.myproject.store.service;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.store.domain.Product;
import org.myproject.store.domain.ResultTable;
import org.myproject.store.domain.Shop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service for processing Persons
 * Сервис для класса Person
 */
@Service("storeService")
@Transactional
public class storeService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retrieves all shops
     * @return a list of shops
     */
    public List<Shop> getAllShops(){
        logger.debug("Retrieving all persons");

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Shop");

        return query.list();
    }

    /**
     * Retrieves single shops by ID
     * @return one shops
     */
    public Shop getShopById(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Shop shop = (Shop)session.get(Shop.class, id);

        return shop;
    }

    /**
     * Retrieves all products
     * @return a list of products
     */
    public List<Product> getAllProducts(){
        logger.debug("Retrieving all persons");

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Product");

        return query.list();
    }

    /**
     * Retrieves result table Shop JOIN Product
     * @return a list of ResultTable objects
     */
    public List getAll(){
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("SELECT shops.name as SHOP, shops.address AS ADDRESS, pr.name AS PRODUCT, pr.producer AS PRODUCER FROM shops " +
                "INNER JOIN shop_product s2p ON (s2p.shop_id = shops.id) " +
                "INNER JOIN products pr ON (pr.id = s2p.product_id)").addEntity(ResultTable.class);
        return query.list();
    }

    /**
     * Retrieves one product by ID
     * @return one product
     */
    public Product getProductById(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product)session.get(Product.class, id);

        return product;
    }






}
