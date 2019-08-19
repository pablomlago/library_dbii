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
public class GestionPrestamos {
    
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionPrestamos(FachadaGui fgui, FachadaBaseDatos fbd)
    {
        this.fgui=fgui;
        this.fbd=fbd;
    }
    
    public void abrirMenuPrestamo(gui.VLibro vl, Integer idLibro, Integer numEjemplar)
    {
        fgui.abrirMenuPrestamo(vl, idLibro, numEjemplar);
    }
    
    public java.util.List<Usuario> obtenerUsuariosPrestamos(String id, String nombre)
    {
        return fbd.obtenerUsuariosPrestamos(id, nombre);
    }
    //Novas funcions
    
    public Boolean prestarEjemplar(String idUsuario, Integer idLibro, Integer numEjemplar)
    {
        int resultado = fbd.prestarEjemplar(idUsuario, idLibro, numEjemplar);
        
        return resultado != 0;
    }
    
    public Boolean devolverEjemplar(Integer idLibro, Integer numEjemplar)
    {
        int resultado = fbd.devolverEjemplar(idLibro, numEjemplar);
        
        return resultado != 0;
    }
}
