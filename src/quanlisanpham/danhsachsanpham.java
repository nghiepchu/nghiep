package quanlisanpham;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ketnoicsdl.ketnoicsdl;

import javax.swing.JScrollPane;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class danhsachsanpham<PrepareStatement> {

	private JFrame frame;
	private JTable table;
	private JTextField txtTimkiem;
	
	ketnoicsdl conn = new ketnoicsdl();
	Connection connect = conn.getConnect();
	DefaultTableModel model = new DefaultTableModel();

	private JTextField textTimkiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					danhsachsanpham window = new danhsachsanpham();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public danhsachsanpham() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
		
			
			@Override
			public void windowOpened(WindowEvent e) {
				Showdata();
			}
		});
		frame.setBounds(100, 100, 570, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 534, 150);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnChinhsua = new JButton("Chỉnh sửa");
		btnChinhsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chinhsua info = new chinhsua();
				chinhsua.main(null);
			}
		});
		btnChinhsua.setBounds(10, 250, 104, 23);
		frame.getContentPane().add(btnChinhsua);
		
		JButton btnThongke = new JButton("Thống kê");
		btnThongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongke info = new thongke();
				thongke.main(null);
			}
		});
		btnThongke.setBounds(231, 250, 89, 23);
		frame.getContentPane().add(btnThongke);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JFrame frmdanhsachsanpham = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmdanhsachsanpham,"Confirm if you want to exit"," ",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		}
			);
		btnExit.setBounds(455, 250, 89, 23);
		frame.getContentPane().add(btnExit);
		
		textTimkiem = new JTextField();
		textTimkiem.setBounds(241, 28, 179, 23);
		frame.getContentPane().add(textTimkiem);
		textTimkiem.setColumns(10);
		
		JButton btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {


			         DefaultTableModel model = new DefaultTableModel();
			    	 model.addColumn("Mã sản phẩm");
			    	 model.addColumn("Tên sản phẩm");
			    	 model.addColumn("Xuất xứ");
			    	 model.addColumn("Số lượng (Kg)");
			    	 model.addColumn("Giá tiền (Vnd)");
			         try {
			        	 String query = "select * from dbo.QLSP where Xuatxu";
			             Statement st = connect.createStatement();
			        	 ResultSet rs = st.executeQuery(query);

			        	 while (rs.next()) {
			        		
			        			 model.addRow(new Object[] {
			            				 
			            				 rs.getString("MaSP"),
			            				 rs.getString("TenSP"),
			            				 rs.getString("XuatXu"),
			            				 rs.getString("Soluong"),
			            				 rs.getString("Giatien"),
			            		 });		 
			        	 }
			        	  rs.close();
			        	  st.close();
			              connect.close();
			            	 table.setModel(model);
			        	     table.setAutoResizeMode(1);
			         }
			         catch (Exception e1) {

			        	System.out.println("Lỗi " + e1);
			         }

				} catch ( Exception e1) {
			    	e1.printStackTrace();
				}
				
			}
		});
		btnTimkiem.setBounds(430, 28, 89, 23);
		frame.getContentPane().add(btnTimkiem);
		
	}	
	

public void Showdata() {

	try {


         DefaultTableModel model = new DefaultTableModel();
    	 model.addColumn("Mã sản phẩm");
    	 model.addColumn("Tên sản phẩm");
    	 model.addColumn("Xuất xứ");
    	 model.addColumn("Số lượng (Kg)");
    	 model.addColumn("Giá tiền (Vnd)");
         try {
        	 String query = "select * from dbo.QLSP";
             Statement st = connect.createStatement();
        	 ResultSet rs = st.executeQuery(query);

        	 while (rs.next()) {
        		
        			 model.addRow(new Object[] {
            				 
            				 rs.getString("MaSP"),
            				 rs.getString("TenSP"),
            				 rs.getString("XuatXu"),
            				 rs.getString("Soluong"),
            				 rs.getString("Giatien"),
            		 });		 
        	 }
        	  rs.close();
        	  st.close();
              connect.close();
            	 table.setModel(model);
        	     table.setAutoResizeMode(1);
         }
         catch (Exception e) {

        	System.out.println("Lỗi " + e);
         }

	} catch ( Exception e) {
    	e.printStackTrace();
	}
}
}

