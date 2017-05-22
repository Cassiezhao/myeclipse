package com.cassie.tankegame3;

//1、一个类要实现监听的步骤
//a.实现相应的接口 keyListener,MouseListener..
//b.把接口的处理方法根据需要重新编写
//c.在事件源上注册监听
//d.事件传递是靠事件对象

import javax.swing.JFrame;
/*
* 坦克大战v1.0
* 坦克大战v2.0
* 1、画坦克
* 2、可以上下左右移动
* 3、发射子弹，子弹连发(最多5颗)
* 4、当我的坦克击中敌人的坦克时，敌人就消失(爆炸的效果)
* 5、当敌人的子弹打到我方时，我方消失
* */
public class Tankgame extends JFrame {
	Mypanel mp;
	public static void main(String[] args) {
		
		Tankgame mtk = new Tankgame();
	}
	
	public Tankgame()
	{
		mp = new Mypanel();
		this.add(mp);
		//启动mp线程
		Thread thread = new Thread(mp);
		thread.start();
		//注册监听
		this.addKeyListener(mp);
		this.setSize(400,400);
		this.setVisible(true);
		
	}
}

