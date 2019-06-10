import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Label;
import java.awt.Button;

public class MainFrame extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public MainFrame() throws IOException {
		setTitle("ABC BANK");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnFile.add(mntmLogin);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Operations");
		menuBar.add(mnEdit);

		JMenuItem mntmWithdrawal = new JMenuItem("Withdrawal");
		mntmWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Withdrawal().setVisible(true);
			}
		});
		mntmWithdrawal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		mnEdit.add(mntmWithdrawal);

		JSeparator separator_1 = new JSeparator();
		mnEdit.add(separator_1);

		JMenuItem mntmDeposit = new JMenuItem("Deposit");
		mntmDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Deposit().setVisible(true);
			}
		});
		mntmDeposit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnEdit.add(mntmDeposit);

		JSeparator separator_2 = new JSeparator();
		mnEdit.add(separator_2);

		JMenuItem mntmRegistration = new JMenuItem("Registration");
		mntmRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerRegistration().setVisible(true);
			}
		});
		mntmRegistration.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mnEdit.add(mntmRegistration);

		JMenu mnHistory = new JMenu("History");
		menuBar.add(mnHistory);

		JMenuItem mntmRegistr = new JMenuItem("Registered Customers");
		mnHistory.add(mntmRegistr);

		JSeparator separator_3 = new JSeparator();
		mnHistory.add(separator_3);

		JMenuItem mntmNewMenuItem = new JMenuItem("Login details");
		mnHistory.add(mntmNewMenuItem);

		JSeparator separator_4 = new JSeparator();
		mnHistory.add(separator_4);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Withdrawal details");
		mnHistory.add(mntmNewMenuItem_1);

		JSeparator separator_5 = new JSeparator();
		mnHistory.add(separator_5);

		JMenuItem mntmDepositDetails = new JMenuItem("Deposit details");
		mnHistory.add(mntmDepositDetails);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(5, 5, 1352, 33);
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(toolBar);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		button_1.setToolTipText("Add Customer ");
		button_1.setIcon(new ImageIcon(MainFrame.class.getResource("/Images/add-icon.png")));
		toolBar.add(button_1);

		JButton button_2 = new JButton("");
		button_2.setToolTipText("Deposit");
		button_2.setIcon(new ImageIcon(MainFrame.class.getResource("/Images/coin-add-icon.png")));
		toolBar.add(button_2);

		JButton button = new JButton("");
		button.setToolTipText("Withdrawal");
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/Images/coin-search-icon.png")));
		toolBar.add(button);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(5, 38, 1352, 641);
		contentPane.add(splitPane);

		URL domain = new URL("https://www.mnb.hu/en/arfolyamok");

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		JButton btnNewButton_3 = new JButton("Website");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
				        URI uri = new URI("https://www.abcbanking.mu/");
				        java.awt.Desktop.getDesktop().browse(uri);

				    } catch (URISyntaxException | IOException e) {
				        //System.out.println("THROW::: make sure we handle browser error");
				        e.printStackTrace();
				    }

			}
		});
		
		JButton btnNewButton_4 = new JButton("Exchange ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
				        URI uri = new URI("https://moneytis.com/best-exchange-rates");
				        java.awt.Desktop.getDesktop().browse(uri);

				    } catch (URISyntaxException | IOException e1) {
				        //System.out.println("THROW::: make sure we handle browser error");
				        e1.printStackTrace();
				    }

			}
		});
		
		JButton btnLo = new JButton("ABC BANK  Location ");
		btnLo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
				        URI uri = new URI("https://www.google.fr/maps/place/ABC+Banking+Corporation/@-20.1618378,57.5004069,17z/data=!3m1!4b1!4m5!3m4!1s0x217c5054ab0ad6bf:0xbf19c156ab4e2311!8m2!3d-20.1618428!4d57.5025956");
				        java.awt.Desktop.getDesktop().browse(uri);

				    } catch (URISyntaxException | IOException e1) {
				        //System.out.println("THROW::: make sure we handle browser error");
				        e1.printStackTrace();
				    }
			}
		});
		
		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
				        URI uri = new URI("https://www.abcbanking.mu/about-us/");
				        java.awt.Desktop.getDesktop().browse(uri);

				    } catch (URISyntaxException | IOException e1) {
				        //System.out.println("THROW::: make sure we handle browser error");
				        e1.printStackTrace();
				    }
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLo, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAboutUs, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(100)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addComponent(btnLo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(btnAboutUs, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		gl_panel.setAutoCreateContainerGaps(true);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setBackground(new Color(176, 224, 230));
		panel_2.setBounds(0, 0, 1034, 93);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("Welcome to ABC bank ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(60, 179, 113));
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		label.setBounds(332, 11, 399, 59);
		panel_2.add(label);
		
				JButton btnNewButton = new JButton("Customer Registration");
				btnNewButton.setBounds(61, 181, 299, 73);
				panel_1.add(btnNewButton);
				
						JButton btnDeposit = new JButton("Deposit");
						btnDeposit.setBounds(654, 181, 299, 73);
						panel_1.add(btnDeposit);
						
								JButton btnNewButton_1 = new JButton("Withdrawal");
								btnNewButton_1.setBounds(654, 328, 299, 73);
								panel_1.add(btnNewButton_1);
								
										JButton btnNewButton_2 = new JButton("Modify Customer ");
										btnNewButton_2.setBounds(61, 328, 299, 73);
										panel_1.add(btnNewButton_2);
										
												JButton btnDisplayAccountData = new JButton("Display account Data ");
												btnDisplayAccountData.setBounds(654, 472, 299, 73);
												panel_1.add(btnDisplayAccountData);
												
														JButton btnModifyC = new JButton("Delete Costumer");
														btnModifyC.setBounds(61, 472, 299, 73);
														panel_1.add(btnModifyC);
														
																JLabel lblBankOperations = new JLabel("BANK OPERATIONS");
																lblBankOperations.setBounds(398, 116, 200, 21);
																panel_1.add(lblBankOperations);
																lblBankOperations.setHorizontalAlignment(SwingConstants.CENTER);
																lblBankOperations.setFont(new Font("Segoe UI Semibold", Font.BOLD, 19));
																lblBankOperations.setForeground(new Color(0, 139, 139));
														btnModifyC.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																new DeleteCustomer().setVisible(true);
															}
														});
												btnDisplayAccountData.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														new DisplayAccountData().setVisible(true);
													}
												});
										btnNewButton_2.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												new ModifyCustomer().setVisible(true);
											}
										});
								btnNewButton_1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										new Withdrawal().setVisible(true);
									}
								});
						btnDeposit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new Deposit().setVisible(true);
							}
						});
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new CustomerRegistration().setVisible(true);
					}
				});
	}
}
