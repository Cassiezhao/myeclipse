package com.cassie.tankegame4;

//1、一个类要实现监听的步骤
//a.实现相应的接口 keyListener,MouseListener..
//b.把接口的处理方法根据需要重新编写
//c.在事件源上注册监听
//d.事件传递是靠事件对象

import javax.swing.JFrame;
import javax.swing.JMenu;
/*
* 坦克大战v1.0
* 坦克大战v2.0
* 1、画坦克
* 2、可以上下左右移动
* 3、发射子弹，子弹连发(最多5颗)
* 4、当我的坦克击中敌人的坦克时，敌人就消失(爆炸的效果)
* 5、当敌人的子弹打到我方时，我方消失
* 6、防止敌人的坦克重叠运动✘
*   1）把判断是否碰撞的函数写到enemtank类中
* 7、可以分关打✘
*   1）做一个开始的panel，它是空的
*   2）闪烁效果
* 8、可以暂停和继续玩游戏✘
*   1）当用户点击暂停时，子弹的速度和坦克的速度设为0，让坦克的方向不要变
* 9、可以记录玩家的游戏✘
*   1）用文件流
*		单写一个记录类，完成对玩家记录
*	2）先完成保存共击毁敌人多少辆敌人坦克的功能
* 10、Java如何操作声音文件✘
* */
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tankgame extends JFrame implements ActionListener {

	MyStartPanel msp = null;
	Mypanel mp = null;
	//做出需要的菜单
	JMenuBar jMenuBar1 = null;
	//开始游戏
	JMenu jMenu1 = null;
	JMenuItem jMenuItem1 = null;
	//退出系统
	JMenuItem jMenuItem2 = null;

	public static void main(String[] args) {
		
		Tankgame mtk = new Tankgame();
	}
	
	public Tankgame()
	{

		//创建菜单及菜单选项
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu("游戏(G)");
		//设置快捷方式
		jMenu1.setMnemonic('G');
		jMenuItem1 = new JMenuItem("开始游戏(N)");
		jMenuItem1.setMnemonic('N');
		jMenuItem2 = new JMenuItem("退出游戏(E)");
		jMenuItem2.addActionListener(this);
		jMenuItem2.setActionCommand("exit");
		jMenuItem2.setMnemonic('E');

		jMenu1.add(jMenuItem1);
		jMenu1.add(jMenuItem2);
		jMenuBar1.add(jMenu1);

		jMenuItem1.addActionListener(this);
		jMenuItem1.setActionCommand("newGame");

		msp = new MyStartPanel();
		Thread thread = new Thread(msp);
		thread.start();
		this.setJMenuBar(jMenuBar1);
		this.add(msp);
		this.setSize(600,600);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("newGame")){
			//创建战场面板
			mp = new Mypanel();
			Thread thread = new Thread(mp);
			//启动mp线程
			thread.start();

			//先把之前的msp删掉
			this.remove(msp);
			this.add(mp);

			//注册监听
			this.addKeyListener(mp);
			//显示刷新
			this.setVisible(true);

		}
		else if (e.getActionCommand().equals("exit")){
			//用户点击了推出系统的菜单
			//保存击毁敌人数量
			Recoders.keepRecording();
			System.exit(0);
		}

	}
}

