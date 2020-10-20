package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Tp1 {

    static No head = new No();
    static boolean createNo = true;
    static int profMax = 12;
            
    public static void main(String[] args) {
        // TODO code application logic here

        head.setHead(3, 3, 1, 0);
        //setar a cabeça da arvoré,sendo (N Missionarios, N Canibais, Lado do Rio (1 esquerdo 0 direito), profundidade da árvore)
        search();
    }
    
    public static void search(){
        No prev = new No();
        prev.setHead(-1, -1, -1, -1);
        //setar um nó antecessor com valores que não são válidos
        //para na hora de observar o nó anterior do nó atual
        //para adicionar um nó na árvore que não seja repetido
        //não tenha problema com a cabeça da árvore
        for(int i = 0; i < profMax; i++){
            System.out.println("Prof: " + i);
            System.out.println("---------------");
            //fazer a parte interativa da busca, limitando o aprofundamento que a busca irá fazer
            createGraph(head, prev,i);
            System.out.println("---------------");
        }
    }

    public static void createGraph(No recent, No prev, int prof) {
        System.out.println(recent.getMissionario() + "  " + recent.getCanibal() + "  " + recent.getSide() + "  " + recent.getDeep());
        if(prof == recent.getDeep()){
            return;
            //caso eu chegue no limite de profundidade passada para a função, eu retorno ele para que eu não vá além desse limite
        }
        if (recent.getMissionario() == 0 && recent.getCanibal() == 0 && recent.getSide() == 0) {
            return;
            //caso eu chegue no meu nó objetivo que é (0,0,0) eu retorno a função e não vejo se terá nós filhos
        }
        No newNo = new No();
        //regras de validações para passar do lado esquerdo do rio para o lado direito 
        if (recent.getSide() == 1) {
            //
            //como o código só analisa o lado esquerdo do rio, sempre que irei passar para o lado direito o barco
            //eu sempre retiro do meu valor atual a quantidade de missionarios e canibais que tenho
            //primeiro caso passar para o lado direito 1 missionario
            if (recent.getMissionario() > 0) {
                newNo.setMissionario(recent.getMissionario() - 1);
                newNo.setCanibal(recent.getCanibal());
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                //como olho apenas o lado esquerdo, caso o valor total de missionarios menos o valor de missionarios que eu passei
                //seja menor que o valor total de canibais menos o valor de atuais de canibais do lado esquerdo do rio
                //significa que eu tenho uma posição inválida, por ter mais canibais do que missionarios do lado direito do rio
                //sendo 3 - nMissionario >= 3 - nCanibal
                //sendo assim, o resultado da primeira conta tem q ser sempre maior igual
                //e verifico tbm, se o valor atual de missionarios é maior que o de canibais do lado esquerdo
                if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal())) && newNo.getMissionario() >= newNo.getCanibal()) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                }
            }
            ////segundo caso passar para o lado direito 1 canibal
            if (recent.getCanibal() > 0) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario());
                newNo.setCanibal(recent.getCanibal() - 1);
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                //refaço a conta do valor total de missionarios menos o valor atual de missionarios para ver se é maior que o valor total
                //de canibais menos o valor atual para verificar o lado direito do rio para que eu possa passar 1 canibal para lá
                //sendo 3 - nMissionario <= 3 - nCanibal
                //é o inverso da de cima pois eu posso ter o caso de não ter passado nenhum missinário para o lado direito do rio
                //já o else if a conta de verificação é igual a anterior, pois tenho missionários do lado direito do rio
                if (newNo.getMissionario() == 3 && (3 - newNo.getMissionario() <= (3 - newNo.getCanibal()))) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                } else if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                }
            }
            //terceiro caso passar para o lado direito 2 missionarios
            if (recent.getMissionario() > 1) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() - 2);
                newNo.setCanibal(recent.getCanibal());
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                if (newNo.getMissionario() > 0) {
                    if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal())) && newNo.getMissionario() >= newNo.getCanibal()) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.addNo(newNo);
                            createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                        }
                        createNo = true;
                    }
                } else {
                    if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.addNo(newNo);
                            createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                        }
                        createNo = true;
                    }
                }
            }
            //quarto caso passar para o lado direito 2 canibais
            if (recent.getCanibal() > 1) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario());
                newNo.setCanibal(recent.getCanibal() - 2);
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                if (newNo.getMissionario() == 3 && (3 - newNo.getMissionario() <= (3 - newNo.getCanibal()))) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                } else if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                }
            }
            //quinto caso passar para o lado direito 1 canibal e 1 missionario
            if (recent.getMissionario() > 0 && recent.getCanibal() > 0) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() - 1);
                newNo.setCanibal(recent.getCanibal() - 1);
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal())) && newNo.getMissionario() >= newNo.getCanibal()) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                }
            }
            return;

        } else {
            //regras para passar do lado direito do rio para o lado esquerdo]
            //primeiro caso passar para o lado esquerdo 1 missionario
            if (recent.getMissionario() < 3) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() + 1);
                newNo.setCanibal(recent.getCanibal());
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                //utilizo a formula novamente com o >= para verificar se o número de missionarios no lado direito do rio é maior ou igual
                //e depois verifico se do lado esquerdo do rio é maior ou igual também
                if ((3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                    if (newNo.getMissionario() >= newNo.getCanibal()) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.addNo(newNo);
                            createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                        }
                        createNo = true;
                    }
                }
            }

            //segundo caso passar para o lado esquerdo 1 canibal
            if (recent.getCanibal() < 3) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario());
                newNo.setCanibal(recent.getCanibal() + 1);
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                if (newNo.getMissionario() >= newNo.getCanibal()) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                } else if (newNo.getMissionario() == 0) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                }
            }

            //segundo caso passar para o lado esquerdo 2 missionarios
            if (recent.getMissionario() < 2) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() + 2);
                newNo.setCanibal(recent.getCanibal());
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                if ((3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                    if (newNo.getMissionario() > newNo.getCanibal()) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.addNo(newNo);
                            createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                        }
                        createNo = true;
                    }
                }
            }

            //segundo caso passar para o lado esquerdo 2 canibais
            if (recent.getCanibal() < 2) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario());
                newNo.setCanibal(recent.getCanibal() + 2);
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                if (newNo.getMissionario() >= newNo.getCanibal()) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                }
                if (newNo.getMissionario() == 0) {
                    validateNo(head, newNo);
                    if (createNo) {
                        recent.addNo(newNo);
                        createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                    }
                    createNo = true;
                }
            }
            //segundo caso passar para o lado esquerdo 1 canibal e 1 missionario
            if (recent.getMissionario() < 3 && recent.getCanibal() < 3) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() + 1);
                newNo.setCanibal(recent.getCanibal() + 1);
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                newNo.setFilhos();
                if ((3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                    if (newNo.getMissionario() >= newNo.getCanibal()) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.addNo(newNo);
                            createGraph(recent.getFilhos().get(recent.getFilhos().indexOf(newNo)), recent, prof);
                        }
                        createNo = true;
                    }
                }
            }
            return;
        }
    }
    //função para verificar se um Nó já existe na árvore
    public static void validateNo(No recent, No newNo) {
        //caso o nó que estou verificando seja o meu nó objetivo, eu já retorno a função direto para que ele possa ser adicionado
        if (newNo.getMissionario() == 0
                && newNo.getCanibal() == 0
                && newNo.getSide() == 0) {
            return;
        }
        //caso exista o nó, eu verifico se a profundidade do nó que eu quero adicionar é maior que o nó que já existe na árovre
        //caso ele seja maior eu não adiciono por ser o caso de um nó antecessor do nó q eu quero adicionar
        if (newNo.getMissionario() == recent.getMissionario()
                && newNo.getCanibal() == recent.getCanibal()
                && newNo.getSide() == recent.getSide()) {
            if (newNo.getDeep() > recent.getDeep()) {
                createNo = false;
            }
            return;
        }
        //se o meu nó recente tiver filhos, eu percorro todos para verificar se algum dele é igual ao nó que quero adicionar
        //utilizando de recursão para poder percorrer toda a árvore
        if (recent.getFilhos() != null) {
            for (int i = 0; i < recent.getFilhos().size(); i++) {
                validateNo(recent.getFilhos().get(i), newNo);
            }
        }
        return;
    }
}
