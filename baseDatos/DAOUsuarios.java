/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOUsuarios extends AbstractDAO {

   public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Usuario validarUsuario(String idUsuario, String clave){
        Usuario resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

        con=this.getConexion();

        try {
        stmUsuario=con.prepareStatement("select id_usuario, clave, nombre, direccion, email, tipo_usuario "+
                                        "from usuario "+
                                        "where id_usuario = ? and clave = ?");
        stmUsuario.setString(1, idUsuario);
        stmUsuario.setString(2, clave);
        rsUsuario=stmUsuario.executeQuery();
        if (rsUsuario.next())
        {
            resultado = new Usuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"),
                                      rsUsuario.getString("nombre"), rsUsuario.getString("direccion"),
                                      rsUsuario.getString("email"), TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    public int rexistrarUsuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
    {
        int result = 0;
        
        Connection con;
        PreparedStatement stmUsuario = null;
        
        con = this.getConexion();
        
        try
        {
            stmUsuario = con.prepareStatement("insert into usuario values (?, ?, ?, ?, ?, ?);");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);
            stmUsuario.setString(3, nombre);
            stmUsuario.setString(4, direccion);
            stmUsuario.setString(5, email);
            stmUsuario.setString(6, tipo.toString());
            
            result = stmUsuario.executeUpdate();
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return result;
    }
    
    public java.util.List<Usuario> consultarUsuarios(String id, String nombre)
    {
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios = null;
        ResultSet rsUsuarios;
        
        con = this.getConexion();
        
        String consulta = "select id_usuario, clave, nombre, direccion, email, tipo_usuario " +
                                "from usuario as u ";
        
        if(!id.isEmpty())
        {
            consulta += "where id_usuario like ?";
        }
        if(!nombre.isEmpty())
        {
            consulta += "where nombre like ?";
        }
        
        //Teriamos que engadir comprobacion para valores nulos¿?
        
        try
        {
            stmUsuarios = con.prepareStatement(consulta);
            if(!id.isEmpty())
            {
                stmUsuarios.setString(1, "%"+id+"%");
                
                if(!nombre.isEmpty())
                {
                    stmUsuarios.setString(2, "%"+nombre+"%");
                }
            }
            else
            {
                if(!nombre.isEmpty())
                {
                    stmUsuarios.setString(1, "%"+nombre+"%");
                }
            }
            
            rsUsuarios = stmUsuarios.executeQuery();
            
            while(rsUsuarios.next())
            {
                usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("clave"),
                                      rsUsuarios.getString("nombre"), rsUsuarios.getString("direccion"),
                                      rsUsuarios.getString("email"), TipoUsuario.valueOf(rsUsuarios.getString("tipo_usuario")));
                
                resultado.add(usuarioActual);
            }
        }
        catch (SQLException e)
        {
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally
        {
          try {stmUsuarios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public int actualizarUsuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
    {
        int resultado = 0;
        
        Connection con;
        PreparedStatement stmUsuario = null;
        
        con = this.getConexion();
        
        try
        {
            stmUsuario = con.prepareStatement("update usuario "
                                                + "set clave = ?, nombre = ?, direccion = ?, email = ?, tipo_usuario = ? "
                                                + "where id_usuario = ?");
            stmUsuario.setString(1, clave);
            stmUsuario.setString(2, nombre);
            stmUsuario.setString(3, direccion);
            stmUsuario.setString(4, email);
            stmUsuario.setString(5, tipo.toString());
            stmUsuario.setString(6, idUsuario);
            
            resultado = stmUsuario.executeUpdate();
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public boolean existeUsuario(String idUsuario)
    {
        boolean resultado = false;
        
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;
        
        con = this.getConexion();
        
        try
        {
            stmUsuario = con.prepareStatement("select *"
                                               + "from usuario "
                                               + "where id_usuario = ?");
            
            stmUsuario.setString(1, idUsuario);
            
            rsUsuario = stmUsuario.executeQuery();
            
            resultado = rsUsuario.next();
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public int gardarUsuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
    {
        int resultado = 0;
        
        if(!idUsuario.isEmpty() && !clave.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && !email.isEmpty())
        {
            if(existeUsuario(idUsuario))
            {
                resultado = actualizarUsuario(idUsuario, clave, nombre, direccion, email, tipo);
            }
            else
            {
                resultado = rexistrarUsuario(idUsuario, clave, nombre, direccion, email, tipo);
            }
        }
        
        return resultado;
    }
    
    public int borrarUsuario(String idUsuario)
    {
        int resultado = 0;
        
        Connection con;
        PreparedStatement stmUsuario = null;
        
        con = this.getConexion();
        
        if(!idUsuario.isEmpty())
        {
            try
            {
                stmUsuario = con.prepareStatement("delete from usuario "
                                                    + "where id_usuario = ?");
                stmUsuario.setString(1, idUsuario);

                resultado = stmUsuario.executeUpdate();
            }
            catch (SQLException e){
              System.out.println(e.getMessage());
              this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
              try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
        
        return resultado;
    }
}