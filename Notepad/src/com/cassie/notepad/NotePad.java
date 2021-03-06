/**
 * 
 */
package com.cassie.notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 * @author cassie
 * @fun notepad
 */
public class NotePad extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	//定义需要的组件
	JTextArea jta = null;
	//定义菜单条
	JMenuBar jmb = null;
	//第一JMenu
	JMenu jm1 = null;

	//定义JMenuItem
	JMenuItem jmi1 = null;
	JMenuItem jmi2 = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad nPad = new NotePad();
	}
	public NotePad()
	{
		//创建jta
		jta = new JTextArea();
		jmb = new JMenuBar();
		jm1 = new JMenu("文件");
		jm1.setMnemonic('F');
		
		jmi1 = new JMenuItem("打开");
		//注册监听
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		
		jmi2 = new JMenuItem("保存");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		
		this.setJMenuBar(jmb);

		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);
		
		//放入到Jframe
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
	}
	@Override
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断是哪个菜单被选中
		if (e.getActionCommand().equals("open")) 
		{
			//System.out.println("open");
			
			//JFileChooser文件选择组件
			JFileChooser jfc1 = new JFileChooser();
			//设置名字
			jfc1.setDialogTitle("请选择文件...");
			//默认方式
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			
			//得到用户选择的文件路径
			String filename = jfc1.getSelectedFile().getAbsolutePath();
			//System.out.println(filename);
			FileReader fReader = null;
			BufferedReader bReader = null;
			//BufferedWriter bWriter = null;
			try {
				fReader = new FileReader(filename);
				bReader = new BufferedReader(fReader);
				
				//从文件中读取信息并显示到JTextArea
				String string = " ";
				String resString  =  " ";
				while ((string= bReader.readLine()) != null){
					
					resString += string + "\r\n";
					
				}
				//放置到jta
				jta.setText(resString);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally {
				try {
					bReader.close();
					fReader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
		else if (e.getActionCommand().equals("save")) 
		{
			//出现保存对话框
			JFileChooser jfc2 = new JFileChooser();
			jfc2.setDialogTitle("另存为...");
			//按默认的方式显示
			jfc2.showSaveDialog(null);
			jfc2.setVisible(true);
			//得到用户希望把文件保存到何处，文件全路径
			String filename2 = jfc2.getSelectedFile().getAbsolutePath();
			//准备写入到指定文件
			FileWriter fWriter = null;
			BufferedWriter bWriter = null;
			
			try {
				fWriter = new FileWriter(filename2);
				bWriter = new BufferedWriter(fWriter);
				bWriter.write(this.jta.getText());
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally {
				try {
					bWriter.close();
					fWriter.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		} 
	}
}
