/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.trobeliunuoma;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Karolis
 */
@Named
@Stateful
@SessionScoped
public class TrobeliuNuomaBean {
    private int number;
    
    @PostConstruct
    public void init() {
        number = 1;
    }
    
    public String hello(){
        return "Labas vakaras";
    }
    
    public void add(){
        number++;
    }
    
    public int getNumber(){
        return number;
    }
}
