package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public enum TipoUsuario {
    Administrador
            {
        @Override
        public String toString()
        {
            return "Administrador";
        }
    },
    Normal
            {
        @Override
        public String toString()
        {
            return "Normal";
        }
    }

}
