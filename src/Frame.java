
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

class UpButton extends JButton{
	public UpButton(String a){
		super(a);
		setBackground(new Color(230,230,230));
		setBorder(BorderFactory.createEmptyBorder());
		setFont(new Font("Serif",Font.CENTER_BASELINE, 18));
		addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseEntered(MouseEvent e) {
            	setBackground(new Color(198,198,198));
            }
            @Override
			public void mouseExited(MouseEvent e){
            	setBackground(new Color(230,230,230));
            }
            @Override
			public void mouseReleased(MouseEvent e){
            	setBackground(new Color(198,198,198));
            }
		});
	}
}
class DownButton extends JButton{
	public DownButton(String a){
		super(a);
		setBackground(new Color(220,220,220));
		setBorder(BorderFactory.createEmptyBorder());
		setFont(new Font("宋体", Font.CENTER_BASELINE, 20));
		addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseEntered(MouseEvent e) {
            	setBackground(new Color(198,198,198));
            }
            @Override
			public void mouseExited(MouseEvent e){
            	setBackground(new Color(220,220,220));
            }
            @Override
			public void mouseReleased(MouseEvent e){
            	setBackground(new Color(198,198,198));
            }
		});
	}
}
class NumButton extends JButton{
	public NumButton(String a){
		super(a);
		setBackground(new Color(220,220,220));
		setBorder(BorderFactory.createEmptyBorder());
		setFont(new Font("黑体", Font.BOLD, 25));
		setForeground(Color.BLACK);
		addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseEntered(MouseEvent e) {
            	setBackground(new Color(198,198,198));
            }
            @Override
			public void mouseExited(MouseEvent e){
            	setBackground(new Color(220,220,220));
            }
            @Override
			public void mouseReleased(MouseEvent e){
            	setBackground(new Color(198,198,198));
            }
		});
	}
}
public class Frame{
	JFrame frame = new JFrame();
	JTextField textField = new JTextField(5);
	JTextField oldField = new JTextField(5);
	JPanel panelLeft = new JPanel();
	JScrollPane scrollRight = new JScrollPane();
	JPanel scrollPanel = new JPanel();
	JPanel panelRight = new JPanel();
	JScrollBar sBar;
	ArrayList<String> historyOperation = new ArrayList<String>();
	ArrayList<String> historyResult = new ArrayList<String>();
	double firstNum=0;
	String sign="";
	
	public Frame(){//---------------------------构造函数，直接创建界面
		//载入图片
		ImageIcon imageDel = new ImageIcon(getClass().getResource("images/del.jpg"));
		ImageIcon imageHistory = new ImageIcon(getClass().getResource("images/history.jpg"));
		ImageIcon imageHistoryOn = new ImageIcon(getClass().getResource("images/historyOn.jpg"));
		ImageIcon imageDelOn = new ImageIcon(getClass().getResource("images/delOn.jpg"));
		//顶部按钮
		UpButton transform=new UpButton("标准");
		transform.setPreferredSize(new Dimension(50,50));
		JButton history = new JButton();
		history.setIcon(imageHistory);
		history.setRolloverIcon(imageHistoryOn);
		history.setBorderPainted(false);
		history.setFocusPainted(false);
		history.setContentAreaFilled(false);
		history.setPreferredSize(new Dimension(50,50));
		
		//设定顶部panel
		JPanel panelTop = new JPanel();
		panelTop.setLayout(new BorderLayout(10,0));
		panelTop.add(transform,"West");
		 JPanel panelTopEmptyBox = new JPanel();
		 panelTopEmptyBox.setBackground(new Color(230,230,230));
		panelTop.add(panelTopEmptyBox,"Center");
		panelTop.add(history,"East");
		panelTop.setBackground(new Color(230,230,230));
		panelTop.setPreferredSize(new Dimension(330,50));
		panelTop.setMaximumSize(new Dimension(3000,50));
		
		//数字按钮
		DownButton buttonCe = new DownButton("CE");
		DownButton buttonC = new DownButton("C");
		DownButton buttondel = new DownButton("del");
		DownButton buttondiv = new DownButton("/");
		NumButton button7 = new NumButton("7");
		NumButton button8 = new NumButton("8");
		NumButton button9 = new NumButton("9");
		DownButton buttonmul = new DownButton("*");
		NumButton button4 = new NumButton("4");
		NumButton button5 = new NumButton("5");
		NumButton button6 = new NumButton("6");
		DownButton buttonsub = new DownButton("-");
		NumButton button1 = new NumButton("1");
		NumButton button2 = new NumButton("2");
		NumButton button3 = new NumButton("3");
		DownButton buttonsum = new DownButton("+");
		DownButton buttoncha = new DownButton("±");
		NumButton button0 = new NumButton("0");
		DownButton buttonpoint = new DownButton(".");
		DownButton buttonequ = new DownButton("=");
		
		UpButton buttonsqrt = new UpButton("√");
		UpButton buttonN = new UpButton("x^y");
		UpButton buttonMod = new UpButton("Mod");
		UpButton buttonsin = new UpButton("sin");
		UpButton buttoncos = new UpButton("cos");
		UpButton buttonlog = new UpButton("log");
		
		//panelUp是左边除文本域的上面的容器
		JPanel panelUp = new JPanel();
		panelUp.setLayout(new GridLayout(2,4));
		panelUp.add(buttonsqrt);
		panelUp.add(buttonN);
		panelUp.add(buttonMod);
		panelUp.add(buttonsin);
		panelUp.add(buttoncos);
		panelUp.add(buttonlog);
		panelUp.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,new Color(200,200,200)));
		panelUp.setPreferredSize(new Dimension(330,125));
		//panelDown是左边除文本域的下面的容器
		JPanel panelDown = new JPanel();
		panelDown.setLayout(new GridLayout(5,4));
		panelDown.setPreferredSize(new Dimension(330,360));
		panelDown.setBorder(BorderFactory.createEmptyBorder());
		panelDown.add(buttonCe);
		panelDown.add(buttonC);
		panelDown.add(buttondel);
		panelDown.add(buttondiv);
		panelDown.add(button7);
		panelDown.add(button8);
		panelDown.add(button9);
		panelDown.add(buttonmul);
		panelDown.add(button4);
		panelDown.add(button5);
		panelDown.add(button6);
		panelDown.add(buttonsub);
		panelDown.add(button1);
		panelDown.add(button2);
		panelDown.add(button3);
		panelDown.add(buttonsum);
		panelDown.add(buttoncha);
		panelDown.add(button0);
		panelDown.add(buttonpoint);
		panelDown.add(buttonequ);
			//添加监听事件
			//buttonAction是数字键1,2,3,4,5,6,7,8,9,0等用
			//signAction的事件是需要两个数字进行计算的运算符用
			//backAction的事件是需要一个数字即可运算的运算符用
			//onlyAction的事件是删除清空按钮用的
		button0.addActionListener(new buttonAction());
		button1.addActionListener(new buttonAction());
		button2.addActionListener(new buttonAction());
		button3.addActionListener(new buttonAction());
		button4.addActionListener(new buttonAction());
		button5.addActionListener(new buttonAction());
		button6.addActionListener(new buttonAction());
		button7.addActionListener(new buttonAction());
		button8.addActionListener(new buttonAction());
		button9.addActionListener(new buttonAction());
		buttonpoint.addActionListener(new buttonAction());
		
		buttonsum.addActionListener(new signAction());
		buttonsub.addActionListener(new signAction());
		buttonmul.addActionListener(new signAction());
		buttondiv.addActionListener(new signAction());
		buttoncha.addActionListener(new signAction());
		buttonequ.addActionListener(new signAction());
		buttonMod.addActionListener(new signAction());
		buttonN.addActionListener(new signAction());
		
		buttonsqrt.addActionListener(new backAction());
		buttonsin.addActionListener(new backAction());
		buttoncos.addActionListener(new backAction());
		buttonlog.addActionListener(new backAction());
		
		buttondel.addActionListener(new onlyAction());
		buttonCe.addActionListener(new onlyAction());
		buttonC.addActionListener(new onlyAction());
		
		//设置textField
		textField.setBackground(new Color(230,230,230));
		textField.setFont(new Font("SansSerif",Font.BOLD,45));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setText("0");
		textField.setBorder(BorderFactory.createEmptyBorder());
		textField.setPreferredSize(new Dimension(330,79));
		textField.setMaximumSize(new Dimension(3000,100));
		//设置oldField
		oldField.setBackground(new Color(230,230,230));
		oldField.setHorizontalAlignment(SwingConstants.RIGHT);
		oldField.setFont(new Font("Serif",Font.ROMAN_BASELINE,18));
		oldField.setEditable(false);
		oldField.setBorder(BorderFactory.createEmptyBorder());
		oldField.setPreferredSize(new Dimension(330,30));
		oldField.setMaximumSize(new Dimension(3000,50));
		//对右面板边进行布局
		//底部删除按钮
		JButton delButton = new JButton();
		delButton.setIcon(imageDel);
		delButton.setRolloverIcon(imageDelOn);
		delButton.setBorderPainted(false);
		delButton.setContentAreaFilled(false);
		delButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				//点击删除按钮之后要清空动态数组，清空scrollPanel，tempHistory=0
				scrollPanel.removeAll();
				historyOperation.clear();;
				historyResult.clear();;
				tempHistory = 0;
				scrollRight.repaint();
			}
		});
			//panelRightDown是右边总panel容器中的下面的容器
		JPanel panelRightDown = new JPanel();
		panelRightDown.setPreferredSize(new Dimension(330,50));
		panelRightDown.setMaximumSize(new Dimension(330,50));
		panelRightDown.setBackground(new Color(230,230,230));
		panelRightDown.add(delButton,"East");
			//panelRightUp是右边总panel容器中的上面的容器
		JLabel panelRightUp = new JLabel();
		panelRightUp.setBackground(new Color(230,230,230));
		panelRightUp.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(200,200,200)));
		panelRightUp.setBounds(0,0,330,50);
		panelRightUp.setOpaque(true);
		panelRightUp.setHorizontalAlignment(SwingConstants.LEFT);
		panelRightUp.setFont(new Font("SansSerif",Font.BOLD,15));
		panelRightUp.setText("  历史记录");
			//panelRightBotton是右边底部删除按钮占用空间
		//右边中间滚动容器
		scrollPanel.setLayout(new BoxLayout(scrollPanel,BoxLayout.Y_AXIS));
		scrollPanel.setSize(new Dimension(330,1000));
		scrollPanel.setBackground(new Color(230,230,230));
		scrollRight.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollRight.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
		scrollRight.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(200,200,200)));
		scrollRight.setOpaque(false);
		scrollRight.setRowHeaderView(panelRightUp);
		scrollRight.getViewport().add(scrollPanel);
		//panelRight右边滚动视图中的总panel
		panelRight.setLayout(null);
		panelRight.setMinimumSize(new Dimension(330,200));
		panelRight.setPreferredSize(new Dimension(330,500));
		panelRight.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(200,200,200)));
		panelRight.add(panelRightUp);
		//panelRight.add(panelScroll);
		panelRight.add(scrollRight);
		panelRight.add(panelRightDown);
		//panelLeft左边总容器
		panelLeft.setMinimumSize(new Dimension(330,200));
		panelLeft.setLayout(new BoxLayout(panelLeft,BoxLayout.Y_AXIS));
		panelLeft.add(panelTop);
		panelLeft.add(oldField);
		panelLeft.add(textField);
		panelLeft.add(panelUp);
		panelLeft.add(panelDown);
		//设定history按钮的作用
		history.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(panelRight.getWidth()==0)
				{
					frame.setSize(660, frame.getHeight());
					panelRight.setVisible(true);
					panelRightDown.setBounds(0,panelRight.getHeight()-50,330,50);
					scrollRight.setBounds(0, 50, 330, panelRight.getHeight()-100);
					panelLeft.setPreferredSize(new Dimension(frame.getWidth()-330,frame.getHeight()));
				}
				else
					frame.setSize(350, frame.getHeight());
			}
		});
		//窗口设置
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.add(panelLeft);
		frame.add(panelRight);
		frame.setBackground(new Color(220,220,220));
		frame.setDefaultCloseOperation(3);
		frame.setTitle("计算器");
		frame.setSize(350, 640);
			//监听窗口大小变化
		frame.addWindowStateListener(new WindowStateListener(){
			@Override
			public void windowStateChanged(WindowEvent e) {
				// TODO 自动生成的方法存根
				if(e.getComponent().getWidth()>=660)
				{
					panelRight.setVisible(true);
					panelRightDown.setBounds(0,panelRight.getHeight()-50,330,50);
					scrollRight.setBounds(0, 50, 330, panelRight.getHeight()-100);
					panelLeft.setPreferredSize(new Dimension(frame.getWidth()-330,frame.getHeight()));
				}
				else
				{
					panelRight.setVisible(false);
				}
			}
		});
		//监听窗口拖动变化
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO 自动生成的方法存根
				if(e.getComponent().getWidth()>=660)
				{
					panelRight.setVisible(true);
					panelRightDown.setBounds(0,panelRight.getHeight()-50,330,50);
					scrollRight.setBounds(0, 50, 330, panelRight.getHeight()-100);
					panelLeft.setPreferredSize(new Dimension(frame.getWidth()-330,frame.getHeight()));
				}
				else
				{
					panelRight.setVisible(false);
				}
			}
		});
		frame.setVisible(true);
	}
	
	int temp = 0;//当temp为0时表示下一次输入数字的时候会清掉textField内容
	boolean canDel = true;//canDel代表是否可以删除
	boolean secondF5 = false;//如果secondF5为true那么将会禁止按数字键
	class buttonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
				if(secondF5==true)
				{
					oldField.setText("");
					secondF5=false;
				}
				fontSumChange();
				if(temp==0)
				{
					textField.setText("");
					canDel=true;
					temp++;
				}
				if(fontSubChange()==false)
					return;
				if(e.getActionCommand()=="0")
				{
					textField.setText(textField.getText()+"0");
				}
				if(e.getActionCommand()=="1")
				{
					textField.setText(textField.getText()+"1");
				}
				if(e.getActionCommand()=="2")
				{
					textField.setText(textField.getText()+"2");
				}
				if(e.getActionCommand()=="3")
				{
					textField.setText(textField.getText()+"3");
				}
				if(e.getActionCommand()=="4")
				{
					textField.setText(textField.getText()+"4");
				}
				if(e.getActionCommand()=="5")
				{
					textField.setText(textField.getText()+"5");
				}
				if(e.getActionCommand()=="6")
				{
					textField.setText(textField.getText()+"6");
				}
				if(e.getActionCommand()=="7")
				{
					textField.setText(textField.getText()+"7");
				}
				if(e.getActionCommand()=="8")
				{
					textField.setText(textField.getText()+"8");
				}
				if(e.getActionCommand()=="9")
				{
					textField.setText(textField.getText()+"9");
				}
				if(e.getActionCommand()==".")
				{
					textField.setText(textField.getText()+".");
				}
			}
		}
	class signAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(sign=="$")
				oldField.setText(oldField.getText()+e.getActionCommand());
			else
				oldField.setText(oldField.getText()+textField.getText()+e.getActionCommand());
			secondF5=false;
			if(sign=="x^y")
			{
				textField.setText(Double.toString(Math.pow(firstNum,Double.parseDouble(textField.getText()))));
				firstNum=Double.parseDouble(textField.getText());
			}
			if(sign=="+")
			{
				textField.setText(Double.toString(Double.parseDouble(textField.getText())+firstNum));
				firstNum=Double.parseDouble(textField.getText());
			}
			if(sign=="-")
			{
				textField.setText(Double.toString(firstNum-Double.parseDouble(textField.getText())));
				firstNum=Double.parseDouble(textField.getText());
			}
			if(sign=="*")
			{
				textField.setText(Double.toString(firstNum*Double.parseDouble(textField.getText())));
				firstNum=Double.parseDouble(textField.getText());
			}
			if(sign=="/")
			{
				textField.setText(Double.toString(firstNum/Double.parseDouble(textField.getText())));
				firstNum=Double.parseDouble(textField.getText());
			}
			if(sign=="Mod")
			{
				textField.setText(Double.toString(firstNum%Double.parseDouble(textField.getText())));
				firstNum=Double.parseDouble(textField.getText());
			}
			if(e.getActionCommand()=="±")
				textField.setText(Double.toString(Double.parseDouble(textField.getText())*-1));
			if(e.getActionCommand()=="=")
			{
				setRightPane();
				oldField.setText("");
				firstNum=0;
				sign="";
				canDel=false;
			}
			if(sign==""&&e.getActionCommand()!="=")
			{
				firstNum=Double.parseDouble(textField.getText());
				oldField.setText(firstNum+e.getActionCommand());
			}
			else
				firstNum=Double.parseDouble(textField.getText());
			//通过将sign赋值为运算符的方法，实现记录上次输入的运算符的功能，在下次按运算键的时候回自动先把上次的输入进行运算并输出
			if(e.getActionCommand()=="+"){sign="+";}
			if(e.getActionCommand()=="-"){sign="-";}
			if(e.getActionCommand()=="*"){sign="*";}
			if(e.getActionCommand()=="/"){sign="/";}
			if(e.getActionCommand()=="Mod"){sign="Mod";}
			if(e.getActionCommand()=="x^y"){sign="x^y";}
			temp=0;
			fontSubChange();
			fontSumChange();
		}
	}
	int tempHistory = 0;
	JTextArea textOperation;
	JTextField textResult;
	//每次按等号键调用此函数，在右边存储结果，设定等
	private void setRightPane(){
		//将运算式和结果写入数组保存
		textOperation = new JTextArea();
		textResult = new JTextField();
		
		historyOperation.add(oldField.getText());
		historyResult.add(textField.getText());
		//向右边的滚动视图中添加一个包含运算式和结果的区域
		
		textOperation = new JTextArea();
		textOperation.setLineWrap(true);
		textOperation.setFont(new Font("Serif",Font.ROMAN_BASELINE,18));
		textOperation.setBorder(BorderFactory.createEmptyBorder());
		textOperation.setBackground(new Color(230,230,230));
		textOperation.setEditable(false);
		
		textResult.setFont(new Font("SansSerif",Font.BOLD,25));
		textResult.setBackground(new Color(230,230,230));
		textResult.setBorder(BorderFactory.createEmptyBorder());
		textResult.setEditable(false);
		textResult.setHorizontalAlignment(SwingConstants.RIGHT);
		
			textOperation.setText(historyOperation.get(tempHistory));
			textResult.setText(historyResult.get(tempHistory));
		JPanel panela = new JPanel();
		panela.setMaximumSize(new Dimension(300,90));
		panela.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255,255,255)));
		panela.setPreferredSize(new Dimension(300,80));
		panela.setLayout(new BoxLayout(panela,BoxLayout.Y_AXIS));
		panela.add(textOperation);
		panela.add(textResult);
		panela.setBackground(new Color(230,230,230));
		
		textResult.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				oldField.setText(textOperation.getText());
				textField.setText(textResult.getText());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				textResult = (JTextField) e.getComponent();
				textOperation = (JTextArea) textResult.getParent().getComponent(0);
				textResult.setBackground(new Color(220,220,220));
				textOperation.setBackground(new Color(220,220,220));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				textOperation.setBackground(new Color(230,230,230));
				textResult.setBackground(new Color(230,230,230));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				textOperation.setBackground(new Color(200,200,200));
				textResult.setBackground(new Color(200,200,200));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				textOperation.setBackground(new Color(220,220,220));
				textResult.setBackground(new Color(220,220,220));
			}
		});
		textOperation.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				oldField.setText(textOperation.getText());
				textField.setText(textResult.getText());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				textOperation = (JTextArea) e.getComponent();
				textResult = (JTextField) textOperation.getParent().getComponent(1);
				textResult.setBackground(new Color(220,220,220));
				textOperation.setBackground(new Color(220,220,220));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				textOperation.setBackground(new Color(230,230,230));
				textResult.setBackground(new Color(230,230,230));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				textOperation.setBackground(new Color(200,200,200));
				textResult.setBackground(new Color(200,200,200));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				textOperation.setBackground(new Color(220,220,220));
				textResult.setBackground(new Color(220,220,220));
			}
		});
		scrollPanel.add(panela);
		//调整滚动条一直在最底部
		sBar = scrollRight.getVerticalScrollBar();
		sBar.setValue(sBar.getMaximum()-sBar.getVisibleAmount());
		tempHistory++;
		panelRight.validate();//确保组件具有有效的布局
	}
	//点击运算符后运算符显示在文字前面的符号用的监听事件
	class backAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			//back用来保存前面加减乘除得到的结果然后在进行cos sin等
			double back=0.0;
			//当sign是$符号时候不会在oldField中累计显示，而是刷新单次显示
			if(sign!="$")
				oldField.setText(oldField.getText()+e.getActionCommand()+textField.getText());
			else
				oldField.setText(e.getActionCommand()+textField.getText());
			if(e.getActionCommand()=="√");
			{
				textField.setText(Double.toString(Math.sqrt(Double.parseDouble(textField.getText()))));
				back=Math.sqrt(Double.parseDouble(textField.getText()));
			}
			if(e.getActionCommand()=="sin")
			{
				textField.setText(Double.toString(Math.sin(Double.parseDouble(textField.getText()))));
				back=Math.sin(Double.parseDouble(textField.getText()));
			}
			if(e.getActionCommand()=="cos")
			{
				textField.setText(Double.toString(Math.cos(Double.parseDouble(textField.getText()))));
				back=Math.cos(Double.parseDouble(textField.getText()));
			}
			if(e.getActionCommand()=="log")
			{
				textField.setText(Double.toString(Math.log(Double.parseDouble(textField.getText()))));
				back=Math.log(Double.parseDouble(textField.getText()));
			}
			if(sign=="+")
			{
				textField.setText(Double.toString(firstNum+back));
				firstNum=Double.parseDouble(textField.getText());
			}
			if(sign=="-")
			{
				textField.setText(Double.toString(firstNum-back));
				firstNum=Double.parseDouble(textField.getText());
			}
			if(sign=="*")
			{
				textField.setText(Double.toString(firstNum*back));
				firstNum=Double.parseDouble(textField.getText());
			}
			if(sign=="/")
			{
				textField.setText(Double.toString(firstNum/back));
				firstNum=Double.parseDouble(textField.getText());
			}
			fontSubChange();
			fontSumChange();
			secondF5=true;
			sign="$";
			temp=0;
		}
	}
	//清空和删除按钮用的监听
	class onlyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			//等号的处理判断
			if(e.getActionCommand()=="del"&&canDel==true)
			{
				String str = textField.getText();
				str=str.substring(0,str.length()-1);
				if(str.length()==0)
				{
					textField.setText("0");
					temp=0;
				}
				else
					textField.setText(str);
			}
			if(e.getActionCommand()=="CE")
			{
				textField.setText("0");
				temp=0;
			}
			if(e.getActionCommand()=="C")
			{
				oldField.setText("");
				textField.setText("0");
				sign="";
				firstNum=0;
				temp=0;
			}
			fontSubChange();
			fontSumChange();
		}
	}
	//fontChange函数用来判断textField的字符数量是否超量，超出边界后的处理
	FontMetrics metricsSub;
	//fontSubChange用来检测字体大小超量然后缩小字体
	public boolean fontSubChange(){
		int textWidth=0;
		metricsSub = textField.getFontMetrics(textField.getFont());
		textWidth=metricsSub.stringWidth(textField.getText());
		if(textWidth>textField.getWidth()-30)
		{
			for(int i=40;i>=20;i--)
			{
				textField.setFont(new Font("SansSerif",Font.BOLD,i));
				metricsSub = textField.getFontMetrics(textField.getFont());
				textWidth=metricsSub.stringWidth(textField.getText());
				if(i==20)
				{
					return false;
				}
				if(textWidth<textField.getWidth()-30)
					break;
			}
		}
		return true;
	}
	//fontSubChange用来检测字体大小太小然后扩大字体
	FontMetrics metricsSum;
	public boolean fontSumChange(){
		int textWidth=0;
		metricsSub = textField.getFontMetrics(textField.getFont());
		textWidth=metricsSub.stringWidth(textField.getText());
		if(textWidth<textField.getWidth()-30)
		{
			for(int i=20;i<=42;i++)
			{
				textField.setFont(new Font("SansSerif",Font.BOLD,i));
				metricsSum = textField.getFontMetrics(textField.getFont());
				textWidth=metricsSum.stringWidth(textField.getText());
				if(textWidth>textField.getWidth()-30)
					break;
			}
		}
		return true;
	}
}
