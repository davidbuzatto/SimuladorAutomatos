/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simuladorautomatos;

/**
 *
 * @author David
 */
public class Utils {

    public static double gerarHipotenusa(
            double x1, double y1,
            double x2, double y2 ) {

        double x = Math.abs( x1 ) - Math.abs( x2 );
        double y = Math.abs( y1 ) - Math.abs( y2 );

        return Math.sqrt( Math.pow( x, 2 ) + Math.pow( y, 2 ) );

    }

    // para sistema carteziano normal
    private static int detectarQuadrante(
            double x1, double y1,
            double x2, double y2 ) {

        if ( ( x2 > x1 && y2 > y1 ) ||
                ( x2 > x1 && y2 == y1 ) ||
                ( x2 == x1 && y2 > y1 ) ||
                ( x2 == x1 && y2 == y1 ) )
            return 1;

        if ( ( x2 < x1 && y2 > y1 ) )
            return 2;

        if ( ( x2 < x1 && y2 < y1 ) ||
                ( x2 == x1 && y2 < y1 ) ||
                ( x2 < x1 && y2 == y1 ) )
            return 3;
        
        return 4;

    }

    private static int gerarIncrementoAngulo(
            double x1, double y1,
            double x2, double y2 ) {

        int q = detectarQuadrante( x1, y1, x2, y2 );

        if ( q == 1 ) {
            return 0;
        } else if ( q == 2 ) {
            return 90;
        } else if ( q == 3 ) {
            return 180;
        } else {
            return 270;
        }

    }

    public static double obtemGrauRelativo(
            double x1, double y1,
            double x2, double y2 ) {

        double x = 0;
        double y = 0;

        if ( x2 > x1 )
            x = x2 - x1;
        else
            x = x1 - x2;

        if ( y2 > y1 )
            y = y2 - y1;
        else
            y = y1 - y2;

        return gerarIncrementoAngulo( x1, y1, x2, y2 ) +
                Math.toDegrees( Math.atan2( y, x ) );

    }

    // adaptado
    public static double obtemGrauRelativoJava(
            double x1, double y1,
            double x2, double y2 ) {

        double x = 0;
        double y = 0;

        if ( x2 > x1 )
            x = x2 - x1;
        else
            x = x1 - x2;

        if ( y2 > y1 )
            y = y2 - y1;
        else
            y = y1 - y2;

        int incr = gerarIncrementoAngulo( x1, y1, x2, y2 );
        double ang = Math.toDegrees( Math.atan2( y, x ) );

        if ( incr == 90 || incr == 270 )
            ang = 90 - ang;

        return incr + ang;

    }


}
