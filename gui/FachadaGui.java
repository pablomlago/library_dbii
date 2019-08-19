/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Categoria;
import aplicacion.Ejemplar;
import aplicacion.Libro;

/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    
   public FachadaGui(aplicacion.FachadaAplicacion fa){
     this.fa=fa;
     this.vp = new VPrincipal(fa);
   } 
    
    
    
    public void iniciaVista(){
      VAutentificacion va;
    
      va = new VAutentificacion(vp, true, fa);
      vp.setVisible(true);
      va.setVisible(true);
    }
    
   
    public void visualizaLibro(Libro l, java.util.List<String>restoCategorias){
        VLibro vl;
        java.util.List<String> categorias = new java.util.ArrayList<String>();
        
        for(Categoria c:l.getCategorias()){
            categorias.add(c.getNombre());
        }
        
        vl=new VLibro(vp, true, fa, l, categorias, restoCategorias);
        vl.setVisible(true);
    }
    
    public void nuevoLibro(java.util.List<String>  restoCategorias){
        VLibro vl;
        
        vl=new VLibro(vp, true, fa, restoCategorias);
        vl.setVisible(true);
    }
    
    public void muestraExcepcion(String txtExcepcion){
       VAviso va;
       
       va = new VAviso(vp, true, txtExcepcion);
       va.setVisible(true);
    }

    //Novo codigo
    
    public void abrirMenuUsuario()
    {
        VUsuario vu;
        
        vu = new VUsuario(vp, true, fa);
        vp.setVisible(true);
        vu.setVisible(true);
    }
   
    
    public void abrirMenuCategoria(java.util.List<String> nomesCategorias)
    {
        VCategoria vc;
        
        vc = new VCategoria(fa, nomesCategorias);
        vc.setVisible(true);
    }
    
    public void abrirMenuPrestamo(VLibro vl, Integer idLibro, Integer numEjemplar)
    {
        VPrestamo vpr;
        
        vpr = new VPrestamo(vl, true, fa, idLibro, numEjemplar);
        vpr.setVisible(true);
    }
}
