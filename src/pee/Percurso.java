package pee;

import pee.mecproc.mem.No;

import java.util.Iterator;
import java.util.LinkedList;

public class Percurso implements Solucao {

    private LinkedList<PassoSolucao> percurso = new LinkedList<PassoSolucao>();

    @Override
    public Iterator<PassoSolucao> iterator() {
        return percurso.iterator();
    }

    public int getDimensao(){
        if(percurso.isEmpty())
            return 0;
        return percurso.size();
    }

    public double getCusto(){
        if (percurso.isEmpty()) {
            return 0;
        }
        return percurso.getLast().getCusto();
    }

    public void juntarInicio(No no){
        percurso.addFirst(no);
    }
}