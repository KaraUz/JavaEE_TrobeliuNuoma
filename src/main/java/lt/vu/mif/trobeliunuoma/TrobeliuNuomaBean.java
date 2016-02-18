/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.trobeliunuoma;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Karolis
 */
@Named
@Stateless
public class TrobeliuNuomaBean {
    public String hello(){
        return "Labas vakaras";
    }
}
