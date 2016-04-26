package org.myproject.store.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by Gavrilov_IS on 24.04.2016.
 */

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {
    private static final long serialVersionUID = -5527548628004479242L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRODUCER")
    private String producer;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getProducer(){
        return this.producer;
    }

    public void setProducer(String producer){
        this.producer = producer;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (producer != null ? !producer.equals(that.producer) : that.producer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }

}
