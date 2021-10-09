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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Xoa extends JFrame {

	private JPanel contentPane;
	private JTextField textmsp;
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
					Xoa frame = new Xoa();
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
	public Xoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblxoa = new JLabel("X\u00D3A TH\u00D4NG TIN S\u1EA2N PH\u1EA8M");
		lblxoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblxoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblxoa.setBounds(0, 27, 634, 24);
		contentPane.add(lblxoa);

		JLabel lblmsp = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m");
		lblmsp.setBounds(137, 100, 94, 24);
		contentPane.add(lblmsp);

		textmsp = new JTextField();
		textmsp.setBounds(273, 102, 171, 20);
		contentPane.add(textmsp);
		textmsp.setColumns(10);

		JButton btnXoa = new JButton("X\u00F3a");
		Image img = new ImageIcon(this.getClass().getResource("/xoa.png")).getImage();

		btnXoa.setIcon(new ImageIcon(img));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connect = conn.getConnect();
				try {

					String query1 = "select * from dbo.QLSP";
					Statement st = connect.createStatement();
					ResultSet rs1 = st.executeQuery(query1);

					if (textmsp.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nhập Mã sản phẩm muốn xóa !");
					} else {
						int x = 0;
						while (rs1.next()) {
							if (rs1.getString("MaSP").equals(textmsp.getText().toString())) {
								x++;
							}
						}
						if (x == 0) {
							JOptionPane.showMessageDialog(null, "Mã sản phẩm không tồn tại! Vui lòng nhập lại");
						} else if (x != 0) {
							String query = "Delete from dbo.QLSP where  MaSP='" + textmsp.getText() + "' ";
							PreparedStatement pst = connect.prepareStatement(query);

							int rs = pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Xóa thành công!");
							pst.close();
							connect.close();
						}

					}
				}

				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnXoa.setBounds(281, 246, 89, 23);
		contentPane.add(btnXoa);

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
		btnBack.setBounds(56, 246, 89, 23);
		contentPane.add(btnBack);

		JButton btnExit = new JButton("Exit");
		Image img2 = new ImageIcon(this.getClass().getResource("/thoat.png")).getImage();

		btnExit.setIcon(new ImageIcon(img2));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmxoa = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmxoa, "Confirm if you want to exit", "XÓA ",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(486, 246, 89, 23);
		contentPane.add(btnExit);
	}

}
