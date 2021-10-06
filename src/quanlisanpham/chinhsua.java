package quanlisanpham;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class chinhsua extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chinhsua frame = new chinhsua();
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
	public chinhsua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CH\u1EC8NH S\u1EECA");
	
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 41, 634, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnThem = new JButton("Th\u00EAm");
		 Image img4 = new ImageIcon(this.getClass().getResource("/them.png")).getImage();
			
			btnThem.setIcon(new ImageIcon(img4));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them info = new them();
				them.main(null);
				dispose();
			}
		});
		btnThem.setBounds(255, 89, 139, 23);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("S\u1EEDa");
		Image img = new ImageIcon(this.getClass().getResource("/sua.png")).getImage();
		
		btnSua.setIcon(new ImageIcon(img));
		 
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sua info = new Sua();
				Sua.main(null);
				dispose();
			}
		});
		btnSua.setBounds(255, 139, 139, 23);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("X\u00F3a");
		 Image img1 = new ImageIcon(this.getClass().getResource("/xoa.png")).getImage();
			
			btnXoa.setIcon(new ImageIcon(img1));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xoa info = new Xoa();
				Xoa.main(null);
				dispose();
			}
		});
		btnXoa.setBounds(255, 189, 139, 23);
		contentPane.add(btnXoa);
		
		JButton btnBack = new JButton("Back");
		 Image img2 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
			
			btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				danhsachsanpham info = new danhsachsanpham();
				danhsachsanpham.main(null);
				dispose();
			}
		});
		btnBack.setBounds(93, 242, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		 Image img3 = new ImageIcon(this.getClass().getResource("/thoat.png")).getImage();
			
			btnExit.setIcon(new ImageIcon(img3));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmchinhsua = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(frmchinhsua,"Confirm if you want to exit"," CHỈNH SỬA ",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}}
		});
		btnExit.setBounds(455, 242, 89, 23);
		contentPane.add(btnExit);
	}
}
