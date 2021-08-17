import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class JavaCrud {

	private JFrame frame;
	private JTextField txtbname;
	private JTextField txtedition;
	private JTextField txtprice;
	private JTable table;
	private JTextField textField_3;
	private JTextField txtbid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
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
	public JavaCrud() {
		initialize();
		Connect();
		table_load();
	}
	
	
	



Connection con;
	PreparedStatement pst;
	ResultSet rs;
 
	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root","");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	        	   ex.printStackTrace();
	        }
 
	    }
	 
	 
	 
	 
	 
public void table_load()
	    {
	    	try 
	    	{
		    pst = con.prepareStatement("select * from booktable");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
	 
	 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 904, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Store");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(331, 26, 173, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(35, 84, 326, 134);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 30, 103, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Edition");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 66, 55, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Price");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 99, 65, 14);
		panel.add(lblNewLabel_1_1_1);
		
		txtbname = new JTextField();
		txtbname.setBounds(111, 29, 179, 20);
		panel.add(txtbname);
		txtbname.setColumns(10);
		
		txtedition = new JTextField();
		txtedition.setColumns(10);
		txtedition.setBounds(111, 65, 179, 20);
		panel.add(txtedition);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(111, 98, 179, 20);
		panel.add(txtprice);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				


		
	String bname,edition,price;
	bname = txtbname.getText();
	edition = txtedition.getText();
	price = txtprice.getText();
				
	 try {
		pst = con.prepareStatement("insert into booktable(name,edition,price)values(?,?,?)");
		pst.setString(1, bname);
		pst.setString(2, edition);
		pst.setString(3, price);
		pst.executeUpdate();
		//JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
		//table_load();
			           
		txtbname.setText("");
		txtedition.setText("");
		txtprice.setText("");
		txtbname.requestFocus();
	   }
 
	catch (SQLException e1) 
        {
						
	e1.printStackTrace();
	}
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(45, 229, 89, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(272, 229, 89, 35);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(382, 83, 363, 181);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(25, 323, 408, 66);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 112, 408, 81);
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Book Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(30, -97, 103, 14);
		panel_1.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(131, -98, 179, 20);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Book ID");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 23, 103, 14);
		panel_1.add(lblNewLabel_1_3);
		
		txtbid = new JTextField();
		txtbid.setColumns(10);
		txtbid.setBounds(89, 22, 179, 20);
		panel_1.add(txtbid);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(156, 229, 89, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
             String bid;
	bid  = txtbid.getText();
	
	 try {
			pst = con.prepareStatement("delete from booktable where id =?");
	
            pst.setString(1, bid);
            pst.executeUpdate();
           // JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
            table_load();
           
            txtbname.setText("");
            txtedition.setText("");
            txtprice.setText("");
            txtbname.requestFocus();
		}

        catch (SQLException e1) {
			
			e1.printStackTrace();
		}
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(481, 337, 89, 52);
		frame.getContentPane().add(btnNewButton_2);
	}
}
