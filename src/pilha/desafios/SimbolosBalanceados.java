package pilha.desafios;

import java.util.Stack;

public class SimbolosBalanceados {
    public static void main(String[] args) {
        exibirResultado("[(A+B)");
        exibirResultado("(A+B(");
        exibirResultado("(A+B)) - (C + D");
        exibirResultado("}[()]}[](){()}");
        exibirResultado("([");
        exibirResultado("[}");

        exibirResultado("{[()]}[](){()}");
        exibirResultado("(A+B) - (C + D)");
        exibirResultado("(A+B)");
        exibirResultado("((A+B)+C)");
    }


    public static void exibirResultado(String expressao) {
        String resultado = solucao2(expressao) ? "Sim" : "N�o";
        System.out.println(">> " + expressao + " << � v�lida? " + resultado);
    }



    //Minha solu��o: sem pilha e valida apenas par�nteses
    public static boolean solucao1(String expressao) {
        int soma = 0;
        char simbolo;

        for (int i = 0; i < expressao.length(); i++) {
            simbolo = expressao.charAt(i);
            if (simbolo == '(') soma++;
            if (simbolo == ')') soma--;

            if (soma < 0) { //Fechou sem abrir
                return false;
            }
        }

        return soma == 0;
    }



    //Solu��o da Loiane Groner: com pilha e valida qualquer s�mbolo
    final static String ABRE = "([{";
    final static String FECHA = ")]}";
    public static boolean solucao2(String expressao){
        Stack<Character> stack = new Stack<>();
        char simbolo, topo;

        for (int i = 0; i < expressao.length(); i++) {
            simbolo = expressao.charAt(i);

            if (ABRE.indexOf(simbolo) >= 0){
                stack.push(simbolo);

            } else if (FECHA.indexOf(simbolo) >= 0){
                if (stack.isEmpty()){ //Fechou sem abrir
                    return false;

                } else {
                    topo = stack.pop();
                    if (ABRE.indexOf(topo) != FECHA.indexOf(simbolo)){
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
