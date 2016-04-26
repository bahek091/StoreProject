package org.myproject.store.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Gavrilov_IS on 26.04.2016.
 */
@Entity
public class ResultTable {
    private String shop;
    private String address;
    private String product;
    private String producer;
@Id
    public String getShop() {
        return shop;
    }
    public void setShop(String shop){
        this.shop = shop;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getProduct(){
        return product;
    }
    public void setProduct(String product){
        this.product = product;
    }

    public String getProducer(){
        return producer;
    }
    public void setProducer(String producer){
        this.producer = producer;
    }
}
