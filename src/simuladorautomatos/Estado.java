/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simuladorautomatos;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Estado {

    private String nome;
    private boolean inicial;
    private boolean estFinal;
    private ArrayList< Transicao > transicoes;
    private int xCentral;
    private int yCentral;
    
    public Estado( String nome, boolean inicial, boolean estFinal ) {
        this.nome = nome;
        this.inicial = inicial;
        this.estFinal = estFinal;
        transicoes = new ArrayList< Transicao >();
    }

    public boolean isFinal() {
        return estFinal;
    }

    public boolean isInicial() {
        return inicial;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Transicao> getTransicoes() {
        return transicoes;
    }

    public int getXCentral() {
        return xCentral;
    }

    public int getYCentral() {
        return yCentral;
    }
    
    public void setFinal( boolean estFinal ) {
        this.estFinal = estFinal;
    }
    
    public void setXCentral( int xCentral ) {
        this.xCentral = xCentral;
    }

    public void setYCentral( int yCentral ) {
        this.yCentral = yCentral;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Estado other = ( Estado ) obj;
        if ( this.nome != other.nome && ( this.nome == null || !this.nome.equals( other.nome ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + ( this.nome != null ? this.nome.hashCode() : 0 );
        return hash;
    }
    
    @Override
    public String toString() {
        if ( inicial && !estFinal ) {
            return "\u2192" + nome;
        } else if ( !inicial && estFinal ) {
            return "*" + nome;
        } else if ( inicial && estFinal ) {
            return "\u2192*" + nome;
        } else {
            return nome;
        }
    }
    
}
