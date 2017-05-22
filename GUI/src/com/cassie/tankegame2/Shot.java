package com.cassie.tankegame2;

class Shot implements Runnable{
	int x;
	int y;
	int direct;
	//是否还活着
	boolean isLive = true;
	public Shot(int x, int y,int direct) {
		
		this.x = x;
		this.y = y;
		this.direct = direct;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch (direct) {
			case 0:
				   	//子弹向上
					y-=4;
					break;
			case 1:
					x+=4;
					break;
			case 2:
					y+=4;
					break;
			case 3:
					x-=4;
					break;
			}
			//子弹何时死亡?
			//判断子弹是否碰到边缘
			if(x < 0 || x > 400 || y < 0 ||y >300)
			{
				this.isLive = false;
				break;
			}
			System.out.println("子弹坐标: x ="+ x +" y =" + y );
			
		}
	}
	
}

