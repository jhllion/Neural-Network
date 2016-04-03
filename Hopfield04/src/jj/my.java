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

	JLabel trained;
	JLabel prompt;
	JLabel noise_value;
	
	JButton	button0;
	JButton	button2;
	JButton	button1;
	JButton	button3;

	

	JButton update;
	JButton train;
	//JButton noise;

	JSlider noise_slider;


	ArrayList <JPanel> show_pattern;


	Hopfield hopfield;
	int input_index;
	int train_flag;

	//JTable table;
	public MyFrame(){
		hopfield = new Hopfield();
		input_index = 100;
		train_flag =0;

		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MyFrame");

		//Buttons
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		

		update = new JButton("update!");
		train = new JButton("training!");



		//add ActionListener for Buttons
		button0.addActionListener(new MyListener());
		button1.addActionListener(new MyListener());
		button2.addActionListener(new MyListener());
		button3.addActionListener(new MyListener());
	
		update.addActionListener(new MyListener());
		train.addActionListener(new MyListener());

		//Label
		trained = new JLabel("pattern");
		
		prompt = new JLabel();
		noise_value = new JLabel("noise = 10"+"%");

		//Panels
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(5,2,2,2));
		jp1.add(trained);
		
		jp1.add(button0);
		jp1.add(button1);
		jp1.add(button2);
		jp1.add(button3);
		
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(10,10,2,2));
		show_pattern = new ArrayList<>();

		for(int i = 0; i < 100; i++){
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


		jp32.add(train);
		jp32.add(update);
		jp32.add(prompt);


		jp3.setLayout(new GridLayout(2,1));
		jp3.add(jp31);
		jp3.add(jp32);


		


		jp4 = new JPanel();


		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		setLayout(new GridLayout(2,2,4,4));
		setVisible(true);

	}

	public void setPattern(char p,int index){

		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				if(hopfield.get_pattern(p,index)[i][j]==1){
					show_pattern.get(i*10 +j ).setBackground(Color.BLACK);
				}
				else{
					show_pattern.get(i*10 +j ).setBackground(Color.WHITE);
				}
			}
		}
	}
	public void setPattern(int[][] update){

		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				if(update[i][j]==1){
					show_pattern.get(i*10 +j ).setBackground(Color.BLACK);
				}
				else{
					show_pattern.get(i*10 +j ).setBackground(Color.WHITE);
				}
			}
		}
	}



	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			prompt.setText("");
			if(e.getSource() == button0){
				input_index = 0;
				setPattern('p',0);
			}
			if(e.getSource() == button1){
				input_index = 1;
				setPattern('p',1);
			}
			if(e.getSource() == button2){
				input_index = 2;
				setPattern('p',2);
			}
			if(e.getSource() == button3){
				input_index = 3;
				setPattern('p',3);
			}


			if(e.getSource() == train){
				hopfield.training();
				train_flag =1;
			}
			if(e.getSource() == update){
				if(input_index != 100 && train_flag == 1){
					setPattern(hopfield.hop_update(input_index));
				}
				else{
					if(train_flag == 0){
						prompt.setText("click train button");
					}
					if(input_index ==100){
						prompt.setText("click input button");
					}

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
		        //hop;setPattern('i',0);
		    	if(train_flag == 0){
		    		prompt.setText("click train button");
		    	}
		    	else if(input_index == 100){
		    		prompt.setText("click input button");
		    	}
		    	else{
		    		hopfield.add_noise(input_index, source.getValue());
		    		noise_value.setText("noise = "+source.getValue()+"%");
		    		setPattern('i', input_index);
		    	}
		    }
		    
		    
		}
	}

}

public class my {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame();

		//f.setPattern(p);
	}

}
