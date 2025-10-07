package calculator;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JMenu;


import java.text.DecimalFormat;
//import java.net.URL;

public class CalculatorInterfata extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	double a = 0, b = 0, c = 0;
	CalculatorFunctie calc = new CalculatorFunctie();

	char op;
	boolean newOp = true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorInterfata frame = new CalculatorInterfata();
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
	public CalculatorInterfata() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage("S:\\AplicatiiAn4Sem1\\eclipse\\CalculatorBuzunar\\calculatorImage.png"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/calculatorImage.png")));
		//URL url = getClass().getResource("/images/calculatorImage.png");
		//System.out.println("Image URL = " + url);

		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 419);
		setLocationRelativeTo(null);
		
		//menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		//close
		JMenuItem mntmNewMenuItem = new JMenuItem("Close");
		mntmNewMenuItem.addActionListener(e -> System.exit(0));
		mnNewMenu.add(mntmNewMenuItem);
		
		//despre tema
		JMenu mnNewMenu_1 = new JMenu("About");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tema SI");
		mntmNewMenuItem_1.addActionListener(e -> JOptionPane.showMessageDialog(this, 
				"Tema calculator de buzunar - laborator SI - Bujor Andrei, 3142a", "About", JOptionPane.INFORMATION_MESSAGE));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		//
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 20, 254, 62);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//cifre
		ActionListener cifreListener = e -> {
			String cmd = ((JButton) e.getSource()).getText();
			if (newOp || textField.getText().equals("0")) {
				textField.setText(cmd);
				newOp = false;
			}
			else {
				textField.setText(textField.getText() + cmd);
			}
		};
		
		//butoane
		JButton btnDel = new JButton("←");
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDel.setBackground(new Color(255, 128, 0));
		btnDel.setBounds(10, 95, 56, 43);
		contentPane.add(btnDel);
		btnDel.addActionListener(e -> {
			String s = textField.getText();
			if (s.length() > 1) textField.setText(s.substring(0, s.length() - 1));
			else textField.setText("0");
		});
		
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnC.setBackground(new Color(255, 128, 0));
		btnC.setBounds(76, 95, 56, 43);
		contentPane.add(btnC);
		btnC.addActionListener(e -> {
			textField.setText("0");
			a = b = c = 0;
			op = '\0';
			newOp = true;
		});
		
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setBounds(142, 148, 56, 43);
		btn9.addActionListener(cifreListener);
		contentPane.add(btn9);
		
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setBounds(76, 148, 56, 43);
		btn8.addActionListener(cifreListener);
		contentPane.add(btn8);
		
		
		JButton btn7 = new JButton("7");
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn7.setBounds(10, 148, 56, 43);
		btn7.addActionListener(cifreListener);
		contentPane.add(btn7);
		
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setBounds(142, 201, 56, 43);
		btn6.addActionListener(cifreListener);
		contentPane.add(btn6);
		
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setBounds(76, 201, 56, 43);
		btn5.addActionListener(cifreListener);
		contentPane.add(btn5);
		
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setBounds(10, 201, 56, 43);
		btn4.addActionListener(cifreListener);
		contentPane.add(btn4);
		
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setBounds(142, 254, 56, 43);
		btn3.addActionListener(cifreListener);
		contentPane.add(btn3);
		
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setBounds(76, 254, 56, 43);
		btn2.addActionListener(cifreListener);
		contentPane.add(btn2);
		
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBounds(10, 254, 56, 43);
		btn1.addActionListener(cifreListener);
		contentPane.add(btn1);
		
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn0.setBackground(new Color(255, 255, 255));
		btn0.setBounds(10, 307, 122, 43);
		btn0.addActionListener(cifreListener);
		contentPane.add(btn0);
		
		
		JButton btnDiv = new JButton("÷");
		btnDiv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDiv.setBackground(new Color(232, 232, 232));
		btnDiv.setBounds(142, 95, 56, 43);
		contentPane.add(btnDiv);
		
		
		JButton btnMul = new JButton("*");
		btnMul.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMul.setBackground(new Color(232, 232, 232));
		btnMul.setBounds(208, 95, 56, 43);
		contentPane.add(btnMul);
			
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPlus.setBackground(new Color(232, 232, 232));
		btnPlus.setBounds(208, 201, 56, 43);
		contentPane.add(btnPlus);
		
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMinus.setBackground(new Color(232, 232, 232));
		btnMinus.setBounds(208, 148, 56, 43);
		contentPane.add(btnMinus);
		
		
		JButton btnEqual = new JButton("=");
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEqual.setBackground(new Color(255, 128, 0));
		btnEqual.setBounds(208, 254, 56, 96);
		contentPane.add(btnEqual);
		
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDot.setBackground(new Color(255, 255, 255));
		btnDot.setBounds(142, 307, 56, 43);
		contentPane.add(btnDot);
		btnDot.addActionListener(e -> {
			if (!textField.getText().contains(".")) {
				textField.setText(textField.getText() + ".");
				newOp = false;
			}
		});
		
		
		//operatii
		ActionListener opListener = e -> {
			try {
				a = Double.parseDouble(textField.getText());
				op = ((JButton) e.getSource()).getText().charAt(0);
				newOp = true;
			} catch (NumberFormatException ex) {
				textField.setText("Eroare");
			}
		};

		
		btnPlus.addActionListener(opListener);
		btnMinus.addActionListener(opListener);
		btnMul.addActionListener(opListener);
		btnDiv.addActionListener(opListener);
		
		
		btnEqual.addActionListener(e -> {
			try {
				b = Double.parseDouble(textField.getText());
				switch (op) {
					case '+': c = calc.adunare(a, b); break;
					case '-': c = calc.scadere(a, b); break;
					case '*': c = calc.inmultire(a, b); break;
					case '÷': c = calc.impartire(a, b); break;
					default:
						return;
				}
				DecimalFormat df = new DecimalFormat("0.##");
				textField.setText(df.format(c));
				a = c;
				newOp = true;
			} catch (NumberFormatException ex) {
				textField.setText("Error");
			} catch (ArithmeticException ex) {
		        textField.setText("Error");
		    }
		});
	}
}
