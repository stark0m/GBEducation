package EnumTesting;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {

        CalcClass calc = new CalcClass();
        NumberFormat nf = new DecimalFormat("#.######");



        System.out.println(nf.format(
                calc.addFutureAction(CalcActionEnum.MULT, 12)
                                        )); //null
        System.out.println(nf.format(calc.addFutureAction(CalcActionEnum.MINUS, 2))); //24
        System.out.println(nf.format(calc.addFutureAction(CalcActionEnum.RES, 3))); //21
        System.out.println(nf.format(calc.addFutureAction(CalcActionEnum.RES, 3))); //21

    }

}