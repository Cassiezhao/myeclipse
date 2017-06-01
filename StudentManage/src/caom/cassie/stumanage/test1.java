/**
 * Jtable使用
 */
package caom.cassie.stumanage;

import java.util.Vector;

import javax.print.attribute.standard.JobSheets;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author cassie
 *
 */
public class test1 extends JFrame{
	Vector rowData,columnNames;
	JTable jt = null;
	JScrollPane jsp = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1 test = new test1();
	}
	public test1() {
		columnNames = new Vector();
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("年龄");
		columnNames.add("性别");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		rowData = new Vector();
		Vector hang = new Vector();
		hang.add("S01");
		hang.add("张三");
		hang.add("50");
		hang.add("男");
		hang.add("陕西");
		hang.add("会计");
		rowData.add(hang);
		
		jt = new JTable(rowData,columnNames);
		
		jsp = new JScrollPane(jt);
		
		this.add(jsp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}
