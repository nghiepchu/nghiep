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

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dsspsh extends JFrame {

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
					dsspsh frame = new dsspsh();
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
	public dsspsh() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Showdata();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblsaphet = new JLabel("DANH S\u00C1CH S\u1EA2N PH\u1EA8M S\u1EAEP H\u1EBET");
		lblsaphet.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblsaphet.setHorizontalAlignment(SwingConstants.CENTER);
		lblsaphet.setBounds(0, 23, 634, 25);
		contentPane.add(lblsaphet);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 614, 150);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnBack = new JButton("Back");
		Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();

		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				thongke info = new thongke();
				thongke.main(null);
				dispose();
			}
		});
		btnBack.setBounds(79, 253, 89, 23);
		contentPane.add(btnBack);

		JButton btnExit = new JButton("Exit");
		Image img1 = new ImageIcon(this.getClass().getResource("/thoat.png")).getImage();

		btnExit.setIcon(new ImageIcon(img1));
		btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frmdsspsh = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmdsspsh, "Confirm if you want to exit",
						"DANH SÁCH SẢN PHẨM SẮP HẾT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(455, 253, 89, 23);
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

				int x = 0;
				while (rs.next()) {

					if (Integer.parseInt(rs.getString("Soluong")) <= 10
							&& Integer.parseInt(rs.getString("Soluong")) != 0) {
						model.addRow(new Object[] { rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("XuatXu"),
								rs.getString("Soluong"), rs.getString("Giatien"), });
						x++;
					}

				}
				if(x == 0) {
					JOptionPane.showMessageDialog(null, "Không có sản phẩm nào sắp hết");
				}
				rs.close();
				st.close();
				connect.close();
				table.setModel(model);
				table.setAutoResizeMode(1);

			} catch (Exception e) {

				System.out.println("Lỗi " + e);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}
}
