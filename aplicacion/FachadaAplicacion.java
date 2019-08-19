/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;


/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GesionLibros cl;
    GestionUsuarios cu;
    GestionCategorias cc;
    GestionPrestamos cp;
    
 public FachadaAplicacion(){
   fgui=new gui.FachadaGui(this);
   fbd= new baseDatos.FachadaBaseDatos(this);
   cl= new GesionLibros(fgui, fbd);
   cu= new GestionUsuarios(fgui, fbd);
   cc = new GestionCategorias(fgui, fbd);
   cp = new GestionPrestamos(fgui, fbd);
 }

 public static void main(String args[]) {
     FachadaAplicacion fa;
     
     fa= new FachadaAplicacion();
     fa.iniciaInterfazUsuario();
 }
 
 public void iniciaInterfazUsuario(){
     fgui.iniciaVista();
 }

 public void muestraExcepcion(String e){
     fgui.muestraExcepcion(e);
 }
 
public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor){
  return cl.obtenerLibros(id, titulo,  isbn,  autor);
};

public java.util.List<Usuario> obtenerUsuarios(String id, String nombre){
  return cu.obtenerUsuarios(id, nombre);
};

public void visualizarLibro(Integer idLibro){
 cl.visualizarLibro(idLibro);
}

public void nuevoLibro(){
 cl.nuevoLibro();
}

public Integer actualizarLibro(Libro l){
  return cl.actualizarLibro(l);
}

public void borrarLibro(Integer idLibro){
   cl.borrarLibro(idLibro);
}

public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
 cl.actualizarCategoriasLibro(idLibro, categorias);
}

public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar){
  return cl.actualizarEjemplaresLibro(idLibro, ejemplares, borrar);
}


public Boolean comprobarAutentificacion(String idUsuario, String clave){
  return cu.comprobarAutentificacion(idUsuario, clave);
}

//Novas funcions a engadir
 
public Boolean rexistrarUsuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
{
    return cu.rexistrarUsuario(idUsuario, clave, nombre, direccion, email, tipo);
}

public void abrirMenuUsuario()
{
    cu.abrirMenuUsuario();
}

public Boolean gardarUsuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
{
    return cu.gardarUsuario(idUsuario, clave, nombre, direccion, email, tipo);
}

public Boolean borrarUsuario(String idUsuario)
{
    return cu.borrarUsuario(idUsuario);
}

public void abrirMenuCategoria()
{
    cc.abrirMenuCategoria();
}

public Categoria obterCategoria(String nomeCategoria)
{
    return cc.obterCategoria(nomeCategoria);
}

public Boolean borrarCategoria(String nomeCategoria)
{
    return cc.borrarCategoria(nomeCategoria);
}

public java.util.List<String> actualizarCategorias()
{
    return cc.actualizarCategorias();
}

public Boolean gardarCategoria(String nomeCategoria, String descripcionCategoria)
{
    return cc.gardarCategoria(nomeCategoria, descripcionCategoria);
}

public java.util.List<Usuario> obtenerUsuariosPrestamos(String id, String nombre)
{
    return cp.obtenerUsuariosPrestamos(id, nombre);
}

public void abrirMenuPrestamo(gui.VLibro vl, Integer idLibro, Integer numEjemplar)
{
    cp.abrirMenuPrestamo(vl, idLibro, numEjemplar);
}

public Boolean prestarEjemplar(String idUsuario, Integer idLibro, Integer numEjemplar)
{
    return cp.prestarEjemplar(idUsuario, idLibro, numEjemplar);
}

public Boolean devolverEjemplar(Integer idLibro, Integer numEjemplar)
{
    return cp.devolverEjemplar(idLibro, numEjemplar);
}

}