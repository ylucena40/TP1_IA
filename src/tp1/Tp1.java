/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.Scanner;

/**
 *
 * @author Yanlu
 */
public class Tp1 {

    static char source[] = new char[6];
    static char destiny[] = new char[6];
    static int nMissionarioSource = 0;
    static int nCanibalSource = 0;
    static int nMissionarioDestiny = 0;
    static int nCanibalDestiny = 0;
    static int goRet = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        setPerson();
        while (nMissionarioSource > 0 || nCanibalSource > 0) {
            System.out.println("Digite o numero de pelo menos 1 passageiro para o barco passar para o outro lado do rio");
            System.out.println("Caso for mandar apenas um, digite duas vezes o mesmo numero");

            if (goRet % 2 == 0) {
                System.out.println("Ida");
            } else {
                System.out.println("Volta");
            }

            print();
            int i = 7;
            int j = 7;
            while (i > 6 && j > 6) {
                i = scanner.nextInt();
                j = scanner.nextInt();
                if (i < 0 || j < 0) {
                    i = 7;
                    j = 7;
                    System.out.println("Digite novamente");
                } else {
                    if (goRet % 2 == 0) {
                        if (source[i] == 'N' || source[j] == 'N') {
                            i = 7;
                            j = 7;
                            System.out.println("Digite novamente, escolha de posicao sem ngm");
                        }
                    } else {
                        if (destiny[i] == 'N' || destiny[j] == 'N') {
                            i = 7;
                            j = 7;
                            System.out.println("Digite novamente, escolha de posicao sem ngm");
                        }
                    }

                }
            }
            cross(i, j);
            goRet++;
            if(rules() == 1){
                System.out.println("Voce perdeu, numero de Canibais maior que o de missionarios");
                break;
            }
        }

    }

    public static void cross(int i, int j) {
        if (goRet % 2 == 0) {
            if (i == j) {
                destiny[i] = source[i];
                if(source[i] == 'M'){
                    nMissionarioSource--;
                    nMissionarioDestiny++;
                }
                else{
                    nCanibalSource--;
                    nCanibalDestiny++;
                }
                source[i] = 'N';
                
            } else {
                destiny[i] = source[i];
                if(source[i] == 'M'){
                    nMissionarioSource--;
                    nMissionarioDestiny++;
                }
                else{
                    nCanibalSource--;
                    nCanibalDestiny++;
                }
                source[i] = 'N';
                destiny[j] = source[j];
                if(source[j] == 'M'){
                    nMissionarioSource--;
                    nMissionarioDestiny++;
                }
                else{
                    nCanibalSource--;
                    nCanibalDestiny++;
                }
                source[j] = 'N';
            }
        } else {
            if (i == j) {
                source[i] = destiny[i];
                if(destiny[i] == 'M'){
                    nMissionarioDestiny--;
                    nMissionarioSource++;
                }
                else{
                    nCanibalDestiny--;
                    nCanibalSource++;
                }
                destiny[i] = 'N';
            } else {
                source[i] = destiny[i];
                if(destiny[i] == 'M'){
                    nMissionarioDestiny--;
                    nMissionarioSource++;
                }
                else{
                    nCanibalDestiny--;
                    nCanibalSource++;
                }
                destiny[i] = 'N';
                source[j] = destiny[j];
                if(destiny[j] == 'M'){
                    nMissionarioDestiny--;
                    nMissionarioSource++;
                }
                else{
                    nCanibalDestiny--;
                    nCanibalSource++;
                }
                destiny[j] = 'N';
            }
        }
    }

    public static void print() {
        for (int i = 0; i < 6; i++) {
            System.out.printf(destiny[i] + " ");
        }
        System.out.printf("\n");
        for (int i = 0; i < 6; i++) {
            System.out.printf(i + " ");
        }
        System.out.printf("\n");
        System.out.println("----------------");
        System.out.println("~~~~~~~~~~~~~~~~");
        System.out.println("----------------");
        for (int i = 0; i < 6; i++) {
            System.out.printf(source[i] + " ");
        }
        System.out.printf("\n");
        for (int i = 0; i < 6; i++) {
            System.out.printf(i + " ");
        }
        System.out.printf("\n");

    }

    public static int rules() {
        if (nCanibalSource > nMissionarioSource && nMissionarioSource > 0) {
            return 1;
        };
        if (nCanibalDestiny > nMissionarioDestiny && nMissionarioDestiny > 0) {
            return 1;
        }
        return 0;
    }

    ;
    
    public static void setPerson() {
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                source[i] = 'M';
                nMissionarioSource++;
            } else {
                source[i] = 'C';
                nCanibalSource++;
            }
            destiny[i] = 'N';
        }
    }

}