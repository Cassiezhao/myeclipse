package com.cassie.tankegame4;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

//我的面板
class Mypanel extends JPanel implements KeyListener,Runnable
{
	//定义一个我的坦克
	Hero hero = null;
	//判断是继续上局还是新游戏
//	String flag = "newGame";
	//定义敌人的坦克组
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	Vector<Node> nodes = new Vector<Node>();
	int enSize = 3;
	
	//定义一个炸弹集合
	Vector<Bomb> bombs = new Vector<Bomb>();
	
	//定义三张图片
	//三张图片组成一颗炸弹
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	
	public Mypanel(String flag)
	{
		//恢复记录
		new Recoders().getRecording();

		hero = new Hero(200, 300);

		if (flag.equals("newGame")) {

			for (int i = 0; i < enSize; i++) {
				//创建一个敌人的坦克，并加入
				EnemyTank et = new EnemyTank((i + 1) * 50, 0);
				et.setColor(1);
				et.setDirect(2);

				//将Mypanel的敌人坦克向量交给该敌人坦克
				et.setEts(ets);

				//启动敌人的坦克
				Thread t = new Thread(et);
				t.start();

				//给敌人的坦克添加一个子弹
				Shot s = new Shot(et.x + 10, et.y + 30, 2);
				et.ss.add(s);

				Thread t2 = new Thread(s);
				t2.start();
				ets.add(et);
			}
		}else{

			System.out.print("continue");
			nodes = new Recoders().getNodesAndEnNums();
			for (int i = 0; i < nodes.size(); i++) {
				Node node = nodes.get(i);
				EnemyTank et = new EnemyTank(node.x, node.y);
				et.setColor(1);
				et.setDirect(node.direct);
				et.setEts(ets);
				//启动敌人的坦克
				Thread t = new Thread(et);
				t.start();

				//给敌人的坦克添加一个子弹
				Shot s = new Shot(et.x + 10, et.y + 30, 2);
				et.ss.add(s);

				Thread t2 = new Thread(s);
				t2.start();
				ets.add(et);
			}
		}
		AePlayWave apw = new AePlayWave("/Users/cassie/Desktop/myeclipse/GUI/src/7301.wav");
		apw.start();
		//初始化图片
//		image1 = Toolkit.getDefaultToolkit().
//					getImage(Panel.class.getResource("/6.jpg"));
//		image2 = Toolkit.getDefaultToolkit().
//					getImage(Panel.class.getResource("/5.jpg"));
//		image3 = Toolkit.getDefaultToolkit().
//					getImage(Panel.class.getResource("/4.png"));
		try {
			image1 = ImageIO.read(new File("/Users/cassie/Desktop/myeclipse/GUI/src/6.jpg"));
			image2 = ImageIO.read(new File("/Users/cassie/Desktop/myeclipse/GUI/src/5.jpg"));
			image3 = ImageIO.read(new File("/Users/cassie/Desktop/myeclipse/GUI/src/4.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//画一个坦克
	public void drawTank(int x,int y,Graphics g,int direct,int type) 
	{
		
		switch (type) 
		{
			case 0:
					g.setColor(Color.CYAN);
					break;
			case 1:
					g.setColor(Color.yellow);
					break;
		}
		//判断方向
		switch (direct) 
		{
			case 0://向上
				//画出我的坦克
				//1、画出左面的矩形
				g.fill3DRect(x, y, 5, 30, false);
				//2、画出右边的矩形
				g.fill3DRect(x + 15, y, 5, 30, false);
				//3、画出中间矩形
				g.fill3DRect(x + 5, y+5, 10, 20, false);
				//4、画出圆形
				g.fillOval(x + 5, y + 10, 10, 10);
				//5、画出线
				g.drawLine(x + 10, y + 20, x + 10, y);
				break;
				
			case 1://向右
				//画出我的坦克
				//1、画出上面的矩形
				g.fill3DRect(x, y, 30, 5, false);
				//2、画出下面的矩形
				g.fill3DRect(x , y + 15, 30, 5, false);
				//3、画出中间矩形
				g.fill3DRect(x + 5, y + 5, 20, 10, false);
				//4、画出圆形
				g.fillOval(x + 10, y + 5, 10, 10);
				//5、画出线
				g.drawLine(x + 15, y + 10, x + 30, y + 10);
				break;
			case 2://向下
				//画出我的坦克
				//1、画出左面的矩形
				g.fill3DRect(x, y, 5, 30, false);
				//2、画出右边的矩形
				g.fill3DRect(x + 15, y, 5, 30, false);
				//3、画出中间矩形
				g.fill3DRect(x + 5, y+5, 10, 20, false);
				//4、画出圆形
				g.fillOval(x + 5, y + 10, 10, 10);
				//5、画出线
				g.drawLine(x + 10, y + 15, x + 10, y + 30);
				break;
			case 3://向左
				//画出我的坦克
				//1、画出上面的矩形
				g.fill3DRect(x, y, 30, 5, false);
				//2、画出下面的矩形
				g.fill3DRect(x , y + 15, 30, 5, false);
				//3、画出中间矩形
				g.fill3DRect(x + 5, y + 5, 20, 10, false);
				//4、画出圆形
				g.fillOval(x + 10, y + 5, 10, 10);
				//5、画出线
				g.drawLine(x + 15, y + 10, x , y + 10);
				break;
		}
		
	}

	//画出提示信息
	public void showinfo(Graphics g){
			//画出提示信息坦克（该坦克不参与战斗）
		this.drawTank(80,420,g,0,0);
		g.setColor(Color.black);
		g.drawString( Recoders.getEnNum() + "",110,440);

		this.drawTank(140,420,g,0,1);
		g.setColor(Color.black);
		g.drawString(Recoders.getMyLife()+"",170,440);

		//画出玩家的总成绩
		g.setColor(Color.black);
		Font f =new Font("宋体", Font.BOLD,20);
		g.setFont(f);
		g.drawString("您的总成绩",420,30);
		this.drawTank(420,60,g,0,0);
		g.setColor(Color.black);
		g.drawString(Recoders.getAllEnNum() + "",460,80);
	}
	
	//重写paint函数
	public void paint (Graphics g)
	{	
		super.paint(g);
		//画出提示信息
		this.showinfo(g);

		g.fillRect(0, 0, 400, 400);


		//画出自己的坦克
		if (hero.isLive) 
		{
			this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 0);		
		}
		
		
		//从SS中取出每一颗子弹并画出
		for(int i = 0; i < hero.ss.size(); i ++)
		{
			Shot myshot = hero.ss.get(i);
			//画出子弹，画出一颗子弹
			if (myshot != null && myshot.isLive == true) 
			{
				
				g.draw3DRect(myshot.x , myshot.y , 1, 1, false);
				//System.out.println("第 " + i + "颗子弹" );
				
			}
			if (myshot.isLive == false) {
				
				hero.ss.remove(myshot);
			}
		}
		
		//画出炸弹
		for (int i = 0; i < bombs.size(); i++) 
		{
			//System.out.println("bombs.size() = " + bombs.size());
			//取出炸弹 
			Bomb b = bombs.get(i);
			
			if (b.life > 6) {
				g.drawImage(image1, b.x, b.y, 30, 30, this);
			}
			else if (b.life > 4) {
				g.drawImage(image2, b.x, b.y, 30, 30, this);
			}
			else {
				g.drawImage(image3, b.x, b.y, 30, 30, this);
			}
			//画过一次让bomb生命值减小
			b.lifeDown();
			//如果炸弹生命值为0，就把炸弹去掉
			if (b.life == 0) 
			{
				bombs.remove(b);
			}
		}
		
		//画出敌人的坦克
		for (int i = 0; i < ets.size(); i++) 
		{
			EnemyTank et = ets.get(i);
			
			if (et.isLive) 
			{
				this.drawTank(et.getX(), et.getY(),
						g, et.getDirect(), 1);
				for (int j = 0; j < et.ss.size(); j++) 
				{
					//取出子弹
					Shot enemyShot = et.ss.get(j);
					if (enemyShot.isLive) 
					{
						g.draw3DRect(enemyShot.x , enemyShot.y , 1, 1, false);
					}
					else {
						
						//如果敌人的坦克死亡了，就从Vector中删除
						et.ss.remove(enemyShot);		
					}
				}
			}
			
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub、
		//键按下处理a表示向左 s表示下 w 上 d右
		//0表示上 1表示右 2 表示下  3表示左
		if (e.getKeyCode() == KeyEvent.VK_W) {
			
			//设置我的坦克的方向
			this.hero.setDirect(0);
			this.hero.moveUp();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			this.hero.setDirect(1);
			this.hero.moveRight();
		}
		else if (e.getKeyCode() == KeyEvent.VK_S)
		{
			this.hero.setDirect(2);
			this.hero.moveDown();	
		}
		else if (e.getKeyCode() == KeyEvent.VK_A)
		{
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_J)
		{
			//判断玩家是否按下j
			//开火
			if(this.hero.ss.size() < 5)
			{
				this.hero.shotEnemy();
			}
			
			
		}
		
		//必须重新绘制panel，调用repaint()函数
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//判断子弹是否击中敌人坦克
	public boolean hitTank(Shot s, Tank et)
	{
		boolean flag  =false;
		//判断该坦克的方向
		switch (et.direct)
		{
			//方向是上或是下
			case 0:
			case 2:
				if (s.x >= et.x && s.x <= et.x + 20 &&
						s.y >= et.y && s.y <= et.y + 30)
				{
					//击中
					//子弹死亡
					s.isLive = false;
					//敌人坦克死亡
					et.isLive = false;
					flag = true;
//					//减少敌人数量
//					Recoders.reduceEnNum();
//					//增加我的记录
//					Recoders.addEnNumRec();
					//创建一颗炸弹
					Bomb b = new Bomb(et.x, et.y);
					//放入Vector
					bombs.add(b);
				}
				break;
			case 1:
			case 3:
				if (s.x >= et.x && s.x <= et.x + 30 &&
						s.y >= et.y && s.y <= et.y + 20)
				{
					//击中
					//子弹死亡
					s.isLive = false;
					//敌人坦克死亡
					et.isLive = false;
					flag = true;
//					//减少敌人数量
//					Recoders.reduceEnNum();
//					//增加我的记录
//					Recoders.addEnNumRec();
					//创建一颗炸弹
					Bomb b = new Bomb(et.x, et.y);
					//放入Vector
					bombs.add(b);
				}

		}
		return flag;
	}

	//判断敌人的子弹是否击中我
	public void hitMe() 
	{
		for (int i = 0; i < this.ets.size(); i++) 
		{
			//取出敌人的坦克
			EnemyTank et = ets.get(i);
			//取出每一颗子弹
			for (int j = 0; j < et.ss.size(); j++) 
			{
				Shot enemyShot = et.ss.get(j);
				if (hero.isLive) {
					if (this.hitTank(enemyShot, hero)){
						//敌人坦克击中了我
					}

				}
			}
		}
	}

	//判断我的子弹是否击中敌人的坦克
	public void hitEnemyTank() 
	{
		//判断是否击中敌人的坦克
		for (int i = 0; i < hero.ss.size(); i++) 
		{
			//取出子弹
			Shot myShot = hero.ss.get(i);
			//判断子弹是否有效
			if (myShot.isLive)
			{
				//取出每一个敌人坦克，与它判断
				for (int j = 0; j < ets.size(); j++) 
				{
					EnemyTank et = ets.get(j);
					if (et.isLive) {
						if (this.hitTank(myShot, et)) {
							//我的坦克击中了敌人
							//减少敌人数量
							Recoders.reduceEnNum();
							//增加我的记录
							Recoders.addEnNumRec();
						}
					}
				}
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.hitEnemyTank();
			//判断敌人的子弹是否击中我
			this.hitMe();
			this.repaint();
			
			//判断是否需要给坦克加入新的子弹
			for (int i = 0; i < ets.size(); i++) {
				EnemyTank et = ets.get(i);
				if (et.isLive) {
					if (et.ss.size() < 5) {
						
						Shot s = null;
						//没有子弹，添加
						switch (et.direct) 
						{
							case 0:
								//创建一颗子弹
							  	s = new Shot(et.x + 10, et.y, 0);
							  	//把子弹加入向量
							  	et.ss.add(s);
							  	try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							  	break;
							case 1:
								s = new Shot(et.x + 30, et.y + 10, 1);
								et.ss.add(s);
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							case 2:
								s = new Shot(et.x + 10, et.y +30, 2);
								et.ss.add(s);
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							case 3:
								s = new Shot(et.x, et.y + 10, 3);
								et.ss.add(s);
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
						}
						Thread thread = new Thread(s);
						thread.start();
					}
				}
			}
			
		}
	}
}


