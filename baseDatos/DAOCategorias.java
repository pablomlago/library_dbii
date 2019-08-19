/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Categoria;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOCategorias extends AbstractDAO {
   
    
    public DAOCategorias (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Categoria> consultarCategorias(){
        java.util.List<Categoria> resultado = new java.util.ArrayList<Categoria>();
        Categoria categoriaActual;
        Connection con;
        PreparedStatement stmCategorias=null;
        ResultSet rsCategorias;

        con=this.getConexion();

        try  {
        stmCategorias=con.prepareStatement("select nombre, descripcion from categoria");
        rsCategorias=stmCategorias.executeQuery();
        while (rsCategorias.next())
        {
            categoriaActual = new Categoria(rsCategorias.getString("nombre"), rsCategorias.getString("descripcion"));
            resultado.add(categoriaActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategorias.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    public Categoria obterCategoria(String nomeCategoria)
    {
        Categoria categoria = null;
        
        Connection con;
        PreparedStatement stmCategoria = null;
        ResultSet rsCategoria;
        
        con = this.getConexion();
        
        try
        {
            stmCategoria = con.prepareStatement("select * "
                                                + "from categoria as ca "
                                                + "where nombre = ? ");
            
            stmCategoria.setString(1, nomeCategoria);
            
            rsCategoria = stmCategoria.executeQuery();
            
            if(rsCategoria.next())
            {
                categoria = new Categoria(rsCategoria.getString("nombre"), rsCategoria.getString("descripcion"));
            }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategoria.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return categoria;
    }
   
    public int borrarCategoria(String nomeCategoria)
    {
        int resultado = 0;
        
        Connection con;
        PreparedStatement stmCategoria = null;
        
        con = this.getConexion();
        
        if(!nomeCategoria.isEmpty()) //Poderiamolo suprimir
        {
            try
            {
                stmCategoria = con.prepareStatement("delete from categoria "
                                                    + "where nombre = ?");
                stmCategoria.setString(1, nomeCategoria);

                resultado = stmCategoria.executeUpdate();
            }
            catch (SQLException e){
              System.out.println(e.getMessage());
              this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
              try {stmCategoria.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
        
        return resultado;
    }
    
    public Boolean existeCategoria(String nomeCategoria)
    {
        boolean resultado = false;
        
        Connection con;
        PreparedStatement stmCategoria = null;
        ResultSet rsCategoria;
        
        con = this.getConexion();
        
        try
        {
            stmCategoria = con.prepareStatement("select *"
                                               + "from categoria as ca "
                                               + "where nombre = ? ");
            
            stmCategoria.setString(1, nomeCategoria);
            
            rsCategoria = stmCategoria.executeQuery();
            
            resultado = rsCategoria.next();
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategoria.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public int crearCategoria(String nomeCategoria, String descripcionCategoria)
    {
        int result = 0;
        
        Connection con;
        PreparedStatement stmCategoria = null;
        
        con = this.getConexion();
        
        try
        {
            stmCategoria = con.prepareStatement("insert into categoria values (?, ?);");
            stmCategoria.setString(1, nomeCategoria);
            stmCategoria.setString(2, descripcionCategoria);
            
            result = stmCategoria.executeUpdate();
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategoria.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return result;
    }
    
    public int gardarCategoria(String nomeCategoria, String descripcionCategoria)
    {
        int result = 0;
        
        if(this.existeCategoria(nomeCategoria))
        {
            this.getFachadaAplicacion().muestraExcepcion("Xa existe unha categoria con dito nome");
        }
        else
        {
            result = this.crearCategoria(nomeCategoria, descripcionCategoria);
        }
        
        return result;
    }
}
