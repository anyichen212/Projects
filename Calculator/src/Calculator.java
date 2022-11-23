import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField text;
	JButton[] num = new JButton[10];
	JButton[] function = new JButton[9];
	JButton add, subtract, multiply, divide; // +, - , * , / buttons
	JButton decimal, equal, delete, clear, neg; // other buttons
	JPanel panel;

	
	Font font1 = new Font("Ink Free", Font.BOLD, 20);
	
	//num1 = first number insert, num2 = second number insert, result = the number shown
	double num1 = 0, num2 = 0, result = 0; //default values
	char operator = '0';
	boolean equalIsPress = false;
	//double ans; //holds the last result
	
	//constructor
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(400,500);
		frame.getContentPane().setBackground(new Color(255,229,204));
		//frame.pack(); // compute the size of the screen
		frame.setLocationRelativeTo(null);
		
		text = new JTextField();
		text.setBounds(50,25,300,50);
		text.setFont(font1);
		text.setEditable(false); //textfield is no longer edible
		text.setBackground(Color.white);
		
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("X");
		divide = new JButton("/");
		decimal = new JButton(".");
		equal = new JButton("=");
		delete = new JButton("DEL");
		clear = new JButton("CLR");
		neg = new JButton("(-)");
		
		function[0] = add;
		function[1] = subtract;
		function[2] = multiply;
		function[3] = divide;
		function[4] = decimal;
		function[5] = equal;
		function[6] = delete;
		function[7] = clear;
		function[8] = neg;
		
		for(int i = 0 ; i < 9 ; i++) {
			function[i].addActionListener(this);
			function[i].setFont(font1);
			function[i].setFocusable(false);
			function[i].setBackground(new Color(255,208,152));
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			num[i] = new JButton(String.valueOf(i));
			num[i].addActionListener(this);
			num[i].setFont(font1);
			num[i].setFocusable(false);
			num[i].setBackground(new Color(255,208,152));
		}
		
		neg.setBounds(60,400,65,40);
		delete.setBounds(135,400,100,40);
		clear.setBounds(240,400,100,40);
		
		panel = new JPanel();
		panel.setBounds(50, 90, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10)); //*
		panel.setBackground(new Color(255,229,204));
		
		panel.add(num[1]);
		panel.add(num[2]);
		panel.add(num[3]);
		panel.add(add);
		panel.add(num[4]);
		panel.add(num[5]);
		panel.add(num[6]);
		panel.add(subtract);
		panel.add(num[7]);
		panel.add(num[8]);
		panel.add(num[9]);
		panel.add(multiply);
		panel.add(decimal);
		panel.add(num[0]);
		panel.add(equal);
		panel.add(divide);
		
		frame.add(panel);
		frame.add(neg);
		frame.add(delete);
		frame.add(clear);
		frame.add(text);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		//JFrame frame = new JFrame();
		
		//frame.getContentPane().setBackground(Color.gray); //change bg color to gray
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i = 0 ; i<10 ; i++) {
			if(e.getSource() == num[i]) {
				if(equalIsPress == true) {
					clear();
					equalIsPress = false;
				}
				num2=Double.parseDouble(text.getText()+ i);
				text.setText(text.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decimal) { 
			//if current textfield contains decimal, it won't add another decimal
			if(!text.getText().contains(".")) {
				text.setText(text.getText().concat("."));
			}
		}
		
		if(e.getSource() == add) {
			equalIsPress = false;
			
			num1 = Double.parseDouble(text.getText());
			operator = '+';
			text.setText("");
		}
		
		if(e.getSource() == subtract) {
			equalIsPress = false;
			
			num1 = Double.parseDouble(text.getText());
			operator = '-';
			text.setText("");
		}
		
		if(e.getSource() == multiply) {
			equalIsPress = false;
			
			num1 = Double.parseDouble(text.getText());
			operator = '*';
			text.setText("");
		}
		
		if(e.getSource() == divide) {
			equalIsPress = false;
			
			num1 = Double.parseDouble(text.getText());
			operator = '/';
			text.setText("");
		}
		
		if(e.getSource()== equal) {
			
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			default:
				result = num2;
				break;
			}
			
			text.setText(String.valueOf(result));
			num1 = result;
			//ans = result;
			equalIsPress = true;
			
		}

		
		if(e.getSource() == clear) {
			//text.setText(String.valueOf(0));
			num2 = 0;
			clear();
		}
		if(e.getSource() == delete) {
			String str = text.getText();
			text.setText("");
			for (int i = 0; i<str.length()-1 ; i++) {
				text.setText(text.getText()+str.charAt(i));
			}
			operator = '0';
			num2=Double.parseDouble(text.getText()); //set current number as num2
		}
		
		if(e.getSource() == neg) {
			equalIsPress = false;
			operator = 0;
			
			if(text.getText().equals(""))
				text.setText("-");
			
			double temp = Double.parseDouble(text.getText());
			if(text.getText()== "")
				text.setText("-");
			temp*=-1;
			num2 = temp;
			text.setText(String.valueOf(temp));
		}
		
	}
	
	private void clear() {
		operator = '0';
		text.setText("");
	}

}
