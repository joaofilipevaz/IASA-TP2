package resolvePuzzle;

import pee.PassoSolucao;
import pee.Solucao;
import pee.larg.ProcuraLarg;
import pee.melhorprim.ProcuraAA;
import pee.melhorprim.ProcuraCustoUnif;
import pee.melhorprim.ProcuraSofrega;
import pee.prof.ProcuraProf;
import pee.prof.ProcuraProfIter;
import puzzle.Puzzle;
import resolvePuzzle.modProb.OperadorPuzzle;
import resolvePuzzle.modProb.ProblemaPuzzle;

public class ResolvePuzzle {

    public static void main(String[] args){

        //configuração inicial
        int [][] A = {{1,2,3}, {8,4,5}, {6,7,0}};
        int [][] B = {{8,4,5}, {6,1,2}, {3,7,0}};
        int [][] F = {{1,2,3}, {4,5,6}, {7,8,0}};

        Puzzle confInicialA = new Puzzle(A);
        Puzzle confInicialB = new Puzzle(B);
        Puzzle confFinal = new Puzzle(F);

        OperadorPuzzle [] operador = definirOperadores();

        //problemas
        ProblemaPuzzle prob1 = new ProblemaPuzzle(confInicialA, confFinal, operador);
        ProblemaPuzzle prob2 = new ProblemaPuzzle(confInicialB, confFinal, operador);

        int procura = 1;

        switch (procura) {
            case 1:
                //procuraSofrega
                ProcuraSofrega procS = new ProcuraSofrega();
                System.out.println("Procura Sofrega:");
                Solucao solSof1 = procS.resolver(prob1);
                Solucao solSof2 = procS.resolver(prob2);
                mostrarPuzzle(solSof1, procS.getNnosFronteira(), procS.getNnosExpandidos() );
                mostrarPuzzle(solSof2, procS.getNnosFronteira(), procS.getNnosExpandidos() );
                System.out.println("=========================");
                break;
            case 2:
                //procuraAA
                ProcuraAA procAA = new ProcuraAA();
                System.out.println("Procura A*:");
                Solucao solAA1 = procAA.resolver(prob1);
                Solucao solAA2 = procAA.resolver(prob2);
                mostrarPuzzle(solAA1, procAA.getNnosFronteira(), procAA.getNnosExpandidos() );
                mostrarPuzzle(solAA2, procAA.getNnosFronteira(), procAA.getNnosExpandidos() );
                System.out.println("=========================");
                break;
            case 3:
                //Procura em Profundidade
                ProcuraProf mecProcuraProf = new ProcuraProf();
                System.out.println("Procura em Profundidade:");
                Solucao solProf1 = mecProcuraProf.resolver(prob1);
                Solucao solProf2 = mecProcuraProf.resolver(prob2);
                mostrarPuzzle(solProf1, mecProcuraProf.getNnosFronteira(), mecProcuraProf.getNnosExpandidos() );
                mostrarPuzzle(solProf2, mecProcuraProf.getNnosFronteira(), mecProcuraProf.getNnosExpandidos() );
                System.out.println("=========================");
                break;
            case 4:
                //Procura em Profundidade Iterativa
                ProcuraProfIter mecProcuraProfIter = new ProcuraProfIter();
                System.out.println("Procura em Profundidade Iterativa:");
                Solucao solProfIter1 = mecProcuraProfIter.resolver(prob1);
                Solucao solProfIter2 = mecProcuraProfIter.resolver(prob2);
                mostrarPuzzle(solProfIter1, mecProcuraProfIter.getNnosFronteira(), mecProcuraProfIter.getNnosExpandidos() );
                mostrarPuzzle(solProfIter2, mecProcuraProfIter.getNnosFronteira(), mecProcuraProfIter.getNnosExpandidos() );
                System.out.println("=========================");
                break;
            case 5:
                //Procura em Largura
                ProcuraLarg mecProcuraLarg = new ProcuraLarg();
                System.out.println("Procura em Largura:");
                Solucao solLarg1 = mecProcuraLarg.resolver(prob1);
                Solucao solLarg2 = mecProcuraLarg.resolver(prob2);
                mostrarPuzzle(solLarg1, mecProcuraLarg.getNnosFronteira(), mecProcuraLarg.getNnosExpandidos() );
                mostrarPuzzle(solLarg2, mecProcuraLarg.getNnosFronteira(), mecProcuraLarg.getNnosExpandidos() );
                System.out.println("=========================");
                break;
            case 6:
                //Procura custo Uniforme
                ProcuraCustoUnif mecProcuraCustUnif = new ProcuraCustoUnif();
                System.out.println("Procura Custo Uniforme:");
                Solucao solCustUnif1 = mecProcuraCustUnif.resolver(prob1);
                Solucao solCustUnif2 = mecProcuraCustUnif.resolver(prob2);
                mostrarPuzzle(solCustUnif1, mecProcuraCustUnif.getNnosFronteira(), mecProcuraCustUnif.getNnosExpandidos() );
                mostrarPuzzle(solCustUnif2, mecProcuraCustUnif.getNnosFronteira(), mecProcuraCustUnif.getNnosExpandidos() );
                System.out.println("=========================");
                break;
        }

    }

    private static OperadorPuzzle[] definirOperadores(){
        final int custoMovimento = 1;
        return new OperadorPuzzle[] {
                new OperadorPuzzle(Puzzle.Movimento.CIMA, custoMovimento),
                new OperadorPuzzle(Puzzle.Movimento.BAIXO, custoMovimento),
                new OperadorPuzzle(Puzzle.Movimento.ESQ, custoMovimento),
                new OperadorPuzzle(Puzzle.Movimento.DIR, custoMovimento),
        };
    }

    private static void mostrarPuzzle(Solucao solucao, int numMaxNosFronteira, int numNosExpandidos){
        int custo = 0;
        if (solucao != null){
            System.out.println("soluçao");
            for (PassoSolucao ps : solucao) {
                custo = (int )ps.getCusto();
                System.out.printf("estado: %s - custo: %s \n",ps.getEstado(), custo);
            }
            System.out.println("=========================");
            System.out.println("Custo da Soluçao = " + custo);
            System.out.println("Numero de nos expandidos = " + numNosExpandidos);
            System.out.println("Numero Máximo de nos Fronteira = " + numMaxNosFronteira);
            System.out.println("=========================");
        }
    }
}
