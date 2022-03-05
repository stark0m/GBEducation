package Lesson10;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

public class MyList<E> extends ArrayList<E> implements SwapImpl<E> {


    @Override
    public boolean swap(E o1, E o2)  {
        if (!this.contains(o1) || !this.contains(o2)){
            return false;
        }
        Object temp = this.get(this.indexOf(o1));

        o1=this.get(this.indexOf(o1));
        this.set(this.indexOf(o1),(E)o2);
        this.set(this.indexOf(o2),(E)temp);


        return true;

    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Object o : this) {
            stringBuilder.append(o.toString()+" ") ;

        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
