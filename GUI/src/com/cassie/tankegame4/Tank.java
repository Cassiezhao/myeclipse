package com.cassie.tankegame4;
//坦克类
public class Tank
{
		//表示坦克的横坐标
		int x = 0;
		//表示坦克的纵坐标
		int y = 0;
		
		//坦克方向
		//0表示上 1表示右 2 表示下  3表示左
		int direct = 0;
		
		//设置坦克的速度
		static int speed = 2;
		
		//颜色区分敌我
		int color ;
		boolean isLive = true;
		public int getColor() {
			return color;
		}

		public void setColor(int color) {
			this.color = color;
		}

		public int getSpeed() {
			return speed;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}

		public int getDirect() {
			return direct;
		}

		public void setDirect(int direct) {
			this.direct = direct;
		}

		public Tank (int x,int y) 
		{
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}	
		
}

