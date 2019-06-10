import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import hu.bme.model.Customer;

import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DeleteCustomer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteCustomer dialog = new DeleteCustomer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteCustomer() {

		setTitle("Delete Customer");
		setBounds(100, 100, 725, 513);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 709, 37);
		contentPanel.add(panel);

		JLabel label = new JLabel("Welcome to ABC bank ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(60, 179, 113));
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		label.setBounds(147, 11, 399, 17);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enter ID,Name and click check",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 48, 689, 80);
		contentPanel.add(panel_1);

		JLabel label_1 = new JLabel("ID:");
		label_1.setBounds(71, 21, 20, 14);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel(" Name: ");
		label_2.setBounds(54, 52, 53, 14);
		panel_1.add(label_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(184, 18, 225, 20);
		panel_1.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(184, 49, 225, 20);
		panel_1.add(textField_1);

		JButton button = new JButton("Check");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name = null;
				String id_Number = null;
		
				Name = textField_1.getText();
				id_Number = textField.getText();
		
				try {
					List<Customer> customers = DatabaseConnection.getConnectionDATAaccount(Name, id_Number);
					Customer c = customers.get(0);
					textField_2.setText(c.getName());
					textField_3.setText(c.getAccountNumber());
					textField_7.setText(Integer.toString(c.getBalance()));
					textField_4.setText(c.getAddress());
					textField_5.setText(id_Number);
					textField_6.setText(c.getAccountType());
					

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("sorry we don't have this account");
				}
			}
		});
		button.setBounds(530, 17, 89, 23);
		panel_1.add(button);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);

			}
		});
		btnClear.setBounds(530, 48, 89, 23);
		panel_1.add(btnClear);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 139, 689, 291);
		contentPanel.add(panel_2);

		JLabel label_3 = new JLabel("Name:");
		label_3.setBounds(59, 14, 37, 14);
		panel_2.add(label_3);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(185, 11, 225, 20);
		panel_2.add(textField_2);

		JLabel label_4 = new JLabel("Account Number:");
		label_4.setBounds(10, 45, 135, 14);
		panel_2.add(label_4);

		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(185, 42, 225, 20);
		panel_2.add(textField_3);

		JLabel label_5 = new JLabel("Address:");
		label_5.setBounds(48, 73, 85, 14);
		panel_2.add(label_5);

		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(185, 70, 225, 20);
		panel_2.add(textField_4);

		JLabel label_6 = new JLabel("ID:");
		label_6.setBounds(76, 104, 86, 14);
		panel_2.add(label_6);

		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(185, 101, 225, 20);
		panel_2.add(textField_5);

		JLabel label_7 = new JLabel("Account type :");
		label_7.setBounds(22, 135, 111, 14);
		panel_2.add(label_7);

		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(185, 132, 225, 20);
		panel_2.add(textField_6);

		JLabel label_8 = new JLabel("Balance :");
		label_8.setBounds(52, 159, 81, 17);
		panel_2.add(label_8);

		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(185, 157, 225, 20);
		panel_2.add(textField_7);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Delete");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							DatabaseConnection.getConnectiondelete(textField.getText());
							setVisible(false);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							System.out.println("sorry we don't have this account");
							e1.printStackTrace();
							
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
