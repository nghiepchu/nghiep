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
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Sua extends JFrame {

	private JPanel contentPane;
	private JTextField textmsp;
	private JTextField texttsp;
	private JTextField textxx;
	private JTextField textsl;
	private JTextField textgt;
	ketnoicsdl conn = new ketnoicsdl();
	Connection connect = conn.getConnect();
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sua frame = new Sua();
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
	public Sua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblsua = new JLabel("S\u1EECA TH\u00D4NG TIN S\u1EA2N PH\u1EA8M");
		lblsua.setHorizontalAlignment(SwingConstants.CENTER);
		lblsua.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblsua.setBounds(10, 25, 634, 26);
		contentPane.add(lblsua);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m");
		lblNewLabel.setBounds(179, 76, 117, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lbltsp = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m");
		lbltsp.setBounds(179, 113, 117, 26);
		contentPane.add(lbltsp);
		
		JLabel lblxx = new JLabel("Xu\u1EA5t X\u1EE9");
		lblxx.setBounds(179, 150, 117, 26);
		contentPane.add(lblxx);
		
		JLabel lblsl = new JLabel("S\u1ED1 l\u01B0\u1EE3ng (Kg)");
		lblsl.setBounds(179, 187, 117, 26);
		contentPane.add(lblsl);
		
		JLabel lblgt = new JLabel("Gi\u00E1 ti\u1EC1n (Vnd)");
		lblgt.setBounds(179, 224, 117, 26);
		contentPane.add(lblgt);
		
		textmsp = new JTextField();
		textmsp.setBounds(288, 76, 170, 20);
		contentPane.add(textmsp);
		textmsp.setColumns(10);
		
		texttsp = new JTextField();
		texttsp.setColumns(10);
		texttsp.setBounds(288, 116, 170, 20);
		contentPane.add(texttsp);
		
		textxx = new JTextField();
		textxx.setColumns(10);
		textxx.setBounds(288, 153, 170, 20);
		contentPane.add(textxx);
		
		textsl = new JTextField();
		textsl.setColumns(10);
		textsl.setBounds(288, 190, 170, 20);
		contentPane.add(textsl);
		
		textgt = new JTextField();
		textgt.setColumns(10);
		textgt.setBounds(288, 227, 170, 20);
		contentPane.add(textgt);
		
		JButton btnSua = new JButton("S\u1EEDa");
		 Image img = new ImageIcon(this.getClass().getResource("/sua.png")).getImage();
			
			btnSua.setIcon(new ImageIcon(img));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connect = conn.getConnect();
				  try {
		            	 String query = "Update dbo.QLSP set MaSP='"+textmsp.getText()+"' ,TenSP='"+texttsp.getText()+"' ,XuatXu= '"+textxx.getText()+"'  ,Soluong= '"+textsl.getText()+"' ,Giatien= '"+textgt.getText()+"' where MaSP='"+textmsp.getText()+"'  ";
		                 Statement st = connect.createStatement();
		            	
		                 int rs = st.executeUpdate(query);
		                 JOptionPane.showMessageDialog(null, "Sửa thành công!");
		            	
		            	  st.close();
		            	  connect.close();
		            
		             }
			         catch ( Exception e1) {
		        	  e1.printStackTrace();
				}
			}
			
			
		});
		btnSua.setBounds(283, 281, 89, 23);
		contentPane.add(btnSua);
		
		JButton btnBack = new JButton("Back");
		 Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
			
			btnBack.setIcon(new ImageIcon(img1));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				danhsachsanpham info = new danhsachsanpham();
				danhsachsanpham.main(null);
				dispose();
			}
		});
		btnBack.setBounds(71, 281, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		 Image img2 = new ImageIcon(this.getClass().getResource("/thoat.png")).getImage();
			
			btnExit.setIcon(new ImageIcon(img2));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmsua = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmsua,"Confirm if you want to exit"," SỬA",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(474, 281, 89, 23);
		contentPane.add(btnExit);
	}

}
