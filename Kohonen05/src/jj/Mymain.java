package jj;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class MyFrame extends JFrame{


	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JPanel jp31;
	JPanel jp32;
	JPanel jp4;

	
	JLabel prompt;
	JLabel noise_value;
	JLabel font1;
	JLabel font2;
	JLabel font3;

	ArrayList <JButton> p_button;
	JButton	button0;
	JButton	button2;
	JButton	button1;
	JButton	button3;



	JButton update;
	JButton learn;
	//JButton noise;

	JSlider noise_slider;


	ArrayList <JPanel> show_pattern;
	ArrayList <JPanel> updated_pattern;

	


	Kohonen kohonen;

	int input_index;
	int learn_flag;
	int font_flag;
	int index_flag;


	//JTable table;
	public MyFrame(){
		kohonen = new Kohonen();
		input_index = 100;
		learn_flag =0;
		font_flag = 10;
		index_flag = 10;

		p_button = new ArrayList<>();


		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MyFrame");

		//Buttons

		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");


		update = new JButton("update!");
		learn = new JButton("learning!");



		//add ActionListener for Buttons

		update.addActionListener(new MyListener());
		learn.addActionListener(new MyListener());

		//Label
		

		prompt = new JLabel();
		noise_value = new JLabel("noise = 10"+"%");
		font1 = new JLabel("font1");
		font2 = new JLabel("font2");
		font3 = new JLabel("font3");

		//Panels
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(8,3,2,2));

		jp1.add(font1);jp1.add(font2);jp1.add(font3);


		String[] array = {"A","B","C","D","E","J","K"};

		for(int i = 0; i < 21; i++){
			p_button.add(new JButton(""+(array[i/3])+""+((i%3)+1)));
			jp1.add(p_button.get(i));
			p_button.get(i).addActionListener(new MyListener());
		}

		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(9,7,2,2));
		show_pattern = new ArrayList<>();

		for(int i = 0; i < 63; i++){
			show_pattern.add(new JPanel());
			show_pattern.get(i).setBackground(Color.WHITE);
			jp2.add(show_pattern.get(i));
		}


		jp3 = new JPanel();
		jp31 = new JPanel();
		jp32 = new JPanel();


		noise_slider = new JSlider(0, 100, 10);
		noise_slider.setMajorTickSpacing(10); // 큰 눈금 간격
		noise_slider.setMinorTickSpacing(1); // 작은 눈금 간격
		noise_slider.setPaintTicks(true); // 눈금을 표시한다.
		noise_slider.setPaintLabels(true); // 값을 레이블로 표시한다.
		noise_slider.addChangeListener(new MyCListener());

		jp31.setLayout(new GridLayout(2,1));
		jp31.add(noise_slider);
		jp31.add(noise_value);



		jp32.setLayout(new GridLayout(2,1));


		jp32.add(learn);
		jp32.add(update);
		jp32.add(prompt);


		jp3.setLayout(new GridLayout(2,1));
		jp3.add(jp31);
		jp3.add(jp32);


		jp4 = new JPanel();
		jp4.setLayout(new GridLayout(9,7,2,2));
		updated_pattern = new ArrayList<>();

		for(int i = 0; i < 63; i++){
			updated_pattern.add(new JPanel());
			updated_pattern.get(i).setBackground(Color.WHITE);
			jp4.add(updated_pattern.get(i));
		}


		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		setLayout(new GridLayout(2,2,4,4));
		setVisible(true);

	}

	public void setPattern(int font,int index){

		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				if(kohonen.getPattern(font,index)[i][j]==1){

					show_pattern.get(i*7 +j ).setBackground(Color.BLACK);
				}
				else{

					show_pattern.get(i*7 +j).setBackground(Color.WHITE);
				}
			}

		}
	}
	public void setPattern(int[][] update){
		
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				if(update[i][j]==1){
					updated_pattern.get(i*7 +j ).setBackground(Color.BLACK);
				}
				else{
					updated_pattern.get(i*7 +j ).setBackground(Color.WHITE);
				}
			}
		}
	}
	public void setPattern(){

		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				if(kohonen.getPattern()[i][j]==1){

					show_pattern.get(i*7 +j ).setBackground(Color.BLACK);
				}
				else{

					show_pattern.get(i*7 +j).setBackground(Color.WHITE);
				}
			}

		}
	}


	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton clicked = (JButton) e.getSource();
			prompt.setText("");
			for(int i = 1; i <4; i++){
				if(clicked.getText().equals("A"+i)){
					font_flag = i-1;
					index_flag = 0;
					setPattern(i-1,0);
					break;
				}
				if(clicked.getText().equals("B"+i)){
					font_flag = i-1;
					index_flag = 1;
					setPattern(i-1,1);
					break;
				}
				if(clicked.getText().equals("C"+i)){
					font_flag = i-1;
					index_flag = 2;
					setPattern(i-1,2);
					break;
				}
				if(clicked.getText().equals("D"+i)){
					font_flag = i-1;
					index_flag = 3;
					setPattern(i-1,3);
					break;
				}
				if(clicked.getText().equals("E"+i)){
					font_flag = i-1;
					index_flag = 4;
					setPattern(i-1,4);
					break;
				}
				if(clicked.getText().equals("J"+i)){
					font_flag = i-1;
					index_flag = 5;
					setPattern(i-1,5);
					break;
				}
				if(clicked.getText().equals("K"+i)){
					font_flag = i-1;
					index_flag = 6;
					setPattern(i-1,6);
					break;
				}


			}



			if(e.getSource() == learn){
				kohonen.learning();
				learn_flag = 1;
				prompt.setText("Learning done");
			}
			if(e.getSource() == update){
				if(learn_flag != 1){
					prompt.setText("click learn button");
				}
				else{
					//kohonen.update();
					setPattern(kohonen.update());
				}
				
			}

		}

	}//MyListener

	private class MyCListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			prompt.setText("");
			JSlider source = (JSlider)e.getSource();
			if (source.getValueIsAdjusting()) {


				kohonen.add_noise(font_flag, index_flag, source.getValue());
				noise_value.setText("noise = "+source.getValue()+"%");
				setPattern();

			}


		}
	}

}
public class Mymain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame();
	}

}
