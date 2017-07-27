package pee.modprob;

/**
 *
 */
public abstract class Estado {

    @Override
    public boolean equals(Object obj){
        return ( (obj instanceof Estado) && (obj.hashCode() == hashCode()) );
    }

    public abstract int hashCode();
}
