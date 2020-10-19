package tp1;

import java.util.Scanner;

public class Tp1 {

    static No head = new No();
    static No way = new No();
    static boolean validateWay = false;
    static boolean createNo = true;

    public static void main(String[] args) {
        // TODO code application logic here

        head.setHead(3, 3, 1, 0);
        No prev = new No();
        prev.setHead(-1, -1, -1, -1);
        createGraph(head, prev);
    }

    public static void createGraph(No recent, No prev) {
        System.out.println(recent.getMissionario() + "  " + recent.getCanibal() + "  " + recent.getSide() + "  " + recent.getDeep());
        if (!validateWay) {
            if (recent.getMissionario() == 0 && recent.getCanibal() == 0 && recent.getSide() == 0 && !validateWay) {
                //validateWay = true;
                return;
            }
            No newNo = new No();
            if (recent.getSide() == 1 && !validateWay) {
                //diminuir

                if (recent.getMissionario() > 0 && !validateWay) {
                    newNo.setMissionario(recent.getMissionario() - 1);
                    newNo.setCanibal(recent.getCanibal());
                    newNo.setSide(0);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal())) && newNo.getMissionario() >= newNo.getCanibal()) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    }
                }
                //
                if (recent.getCanibal() > 0 && !validateWay) {
                    newNo = new No();
                    newNo.setMissionario(recent.getMissionario());
                    newNo.setCanibal(recent.getCanibal() - 1);
                    newNo.setSide(0);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if (newNo.getMissionario() == 3 && (3 - newNo.getMissionario() <= (3 - newNo.getCanibal()))) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    } else if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    }
                }
                //
                if (recent.getMissionario() > 1 && !validateWay) {
                    newNo = new No();
                    newNo.setMissionario(recent.getMissionario() - 2);
                    newNo.setCanibal(recent.getCanibal());
                    newNo.setSide(0);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if (newNo.getMissionario() > 0) {
                        if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal())) && newNo.getMissionario() >= newNo.getCanibal()) {
                            validateNo(head, newNo);
                            if (createNo) {
                                recent.setFilhos(newNo);
                                createGraph(recent.getFilhos(), recent);
                            }
                            createNo = true;
                        }
                    } else {
                        if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                            validateNo(head, newNo);
                            if (createNo) {
                                recent.setFilhos(newNo);
                                createGraph(recent.getFilhos(), recent);
                            }
                            createNo = true;
                        }
                    }
                }
                //
                if (recent.getCanibal() > 1 && !validateWay) {
                    newNo = new No();
                    newNo.setMissionario(recent.getMissionario());
                    newNo.setCanibal(recent.getCanibal() - 2);
                    newNo.setSide(0);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if (newNo.getMissionario() == 3 && (3 - newNo.getMissionario() <= (3 - newNo.getCanibal()))) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    } else if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    }
                }
                //
                if (recent.getMissionario() > 0 && recent.getCanibal() > 0 && !validateWay) {
                    newNo = new No();
                    newNo.setMissionario(recent.getMissionario() - 1);
                    newNo.setCanibal(recent.getCanibal() - 1);
                    newNo.setSide(0);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if (newNo.getMissionario() < 3 && (3 - newNo.getMissionario() >= (3 - newNo.getCanibal())) && newNo.getMissionario() >= newNo.getCanibal()) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    }
                }
                return;

            } else {
                //
                if (recent.getMissionario() < 3 && !validateWay) {
                    newNo = new No();
                    newNo.setMissionario(recent.getMissionario() + 1);
                    newNo.setCanibal(recent.getCanibal());
                    newNo.setSide(1);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if ((3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                        if (newNo.getMissionario() >= newNo.getCanibal()) {
                            validateNo(head, newNo);
                            if (createNo) {
                                recent.setFilhos(newNo);
                                createGraph(recent.getFilhos(), recent);
                            }
                            createNo = true;
                        }
                    }
                }

                //
                if (recent.getCanibal() < 3 && !validateWay) {
                    newNo = new No();
                    newNo.setMissionario(recent.getMissionario());
                    newNo.setCanibal(recent.getCanibal() + 1);
                    newNo.setSide(1);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if (newNo.getMissionario() >= newNo.getCanibal()) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    } else if (newNo.getMissionario() == 0) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    }
                }

                //
                if (recent.getMissionario() < 2 && !validateWay) {
                    newNo = new No();
                    newNo.setMissionario(recent.getMissionario() + 2);
                    newNo.setCanibal(recent.getCanibal());
                    newNo.setSide(1);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if ((3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                        if (newNo.getMissionario() > newNo.getCanibal()) {
                            validateNo(head, newNo);
                            if (createNo) {
                                recent.setFilhos(newNo);
                                createGraph(recent.getFilhos(), recent);
                            }
                            createNo = true;
                        }
                    }
                }

                //
                if (recent.getCanibal() < 2 && !validateWay) {
                    newNo = new No();
                    newNo.setMissionario(recent.getMissionario());
                    newNo.setCanibal(recent.getCanibal() + 2);
                    newNo.setSide(1);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if (newNo.getMissionario() >= newNo.getCanibal()) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    }
                    if (newNo.getMissionario() == 0) {
                        validateNo(head, newNo);
                        if (createNo) {
                            recent.setFilhos(newNo);
                            createGraph(recent.getFilhos(), recent);
                        }
                        createNo = true;
                    }
                }
                //
                if (recent.getMissionario() < 3 && recent.getCanibal() < 3 && !validateWay) {
                    newNo = new No();
                    newNo.setMissionario(recent.getMissionario() + 1);
                    newNo.setCanibal(recent.getCanibal() + 1);
                    newNo.setSide(1);
                    newNo.setDeep(recent.getDeep() + 1);
                    newNo.setFilhos(null);
                    if ((3 - newNo.getMissionario() >= (3 - newNo.getCanibal()))) {
                        if (newNo.getMissionario() >= newNo.getCanibal()) {
                            validateNo(head, newNo);
                            if (createNo) {
                                recent.setFilhos(newNo);
                                createGraph(recent.getFilhos(), recent);
                            }
                            createNo = true;
                        }
                    }
                }
                return;
            }
        }
        return;
    }

    public static void validateNo(No recent, No newNo) {
        if (newNo.getMissionario() == recent.getMissionario()
                && newNo.getCanibal() == recent.getCanibal()
                && newNo.getSide() == recent.getSide()) {
            createNo = false;
            return;
        }
        if (recent.getFilhos() != null) {
            validateNo(recent.getFilhos(), newNo);
        }
        return;
    }
}
