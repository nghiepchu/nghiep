package quanlisanpham;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
		setBounds(100, 100, 570, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblthongke = new JLabel("TH\u1ED0NG K\u00CA");
		lblthongke.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblthongke.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongke.setBounds(0, 46, 554, 26);
		contentPane.add(lblthongke);
		
		JButton btnSaphet = new JButton("Danh s\u00E1ch s\u1EA3n ph\u1EA9m s\u1EAFp h\u1EBFt");
		btnSaphet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dsspsh info = new dsspsh();
				dsspsh.main(null);
			}
		});
		btnSaphet.setBounds(166, 102, 210, 23);
		contentPane.add(btnSaphet);
		
		JButton btnhet = new JButton("Danh s\u00E1ch s\u1EA3n ph\u1EA9m \u0111\u00E3 h\u1EBFt");
		btnhet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dsspdh info = new dsspdh();
				dsspdh.main(null);
			}
		});
		btnhet.setBounds(166, 155, 210, 23);
		contentPane.add(btnhet);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFrame frmthongke = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmthongke,"Confirm if you want to exit"," ",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}
		}});
		btnExit.setBounds(390, 223, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				danhsachsanpham info = new danhsachsanpham();
				danhsachsanpham.main(null);
			}
		});
		btnBack.setBounds(76, 223, 89, 23);
		contentPane.add(btnBack);
	}
}
