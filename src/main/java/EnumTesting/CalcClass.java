package EnumTesting;

public class CalcClass {
    Double arg1;
    Double result;
    CalcActionEnum curentActon;

    public CalcClass() {
        this.arg1 = null;

        this.curentActon = null;
    }

    private void clear() {
        this.arg1 = null;

        this.curentActon = null;
    }

    private Double getArg1() {
        return this.arg1;
    }


    private void setArg1(Double arg1) {
        this.arg1 = arg1;
    }

    private boolean hasValidArg1() {
        return this.arg1 != null;
    }

    private void setFutureAction(CalcActionEnum enumAction) {
        this.curentActon = enumAction;
    }

    private Double plus(Double arg) {
        return getArg1() + arg;
    }

    private Double minus(Double arg) {
        return getArg1() - arg;
    }

    private Double mult(Double arg) {
        return getArg1() * arg;
    }

    private Double div(Double arg) {
        return getArg1() / arg;
    }

    public Double addFutureAction(CalcActionEnum calcActionEnum, double arg1) {
        switch (calcActionEnum) { // первая проверка на нажатие очистки или невалидного = с пустым аргументом
            case CLEAR -> {// очищаем
                this.clear();
                return Double.valueOf(0);
            }
            case RES -> {//нажато = но нет первого аргумента
                if (!hasValidArg1()) {
                    return arg1;
                }
            }
        }

        if (!hasValidArg1()) { // нажата кнопка действия и если нет первого аргумента
            this.setArg1(arg1);
            this.setFutureAction(calcActionEnum);
            return Double.valueOf(0);

        } else { // есть уже аргумент в объекте
          result = this.makeAction(arg1); // готовый результат
        }

        clear(); // Очищаем обьект, оставляем только результат


        switch (calcActionEnum){
            case RES -> {
                return result;
            }
            default -> {

                addFutureAction(calcActionEnum,result);
                return result;
            }
        }
    }

    private Double makeAction(double arg2) {
        switch (this.curentActon) {
            case PLUS -> {
                return plus(arg2);
            }
            case MINUS -> {
                return minus(arg2);
            }
            case DIV -> {
                return div(arg2);
            }
            case MULT -> {
                return mult(arg2);
            }
        }


        return null;
    }
}
