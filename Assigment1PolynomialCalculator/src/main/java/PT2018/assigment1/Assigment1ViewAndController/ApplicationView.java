package PT2018.assigment1.Assigment1ViewAndController;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoundedRangeModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

import PT2018.assigment1.Assigment1PolynomialCalculator.Polinom;

public class ApplicationView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pane = new JPanel(new GridBagLayout());
	private JPanel pane1 = new JPanel(new FlowLayout());
	private JPanel pane2=new JPanel(new FlowLayout());
	private JPanel pane3=new JPanel(new FlowLayout());
	private JPanel pane4=new JPanel(new FlowLayout());
	private JPanel pane5=new JPanel(new FlowLayout());
	private JPanel pane6=new JPanel(new FlowLayout());
	private JPanel pane7=new JPanel(new FlowLayout());
	GridBagConstraints c = new GridBagConstraints();
	private JButton okButton1=new JButton("OK");
	private JButton okButton2=new JButton("OK");
	private JButton button = new JButton("\u002B");//plus
	private JButton button1 = new JButton("\u002D");//minus
	private JButton button2 = new JButton("\u002A");//semnul inmultirii
	private JButton button3 = new JButton("\u00F7");// semnul impartirii
	private JButton button4 = new JButton("\u0028"+"\u0029"+"\u0027");// ()'
	private JButton button5 = new JButton("\u222B");// integrala
	private JTextField text = new JTextField(20);
	private JTextField text2 = new JTextField(20);
	
	private JTextField polinom1Text=new JTextField(20);
	private JTextField polinom2Text=new JTextField(20);
	private JLabel polinom1Label=new JLabel("First Polynomial: ");
	private JLabel polinom2Label=new JLabel("Second Polynomial: ");
	private JTextField rezultat1Text=new JTextField(20);
	private JTextField rezultat2Text=new JTextField(20);
	private JLabel rezultat1Label=new JLabel("Result 1:");
	private JLabel rezultat2Label=new JLabel("Result 2:");
	
	private JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
	private  BoundedRangeModel brm = rezultat1Text.getHorizontalVisibility();
	 
	private JScrollBar scrollBar2 = new JScrollBar(JScrollBar.HORIZONTAL);
	private  BoundedRangeModel brm2 = rezultat2Text.getHorizontalVisibility();
	
	private String polinom1;
	private String polinom2;
	
	private Polinom pD;

	public ApplicationView(String name) {
		super(name);
		c.gridx = 0;
		c.gridy = 2;

		pane1.add(button, c);
		pane1.add(button1, c);
		pane1.add(button2, c);
		pane1.add(button3, c);
		pane1.add(button4, c);
		pane1.add(button5, c);
		

		pane.add(pane1, c);

		//listener pentru +
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(text.getText().isEmpty()|| text2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must enter two operands!", null, JOptionPane.ERROR_MESSAGE);
				}else {
					if(text.getText().matches("^[x0-9\\^\\+\\- ]+")&&text2.getText().matches("^[x0-9\\^\\+\\- ]+")) {
						polinom1=text.getText();
						polinom2=text2.getText();
						Polinom polinom3=addPolynomials(polinom1,polinom2);
						rezultat1Text.setText(polinom3.toString());
						rezultat1Label.setText("Sum:");
						pane7.setVisible(false);
						pane6.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong input format\n Your polynomials"
								+ " should have a similar format: ax^2+bx^1+cx^0", null, JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		});
		//listener pentru -
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(text.getText().isEmpty()|| text2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must enter two operands!", null, JOptionPane.ERROR_MESSAGE);
				}else {
					if(text.getText().matches("^[x0-9\\^\\+\\- ]+")&&text2.getText().matches("^[x0-9\\^\\+\\- ]+")) {
						polinom1=text.getText();
						polinom2=text2.getText();
						Polinom polinom3=subtractPolynomials(polinom1,polinom2);
						rezultat1Text.setText(polinom3.toString());
						rezultat1Label.setText("Subtraction:");
						pane7.setVisible(false);
						pane6.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong input format\n Your polynomials"
								+ " should have a similar format: ax^2+bx^1+cx^0", null, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		//listener pt *
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().isEmpty()|| text2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must enter two operands!", null, JOptionPane.ERROR_MESSAGE);
				}else {
					if(text.getText().matches("^[x0-9\\^\\+\\- ]+")&&text2.getText().matches("^[x0-9\\^\\+\\- ]+")) {
						polinom1=text.getText();
						polinom2=text2.getText();
						Polinom polinom3=multiplyPolynomials(polinom1,polinom2);
						rezultat1Text.setText(polinom3.toString());
						rezultat1Label.setText("Product:");
						pane7.setVisible(false);
						pane6.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong input format\n Your polynomials "
								+ "should have a similar format: ax^2+bx^1+cx^0", null, JOptionPane.ERROR_MESSAGE);
					}
				
				}
			}
		});
		//listener pt /
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().isEmpty()|| text2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must enter two operands!", null, JOptionPane.ERROR_MESSAGE);
				}else {
					if(text.getText().matches("^[x0-9\\^\\+\\- ]+")&&text2.getText().matches("^[x0-9\\^\\+\\- ]+")) {
						polinom1=text.getText();
						polinom2=text2.getText();
						Polinom polinom3=dividePolynomials(polinom1,polinom2);
						rezultat1Text.setText(polinom3.toString());//catul
						rezultat2Text.setText(pD.toString());//restul
						rezultat1Label.setText("Quotient:");
						rezultat2Label.setText("Remainder:");
						pane7.setVisible(true);
						pane6.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong input format\n Your polynomials"
								+ " should have a similar format: ax^2+bx^1+cx^0", null, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		//listener pt S
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().matches("^[x0-9\\^\\+\\- ]+")) {
					polinom1=text.getText();

					Polinom polinom2=integratePolynomial(polinom1);
					rezultat1Text.setText(polinom2.toString());
					rezultat1Label.setText("Integrate result:");
					pane7.setVisible(false);
					pane6.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong input format\n Your polynomial"
							+ " should have a similar format: ax^2+bx^1+cx^0", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//listener pt '
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().matches("^[x0-9\\^\\+\\- ]+")) {
					polinom1=text.getText();
					Polinom polinom2=derivativePolynomial(polinom1);
					rezultat1Text.setText(polinom2.toString());
					rezultat1Label.setText("Derivative result:");
					pane7.setVisible(false);
					pane6.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong input format\n Your polynomial"
							+ " should have a similar format: ax^2+bx^1+cx^0", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		c.gridx = 0;
		c.gridy = 0;

		pane2.add(text, c);
		pane2.add(okButton1,c);
		
		okButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().matches("^[x0-9\\^\\+\\- ]+")) {
					polinom1=text.getText();
					Polinom polinom=makePolynomial(polinom1);
					polinom1Text.setText(polinom.toString());
					pane7.setVisible(false);
					pane6.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong input format for the first polynomial\n Your polynomial should"
							+ " have a similar format: ax^2+bx^1+cx^0 ", null, JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		
		pane.add(pane2, c);

		c.gridx = 0;
		c.gridy = 1;
		pane3.add(text2,c);
		pane3.add(okButton2,c);
		
		okButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text2.getText().matches("^[x0-9\\^\\+\\- ]+")) {
					polinom2=text2.getText();
					Polinom polinom=makePolynomial(polinom2);
					polinom2Text.setText(polinom.toString());
					pane7.setVisible(false);
					pane6.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong input format for the second polynomial\n Your polynomial should"
							+ " have a similar format: ax^2+bx^1+cx^0", null, JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		pane.add(pane3, c);

		c.gridx = 0;
		c.gridy = 3;
		polinom1Label.setFont(new Font("Helvetica",Font.BOLD,20));
		pane4.add(polinom1Label,c);
		pane4.add(polinom1Text,c);
		
		pane.add(pane4,c);

		c.gridx = 0;
		c.gridy = 4;
		
		polinom2Label.setFont(new Font("Helvetica",Font.BOLD,20));
		pane5.add(polinom2Label,c);
		pane5.add(polinom2Text,c);
		
		pane.add(pane5,c);
		
		
		c.gridx=0;
		c.gridy=5;
		JPanel pane8 = new JPanel();
	    pane8.setLayout( new BoxLayout(pane8, BoxLayout.Y_AXIS));
		scrollBar.setModel(brm);
		rezultat1Label.setFont(new Font("Helvetica",Font.BOLD,20));
		pane6.add(rezultat1Label,c);
		pane8.add(rezultat1Text,c);
		pane8.add(scrollBar,c);
		pane6.add(pane8,c);
		pane6.setVisible(false);
		
		pane.add(pane6,c);
		
		
		c.gridx=0;
		c.gridy=6;
		JPanel pane9=new JPanel();
		pane9.setLayout(new BoxLayout(pane9,BoxLayout.Y_AXIS));
		scrollBar2.setModel(brm2);
		rezultat2Label.setFont(new Font("Helvetica",Font.BOLD,20));
		pane7.add(rezultat2Label,c);
		pane9.add(rezultat2Text,c);
		pane9.add(scrollBar2,c);
		pane7.add(pane9,c);
		pane7.setVisible(false);
		
		pane.add(pane7,c);
		

		this.add(pane);

	}
	public Polinom makePolynomial(String polinom) {//imparte sirul de la intrare intr-un tablou de siruri pentru constructorul 
													//polinomului
		String[] monoame;
		String p1=polinom.contains("-")?polinom.replace("-", "+-"):polinom;
		monoame=p1.split("\\+");
		Polinom p=new Polinom(monoame);
		return p;
		
	}
	public Polinom addPolynomials(String polinom1,String polinom2) {
		Polinom p1,p2,p3;
		p1=makePolynomial(polinom1);//se transforma de fiecare data sirul din TextField in polinom
		p2=makePolynomial(polinom2);
		p3=p1.add(p2);
		return p3;
	}
	public Polinom subtractPolynomials(String polinom1,String polinom2) {
		Polinom p1,p2,p3;
		p1=makePolynomial(polinom1);
		p2=makePolynomial(polinom2);
		p3=p1.subtract(p2);
		return p3;
	}
	public Polinom multiplyPolynomials(String polinom1,String polinom2) {
		Polinom p1,p2,p3;
		p1=makePolynomial(polinom1);
		p2=makePolynomial(polinom2);
		p3=p1.multiply(p2);
		return p3;
	}
	public Polinom dividePolynomials(String polinom1,String polinom2) {
		Polinom p2,p3;
		pD=makePolynomial(polinom1);
		p2=makePolynomial(polinom2);
		p3=pD.divide(p2);
		return p3;
	}
	public Polinom derivativePolynomial(String polinom1) {
		Polinom p1,p2;
		p1=makePolynomial(polinom1);
		p2=p1.derivative();
		return p2;
	}
	public Polinom integratePolynomial(String polinom1) {
		Polinom p1,p2;
		p1=makePolynomial(polinom1);
		p2=p1.integrate();
		return p2;
	}


	

}


