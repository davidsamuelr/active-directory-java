/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

/**
 *
 * @author David Samuel
 */
public class ActiveDirectory {

    private String atributos[] = {"displayName", "title", "department", "mail", "l", "statusUser"};

    public String[] getAtributos() {
        return atributos;
    }

    public int getQtdAtributos() {
        return atributos.length;
    }
}
