/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import aplicacion.Libro;

/**
 *
 * @author basesdatos
 */
public class Ejemplar {

    private Integer numEjemplar;
    private String localizador;
    private String anoCompra;
    private Libro libro;
    
    private String nomeUsuario;
    private String fechaPrestamo;
    private String fechaVencemento;
    
    private Boolean foiPrestado;

    public Ejemplar(Libro libro, Integer numEjemplar, String localizador, String anoCompra){
        this.numEjemplar=numEjemplar;
        this.anoCompra=anoCompra;
        this.localizador=localizador;
        this.libro=libro;
        
        this.nomeUsuario = "";
        this.fechaPrestamo = "";
        this.fechaVencemento = "";
        
        this.foiPrestado = false;
    }
    
    public Ejemplar(Libro libro, Integer numEjemplar, String localizador, String anoCompra, String nomeUsuario, String fechaPrestamo, String fechaVencemento, Boolean foiPrestado){
        this.numEjemplar=numEjemplar;
        this.anoCompra=anoCompra;
        this.localizador=localizador;
        this.libro=libro;
        
        this.nomeUsuario = nomeUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencemento = fechaVencemento;
        
        this.foiPrestado = foiPrestado;
    }

    public Integer getNumEjemplar(){
        return this.numEjemplar;
    }

    public String getAnoCompra(){
        return this.anoCompra;
    }

    public String getLocalizador(){
        return this.localizador;
    }

    public Libro getLibro(){
        return this.libro;
    }

    public void setLocalizador(String l){
        localizador =l;
    }
    
    public void setAnoCompra(String a){
        anoCompra = a;
    }
    
    public String getNomeUsuario()
    {
        return this.nomeUsuario;
    }
    
    public String getFechaPrestamo()
    {
        return this.fechaPrestamo;
    }
    
    public Boolean getFoiPrestado()
    {
        return this.foiPrestado;
    }
    
    public void setFoiPrestado(Boolean foiPrestado)
    {
        this.foiPrestado = foiPrestado;
    }
    
    public String getFechaVencemento()
    {
        return this.fechaVencemento;
    }
    
}
