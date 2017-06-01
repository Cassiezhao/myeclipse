package com.cassie.tankegame4;

import java.io.*;
import java.util.Vector;

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
    private static FileReader fr = null;
    private static BufferedReader br = null;

    private  Vector<EnemyTank> ets = new Vector<EnemyTank>();
   //从文件中恢复记录点
    private static Vector<Node> nodes = new Vector<Node>();

    //完成读取任务
    public Vector<Node> getNodesAndEnNums(){
        try {
            fr = new FileReader("/Users/cassie/Desktop/myeclipse/GUI/recoder.txt");
            br = new BufferedReader(fr);
            String n = " ";
            n = br.readLine();
            allEnNum = Integer.parseInt(n);
            while((n = br.readLine()) != null ){
                String [] xyz = n.split(" ");
//                for(int i = 0; i < xyz.length; i++){
                    Node node = new Node(Integer.parseInt(xyz[0])
                            ,Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
                    nodes.add(node);
//                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodes;
    }
    //保存击毁敌人的数量和敌人坦克坐标、方向
    public void keepRecAndEnemyTank(){
        try{
            fw = new FileWriter("/Users/cassie/Desktop/myeclipse/GUI/recoder.txt");
            bw = new BufferedWriter(fw);

            bw.write(allEnNum + "\r\n");
            //保存当前活的敌人坦克的坐标和方向
            for(int i = 0; i < ets.size(); i++){
                //取出第一个坦克
                EnemyTank et = ets.get(i);
                if (et.isLive){
                    //活的就保存
                    String recorde = et.x + " "+ et.y + " " + et.direct;
                    //写入到文件里
                    bw.write(recorde + "\r\n");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                //后开先关闭
                bw.close();
                fw.close();
            }catch (IOException e ){
                e.printStackTrace();
            }
        }
    }
    //从文件中读取，记录
    public void getRecording(){
        try {
            fr = new FileReader("/Users/cassie/Desktop/myeclipse/GUI/recoder.txt");
            br = new BufferedReader(fr);
            String n = br.readLine();
            allEnNum = Integer.parseInt(n);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
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
                //后开先关闭
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

    public  Vector<EnemyTank> getEts() {
        return ets;
    }

    public  void setEts(Vector<EnemyTank> ets) {
        this.ets = ets;
        System.out.println("ok");
    }
}
