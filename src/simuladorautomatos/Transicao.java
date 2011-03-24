/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simuladorautomatos;

import java.util.TreeSet;

/**
 *
 * @author David
 */
public class Transicao {

    // para facilitar o desenho dos simbolos da transição
    // adotou-se aqui que uma transição pode ter n símbolos, o que no
    // modelo real siginifica que essa transição representa n transições.
    private TreeSet< Character > simbolos;
    private Estado estadoDestino;
    
    public Transicao( TreeSet< Character > simbolos, Estado estadoDestino ) {
        this.simbolos = simbolos;
        this.estadoDestino = estadoDestino;
    }

    public Estado getEstadoDestino() {
        return estadoDestino;
    }

    public TreeSet< Character > getSimbolos() {
        return simbolos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transicao other = (Transicao) obj;
        if (this.simbolos != other.simbolos && (this.simbolos == null || !this.simbolos.equals(other.simbolos))) {
            return false;
        }
        if (this.estadoDestino != other.estadoDestino && (this.estadoDestino == null || !this.estadoDestino.equals(other.estadoDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + ( this.simbolos != null ? this.simbolos.hashCode() : 0 );
        hash = 83 * hash + ( this.estadoDestino != null ? this.estadoDestino.hashCode() : 0 );
        return hash;
    }
    
    @Override
    public String toString() {
        return "<html><font color=\"#0000CC\">Símbolo(s): " + geraStringSimbolos() + "</font>" +
                " --- <font color=\"#CC0000\">Destino: " + estadoDestino.toString() + "</font></html>"; 
    }

    public String geraStringSimbolos() {

        StringBuilder sb = new StringBuilder();
        for ( Character c : simbolos ) {
            sb.append( c + ", " );
        }

        if ( simbolos.size() == 0 ) {
            return "";
        } else {
            return sb.toString().substring( 0, sb.toString().length() - 2 );
        }
        
    }

}
