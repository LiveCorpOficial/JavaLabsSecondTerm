package Laba4.Match;

import com.company.Complex;

public class ElemOperations {

    static public Complex ExponentCount (Complex z) {
        return new Complex(
                Math.exp(z.getRational())*Math.cos(z.getImaginary()),
                Math.exp(z.getImaginary())*Math.sin(z.getImaginary())
        );
    }
}
