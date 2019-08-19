/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author alumnogreibd
 */
public class GestionCategorias {
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionCategorias(FachadaGui fgui, FachadaBaseDatos fbd)
    {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    //O mellor haberia que cambiar este nome
    public void abrirMenuCategoria()
    {
        java.util.List<String> nomesCategorias = new java.util.ArrayList<String>();
        
        for(Categoria c : fbd.consultarCategorias())
        {
            nomesCategorias.add(c.getNombre());
        }
        
        fgui.abrirMenuCategoria(nomesCategorias);
    }
    
    public Categoria obterCategoria(String nomeCategoria)
    {
        return fbd.obterCategoria(nomeCategoria);
    }
    
    public Boolean borrarCategoria(String nomeCategoria)
    {
        int resultado = fbd.borrarCategoria(nomeCategoria);
        
        return resultado != 0;
    }
    
    public java.util.List<String> actualizarCategorias()
    {
        java.util.List<String> nomesCategorias = new java.util.ArrayList<String>();
        
        for(Categoria c : fbd.consultarCategorias())
        {
            nomesCategorias.add(c.getNombre());
        }
        
        return nomesCategorias;
    }
    
    public Boolean gardarCategoria(String nomeCategoria, String descripcionCategoria)
    {
        int resultado = fbd.gardarCategoria(nomeCategoria, descripcionCategoria);
        return resultado != 0;
    }
}
