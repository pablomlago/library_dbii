/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
/**
 *
 * @author basesdatos
 */
public class GestionUsuarios {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
    
    
  public Boolean comprobarAutentificacion(String idUsuario, String clave){
      Usuario u;

      u=fbd.validarUsuario(idUsuario, clave);
      if (u!=null){
          return u.getTipoUsuario()==TipoUsuario.Administrador;
      } else return false;
  }
  
  //Novas funcions
  
  
  //Quereriamos que fora Boolean
  public Boolean rexistrarUsuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
  {
    int resultado = fbd.rexistrarUsuario(idUsuario, clave, nombre, direccion, email, tipo);
    
    return resultado != 0;
  }
  
  public Boolean gardarUsuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
  {
    int resultado = fbd.gardarUsuario(idUsuario, clave, nombre, direccion, email, tipo);
    
    return resultado != 0;
  }
  
  public void abrirMenuUsuario()
  {
      //Poderiamos ter que engadir mais codigo
      fgui.abrirMenuUsuario();
  }
  
  public java.util.List<Usuario> obtenerUsuarios(String id, String nombre)
  {
      return fbd.consultarUsuarios(id, nombre);
  }
  
  public Boolean borrarUsuario(String idUsuario)
  {
      int resultado = fbd.borrarUsuario(idUsuario);
      
      return resultado != 0;
  }
  
}
