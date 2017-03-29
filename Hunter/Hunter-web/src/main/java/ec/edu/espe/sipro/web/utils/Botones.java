/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.sipro.web.utils;

/**
 *
 * @author esteb
 */
public class Botones 
{
    private Integer codigo;
    private String name;

    public Botones() {
    }

    public Botones(Integer codigo, String name) {
        this.codigo = codigo;
        this.name = name;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
