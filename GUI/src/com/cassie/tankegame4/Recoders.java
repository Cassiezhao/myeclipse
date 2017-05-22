package com.cassie.tankegame4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by cassie on 2017/5/15.
 * 记录类，同时可以保存玩家的设置
 */
public class Recoders {

    //记录每关有多少敌人
    private static int enNum = 20;
    //设置我有多少可用的坦克
    private static int myLife = 3;
    //记录总共消灭多少敌人
    private  static int allEnNum = 0;
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    //把玩家击毁敌人坦克数量保存到文件中
    public static void keepRecording(){
        try {
            fw = new FileWriter("/Users/cassie/Desktop/myeclipse/GUI/recoder.txt");
            bw = new BufferedWriter(fw);

            bw.write(allEnNum + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                bw.close();
                fw.close();

            }catch (IOException e ){
                e.printStackTrace();
            }

        }

    }

    public static int getAllEnNum() {
        return allEnNum;
    }

    public static void setAllEnNum(int allEnNum) {
        Recoders.allEnNum = allEnNum;
    }


    public static int getMyLife() {
        return myLife;
    }

    public static void setMyLife(int myLife) {
        Recoders.myLife = myLife;
    }

    public static int getEnNum() {
        return enNum;
    }

    public static void setEnNum(int enNum) {
        Recoders.enNum = enNum;
    }
    //减少敌人数量
    public static void reduceEnNum(){
        enNum--;
    }
    //消灭敌人时
    public static void addEnNumRec(){
        allEnNum++;
    }
}
