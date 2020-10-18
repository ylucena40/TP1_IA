/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.ArrayList;

/**
 *
 * @author Yanlu
 */
public class No {
    private int missionario;
    private int canibal;
    private int side;
    private int deep;
    private ArrayList<No> filhos;

    public int getMissionario() {
        return missionario;
    }

    public void setMissionario(int missionario) {
        this.missionario = missionario;
    }

    public int getCanibal() {
        return canibal;
    }

    public void setCanibal(int canibal) {
        this.canibal = canibal;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public ArrayList<No> getFilhos() {
        return filhos;
    }
    
    public void setHead(int mis, int can, int side, int deep){
        this.missionario = mis;
        this.canibal = can;
        this.side = side;
        this.deep = deep;
        this.filhos = new ArrayList<No>();
    }
    //teste
}
