package tp1;

import java.util.Scanner;

public class Tp1 {

    static char source[] = new char[6];
    static char destiny[] = new char[6];
    static int nMissionarioSource = 0;
    static int nCanibalSource = 0;
    static int nMissionarioDestiny = 0;
    static int nCanibalDestiny = 0;
    static int goRet = 0;
    static No head = new No();

    public static void main(String[] args) {
        // TODO code application logic here

        //setPerson();
        //play();
        head.setHead(3, 3, 1, 0);
        createNo(head);
        System.out.println("aqui");
    }

    public static void createNo(No recent) {
        No newNo = new No();
        if (recent.getSide() == 1) {
            //diminuir
            if (recent.getMissionario() > 0) {
                newNo.setMissionario(recent.getMissionario() - 1);
                newNo.setCanibal(recent.getCanibal());
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }

            //
            if (recent.getCanibal() > 0) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario());
                newNo.setCanibal(recent.getCanibal() - 1);
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }

            //
            if (recent.getMissionario() > 1) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() - 2);
                newNo.setCanibal(recent.getCanibal());
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }

            //
            if (recent.getCanibal() > 1) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario());
                newNo.setCanibal(recent.getCanibal() - 2);
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }
            //
            if (recent.getMissionario() > 0 && recent.getCanibal() > 0) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() - 1);
                newNo.setCanibal(recent.getCanibal() - 1);
                newNo.setSide(0);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }

        } else {
            //incrementar
            if (recent.getMissionario() < 3) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() + 1);
                newNo.setCanibal(recent.getCanibal());
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }

            //
            if (recent.getCanibal() < 3) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario());
                newNo.setCanibal(recent.getCanibal() + 1);
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }

            //
            if (recent.getMissionario() < 2) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() + 2);
                newNo.setCanibal(recent.getCanibal());
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }

            //
            if (recent.getCanibal() < 2) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario());
                newNo.setCanibal(recent.getCanibal() + 2);
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }
            //
            if (recent.getMissionario() < 3 && recent.getCanibal() < 3) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() + 1);
                newNo.setCanibal(recent.getCanibal() + 1);
                newNo.setSide(1);
                newNo.setDeep(recent.getDeep() + 1);
                recent.getFilhos().add(newNo);
            }
        }
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);

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
            while (i > 5 || j > 5) {
                i = scanner.nextInt();
                j = scanner.nextInt();
                if (i < 6 && j < 6) {
                    if (i < 0 || j < 0) {
                        i = 7;
                        j = 7;
                        System.out.println("Digite novamente");
                    } else {
                        if (goRet % 2 == 0) {
                            if (source[i] == '-' || source[j] == '-') {
                                i = 7;
                                j = 7;
                                System.out.println("Digite novamente, escolha de posicao sem ngm");
                            }
                        } else {
                            if (destiny[i] == '-' || destiny[j] == '-') {
                                i = 7;
                                j = 7;
                                System.out.println("Digite novamente, escolha de posicao sem ngm");
                            }
                        }

                    }
                } else {
                    System.out.println("Digite novamente, posicao invalida");
                }
            }
            cross(i, j);
            goRet++;
            if (rules() == 1) {
                System.out.println("Voce perdeu, numero de Canibais maior que o de missionarios");
                break;
            }
        }
        System.out.println("Parabens, voce venceu!");
    }

    public static void cross(int i, int j) {
        if (goRet % 2 == 0) {
            if (i == j) {
                destiny[i] = source[i];
                if (source[i] == 'M') {
                    nMissionarioSource--;
                    nMissionarioDestiny++;
                } else {
                    nCanibalSource--;
                    nCanibalDestiny++;
                }
                source[i] = '-';

            } else {
                destiny[i] = source[i];
                if (source[i] == 'M') {
                    nMissionarioSource--;
                    nMissionarioDestiny++;
                } else {
                    nCanibalSource--;
                    nCanibalDestiny++;
                }
                source[i] = '-';
                destiny[j] = source[j];
                if (source[j] == 'M') {
                    nMissionarioSource--;
                    nMissionarioDestiny++;
                } else {
                    nCanibalSource--;
                    nCanibalDestiny++;
                }
                source[j] = '-';
            }
        } else {
            if (i == j) {
                source[i] = destiny[i];
                if (destiny[i] == 'M') {
                    nMissionarioDestiny--;
                    nMissionarioSource++;
                } else {
                    nCanibalDestiny--;
                    nCanibalSource++;
                }
                destiny[i] = '-';
            } else {
                source[i] = destiny[i];
                if (destiny[i] == 'M') {
                    nMissionarioDestiny--;
                    nMissionarioSource++;
                } else {
                    nCanibalDestiny--;
                    nCanibalSource++;
                }
                destiny[i] = '-';
                source[j] = destiny[j];
                if (destiny[j] == 'M') {
                    nMissionarioDestiny--;
                    nMissionarioSource++;
                } else {
                    nCanibalDestiny--;
                    nCanibalSource++;
                }
                destiny[j] = '-';
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
            destiny[i] = '-';
        }
    }
}
