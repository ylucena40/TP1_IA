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
        search();
    }
    
    public static void search(){
        No prev = new No();
        prev.setHead(-1, -1, -1, -1);
        for(int i = 0; i < profMax; i++){
            System.out.println("Prof: " + i);
            System.out.println("---------------");
            createGraph(head, prev,i);
            System.out.println("---------------");
        }
    }

    public static void createGraph(No recent, No prev, int prof) {
        System.out.println(recent.getMissionario() + "  " + recent.getCanibal() + "  " + recent.getSide() + "  " + recent.getDeep());
        if(prof == recent.getDeep()){
            return;
        }
        if (recent.getMissionario() == 0 && recent.getCanibal() == 0 && recent.getSide() == 0) {
            return;
        }
        No newNo = new No();
        if (recent.getSide() == 1) {
            //diminuir

            if (recent.getMissionario() > 0) {
                newNo.setMissionario(recent.getMissionario() - 1);
                newNo.setCanibal(recent.getCanibal());
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
            //
            if (recent.getCanibal() > 0) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario());
                newNo.setCanibal(recent.getCanibal() - 1);
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
            //
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
            //
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
            //
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
            //
            if (recent.getMissionario() < 3) {
                newNo = new No();
                newNo.setMissionario(recent.getMissionario() + 1);
                newNo.setCanibal(recent.getCanibal());
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

            //
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

            //
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

            //
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
            //
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

    public static void validateNo(No recent, No newNo) {
        if (newNo.getMissionario() == 0
                && newNo.getCanibal() == 0
                && newNo.getSide() == 0) {
            return;
        }
        if (newNo.getMissionario() == recent.getMissionario()
                && newNo.getCanibal() == recent.getCanibal()
                && newNo.getSide() == recent.getSide()) {
            if (newNo.getDeep() > recent.getDeep()) {
                createNo = false;
            }
            return;
        }
        if (recent.getFilhos() != null) {
            for (int i = 0; i < recent.getFilhos().size(); i++) {
                validateNo(recent.getFilhos().get(i), newNo);
            }
        }
        return;
    }
}
