/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Ejemplar;
import aplicacion.Usuario;
import aplicacion.Categoria;
import aplicacion.Libro;
import aplicacion.TipoUsuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOLibros daoLibros;
    private DAOCategorias daoCategorias;
    private DAOUsuarios daoUsuarios;
    private DAOPrestamos daoPrestamos;

    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);

            daoLibros = new DAOLibros(conexion, fa);
            daoCategorias = new DAOCategorias(conexion, fa);
            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoPrestamos = new DAOPrestamos(conexion, fa);


        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        } 
    }
    
    

    public java.util.List<Libro> consultarCatalogo(Integer id, String titulo, String isbn, String autor){
        return daoLibros.consultarCatalogo(id, titulo, isbn, autor);
    }

    //Revisar que non afecta a outras funcions
    public Libro consultarLibro(Integer idLibro){
        return daoLibros.consultarLibroPrestamos(idLibro);
    }
    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro){
        
        //return daoLibros.consultarEjemplaresLibro(idLibro);
        return daoLibros.consultarEjemplaresLibroPrestamos(idLibro);
    }
    public java.util.List<String> obtenerRestoCategorias(Integer idLibro){
        return daoLibros.obtenerRestoCategorias(idLibro);
    }
    public Integer insertarLibro(Libro libro){
       return daoLibros.insertarLibro(libro);
    }
    public void borrarLibro(Integer idLibro){
        daoLibros.borrarLibro(idLibro);
    }
    public void modificarLibro(Libro libro){
         daoLibros.modificarLibro(libro);
    }
    public void modificarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
       daoLibros.modificarCategoriasLibro(idLibro, categorias);
    }
    public void insertarEjemplarLibro(Integer idLibro, Ejemplar ejemplar){
        daoLibros.insertarEjemplarLibro(idLibro, ejemplar);
    }
    public void borrarEjemplaresLibro(Integer idLibro, java.util.List<Integer> numsEjemplar){
        daoLibros.borrarEjemplaresLibro(idLibro, numsEjemplar);
    }
    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar){
        daoLibros.modificarEjemplarLibro(idLibro, ejemplar);
    }

    public Usuario validarUsuario(String idUsuario, String clave){
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }
   
    public java.util.List<Categoria> consultarCategorias(){
        return daoCategorias.consultarCategorias();
    }
    
    //Novas funcions
    
    public int rexistrarUsuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
    {
        return daoUsuarios.rexistrarUsuario(idUsuario, clave, nombre, direccion, email, tipo);
    }
    
    public int gardarUsuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
    {
        return daoUsuarios.gardarUsuario(idUsuario, clave, nombre, direccion, email, tipo);
    }
    
    public java.util.List<Usuario> consultarUsuarios(String id, String nombre)
    {
        return daoUsuarios.consultarUsuarios(id, nombre);
    }
    
    public int borrarUsuario(String idUsuario)
    {
        return daoUsuarios.borrarUsuario(idUsuario);
    }

    public Categoria obterCategoria(String nomeCategoria)
    {
        return daoCategorias.obterCategoria(nomeCategoria);
    }
    
    public int borrarCategoria(String nomeCategoria)
    {
        int result = 0;
        
        if(!daoLibros.consultarLibrosCategoria(nomeCategoria))
        {
            result = daoCategorias.borrarCategoria(nomeCategoria);
        }
        else
        {
            //Non se lanza realmente unha excepcion
            this.fa.muestraExcepcion("Existen libros desta categoria");
        }
        return result;
    }
    
    public int gardarCategoria(String nomeCategoria, String descripcionCategoria)
    {
        return daoCategorias.gardarCategoria(nomeCategoria, descripcionCategoria);
    }
    
    public java.util.List<Usuario> obtenerUsuariosPrestamos(String id, String nombre)
    {
        return daoPrestamos.obtenerUsuariosPrestamos(id, nombre);
    }
    
    public int prestarEjemplar(String idUsuario, Integer idLibro, Integer numEjemplar)
    {
        return daoPrestamos.prestarEjemplar(idUsuario, idLibro, numEjemplar);
    }
    
    public int devolverEjemplar(Integer idLibro, Integer numEjemplar)
    {
        return daoPrestamos.devolverEjemplar(idLibro, numEjemplar);
    }
}
