/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.DiasPrestamos;
import aplicacion.Usuario;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOPrestamos extends AbstractDAO {

    public DAOPrestamos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    /*
    public java.util.List<Usuario> obtenerUsuariosPrestamos(String id, String nombre)
    {
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios = null;
        ResultSet rsUsuarios;
        
        con = this.getConexion();
        
        String consulta;
        
        String parte1 = "select us.id_usuario, us.nombre, us.email, count(*) as vencidos " +
                        "from usuario as us, prestamo as pr " +
                        "where us.id_usuario = pr.usuario " +
                        "   and current_timestamp >= fecha_prestamo + INTERVAL '" + DiasPrestamos.diasPrestamo + " days' " +
                        "   and fecha_devolucion is null ";
        
        String parte2 = "select us.id_usuario, us.nombre, us.email, 0 as vencidos " +
                        "from usuario as us left join prestamo as pr on us.id_usuario = pr.usuario ";
             
        String frag = "";
        
        if(!id.isEmpty())
        {
            frag += "and id_usuario like ? ";
        }
        if(!nombre.isEmpty())
        {
            frag += "and nombre like ? ";
        }
        
        parte1 += frag +
                "group by us.id_usuario, us.nombre, us.email " +
                "union ";
        
        if(frag.isEmpty())
        {
            parte2 += frag +
                "group by us.id_usuario, us.nombre, us.email " +
                "having coalesce(max(fecha_prestamo), current_date) > current_date - INTERVAL '" + DiasPrestamos.diasPrestamo + " days' ";
        }
        else
        {
            parte2 += "where " + frag.substring(4,frag.length()) +
                "group by us.id_usuario, us.nombre, us.email " +
                "having coalesce(max(fecha_prestamo), current_date) > current_date - INTERVAL '" + DiasPrestamos.diasPrestamo + " days' ";
        }
        
        
        consulta = parte1 + parte2;
        try
        {
            stmUsuarios = con.prepareStatement(consulta);
            if(id.isEmpty())
            {
                if(!nombre.isEmpty())
                {
                    stmUsuarios.setString(1, "%"+nombre+"%");
                    stmUsuarios.setString(2, "%"+nombre+"%");
                }
            }
            else
            {
                if(nombre.isEmpty())
                {
                    stmUsuarios.setString(1, "%"+id+"%");
                    stmUsuarios.setString(2, "%"+id+"%");
                }
                else
                {
                    stmUsuarios.setString(1, "%"+id+"%");
                    stmUsuarios.setString(2, "%"+nombre+"%");
                    stmUsuarios.setString(3, "%"+id+"%");
                    stmUsuarios.setString(4, "%"+nombre+"%");
                }
            }
            
            System.out.println(stmUsuarios);
            rsUsuarios = stmUsuarios.executeQuery();
            
            while(rsUsuarios.next())
            {
                usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("nombre"),
                                        rsUsuarios.getString("email"), rsUsuarios.getInt("vencidos"));
                
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
    }*/
    
    public java.util.List<Usuario> obtenerUsuariosPrestamos(String id, String nombre)
    {
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios = null;
        ResultSet rsUsuarios;
        
        con = this.getConexion();
        
        String consulta = "select us.id_usuario, us.nombre, us.email, " +
                          "(select count(*) from prestamo as pr " +
                          "where pr.fecha_devolucion is null " +
                          " and pr.usuario = us.id_usuario " +
                          " and current_timestamp >= fecha_prestamo + INTERVAL '" + DiasPrestamos.diasPrestamo + " days') as vencidos " +
                          "from usuario as us ";
                
        String frag = "";
        
        if(!id.isEmpty())
        {
            frag += "us.id_usuario like ? ";
        }
        if(!nombre.isEmpty())
        {
            if(!id.isEmpty())
            {
                frag += "and us.nombre like ? ";
            }
            else
            {
                frag += "us.nombre like ? ";
            }
        }
        
        if(!frag.isEmpty())
        {
            consulta = consulta + "where " + frag;
        }
        
        try
        {
            stmUsuarios = con.prepareStatement(consulta);
            if(id.isEmpty())
            {
                if(!nombre.isEmpty())
                {
                    stmUsuarios.setString(1, "%"+nombre+"%");
                }
            }
            else
            {
                stmUsuarios.setString(1, "%"+id+"%");

                if(!nombre.isEmpty())
                {
                    stmUsuarios.setString(2, "%"+nombre+"%");
                }
            }
            
            rsUsuarios = stmUsuarios.executeQuery();
            
            while(rsUsuarios.next())
            {
                usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("nombre"),
                                        rsUsuarios.getString("email"), rsUsuarios.getInt("vencidos"));
                
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
    
    public int prestarEjemplar (String idUsuario, Integer idLibro, Integer numEjemplar)
    {
        int resultado = 0;
        
        Connection con;
        PreparedStatement stmPrestamo=null;

        con=super.getConexion();

        try {
            stmPrestamo=con.prepareStatement("insert into prestamo " +
                                            "values (?,?,?, current_timestamp, NULL)");
            stmPrestamo.setString(1, idUsuario);
            stmPrestamo.setInt(2, idLibro);
            stmPrestamo.setInt(3, numEjemplar);
            
            resultado = stmPrestamo.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmPrestamo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public Boolean comprobarDisponibilidade(Integer idLibro, Integer numEjemplar)
    {
        boolean resultado = false;
        
        Connection con;
        PreparedStatement stmPrestamo=null;
        ResultSet rsPrestamo;
        
        con = super.getConexion();
        
        try  {
            stmPrestamo=con.prepareStatement("select * " +
                                          "from prestamo " +
                                          "where fecha_devolucion is null " +
                                          " and libro = ? " +
                                          " and ejemplar = ? ");
            stmPrestamo.setInt(1, idLibro);
            stmPrestamo.setInt(2, numEjemplar);
            
            rsPrestamo=stmPrestamo.executeQuery();

            resultado = rsPrestamo.next();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmPrestamo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public int devolverEjemplar(Integer idLibro, Integer numEjemplar)
    {
        int resultado = 0;
        
        Connection con;
        PreparedStatement stmPrestamo=null;
        
        con = super.getConexion();
        
        try  {
            stmPrestamo=con.prepareStatement("update prestamo " +
                                            "set fecha_devolucion = current_timestamp " +
                                            "where libro = ? " +
                                            "   and ejemplar = ? ");
            stmPrestamo.setInt(1, idLibro);
            stmPrestamo.setInt(2, numEjemplar);
            
            resultado=stmPrestamo.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmPrestamo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
}
