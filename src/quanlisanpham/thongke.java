package quanlisanpham;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class thongke extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongke frame = new thongke();
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
	public thongke() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblthongke = new JLabel("TH\u1ED0NG K\u00CA");
		lblthongke.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongke.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongke.setBounds(0, 37, 634, 26);
		contentPane.add(lblthongke);
		
		JButton btnSaphet = new JButton("Danh s\u00E1ch s\u1EA3n ph\u1EA9m s\u1EAFp h\u1EBFt");
		 Image img = new ImageIcon(this.getClass().getResource("/thongke.png")).getImage();
			
			btnSaphet.setIcon(new ImageIcon(img));
		btnSaphet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dsspsh info = new dsspsh();
				dsspsh.main(null);
				dispose();
			}
		});
		btnSaphet.setBounds(215, 102, 251, 23);
		contentPane.add(btnSaphet);
		
		JButton btnhet = new JButton("Danh s\u00E1ch s\u1EA3n ph\u1EA9m \u0111\u00E3 h\u1EBFt");
		 Image img2 = new ImageIcon(this.getClass().getResource("/thongke.png")).getImage();
			
			btnhet.setIcon(new ImageIcon(img2));
		btnhet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dsspdh info = new dsspdh();
				dsspdh.main(null);
				dispose();
			}
		});
		btnhet.setBounds(215, 155, 251, 23);
		contentPane.add(btnhet);
		
		JButton btnExit = new JButton("Exit");
		 Image img4 = new ImageIcon(this.getClass().getResource("/thoat.png")).getImage();
			
			btnExit.setIcon(new ImageIcon(img4));
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFrame frmthongke = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmthongke,"Confirm if you want to exit","THỐNG KÊ",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}
		}});
		btnExit.setBounds(471, 223, 89, 23);
		contentPane.add(btnExit);
		
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
		btnBack.setBounds(76, 223, 89, 23);
		contentPane.add(btnBack);
	}
}
