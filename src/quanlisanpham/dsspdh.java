package quanlisanpham;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ketnoicsdl.ketnoicsdl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dsspdh extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ketnoicsdl conn = new ketnoicsdl();
	Connection connect = conn.getConnect();






	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dsspdh frame = new dsspdh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dsspdh() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Showdata();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldahet = new JLabel("DANH S\u00C1CH S\u1EA2N PH\u1EA8M \u0110\u00C3 H\u1EBET");
		lbldahet.setHorizontalAlignment(SwingConstants.CENTER);
		lbldahet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldahet.setBounds(0, 23, 554, 25);
		contentPane.add(lbldahet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 534, 150);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongke info = new thongke();
				thongke.main(null);
			}
		});
		btnBack.setBounds(10, 252, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmdsspdh = new JFrame("Exit");
		
				if(JOptionPane.showConfirmDialog(frmdsspdh,"Confirm if you want to exit"," ",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}
		}});
		btnExit.setBounds(455, 252, 89, 23);
		contentPane.add(btnExit);
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
            		 if(Integer.parseInt(rs.getString("Soluong")) == 0 ){
            			 model.addRow(new Object[] {
                				 
                				 rs.getString("MaSP"),
                				 rs.getString("TenSP"),
                				 rs.getString("XuatXu"),
                				 rs.getString("Soluong"),
                				 rs.getString("Giatien"),
                		 });
            		 }
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