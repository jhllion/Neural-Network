package jj;

import java.util.ArrayList;
import java.util.Random;

public class Hopfield {

	ArrayList <int[][]> pgroup;
	ArrayList <int[][]> input_p;

	int[][] weight;
	int[] bias;


	public Hopfield(){
		weight = new int[100][100];
		bias = new int[100];
		makepattern();
		make_input_pattern();
	}

	public void makepattern(){
		//pattern for training
		pgroup = new ArrayList<>();

		//0
		int[][] ipattern = new int[10][10];
		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				ipattern[i][j]=-1;
			}//for j loop
		}//for i loop

		ipattern[0][3]=1;ipattern[0][4]=1;ipattern[0][5]=1;ipattern[0][6]=1;
		ipattern[1][2]=1;ipattern[1][3]=1;ipattern[1][4]=1;
		ipattern[1][5]=1;ipattern[1][6]=1;ipattern[1][7]=1;
		for(int i = 2 ; i < 8 ; i++){
			ipattern[i][1]=1;ipattern[i][2]=1;ipattern[i][3]=1;
			ipattern[i][6]=1;ipattern[i][7]=1;ipattern[i][8]=1;
		}
		ipattern[9][3]=1;ipattern[9][4]=1;ipattern[9][5]=1;ipattern[9][6]=1;
		ipattern[8][2]=1;ipattern[8][3]=1;ipattern[8][4]=1;
		ipattern[8][5]=1;ipattern[8][6]=1;ipattern[8][7]=1;

		pgroup.add(ipattern);



		//1
		int[][] ipattern1 = new int[10][10];
		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				ipattern1[i][j]=-1;
			}//for j loop
		}//for i loop

		for(int i = 0; i < 10 ; i++){
			ipattern1[i][3]=1;ipattern1[i][4]=1;ipattern1[i][5]=1;ipattern1[i][6]=1;
			ipattern1[9][i]=1;
		}
		ipattern1[1][2]=1;ipattern1[2][1]=1;

		pgroup.add(ipattern1);

		//2
		int[][] ipattern2 = new int[10][10];
		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				ipattern2[i][j]=-1;
			}//for j loop
		}//for i loop

		for(int i = 2; i< 9;i++){
			ipattern2[1][i]=1;ipattern2[4][i]=1;ipattern2[5][i]=1;
		}
		ipattern2[2][8]=1;ipattern2[2][9]=1;
		ipattern2[3][8]=1;ipattern2[3][9]=1;
		ipattern2[5][1]=1;
		ipattern2[6][0]=1;ipattern2[6][1]=1;
		ipattern2[7][0]=1;ipattern2[7][1]=1;
		ipattern2[4][9]=1;ipattern2[5][9]=1;
		for(int i = 0; i< 10;i++){
			ipattern2[8][i]=1;ipattern2[9][i]=1;	
		}


		pgroup.add(ipattern2);


		//3
		int[][] ipattern3 = new int[10][10];
		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				ipattern3[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 1; i < 9 ; i++){
			ipattern3[1][i]=1;
		}
		ipattern3[2][7]=1;ipattern3[2][8]=1;
		ipattern3[3][5]=1;ipattern3[3][6]=1;ipattern3[3][7]=1;
		ipattern3[4][3]=1;ipattern3[4][4]=1;ipattern3[4][5]=1;ipattern3[4][6]=1;
		ipattern3[5][2]=1;ipattern3[5][3]=1;ipattern3[5][4]=1;ipattern3[5][5]=1;
		ipattern3[5][6]=1;ipattern3[5][7]=1;
		ipattern3[6][7]=1;ipattern3[6][8]=1;
		ipattern3[7][7]=1;ipattern3[7][8]=1;
		ipattern3[8][8]=1;

		for(int i = 0; i < 8 ; i++){
			ipattern3[8][i]=1; ipattern3[9][i]=1;
		}


		pgroup.add(ipattern3);
	}//make pattern for training

	public void make_input_pattern(){
		input_p = new ArrayList<>();

		//0
		int[][] ipattern = new int[10][10];
		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				ipattern[i][j]=-1;
			}//for j loop
		}//for i loop

		ipattern[0][3]=1;ipattern[0][4]=1;ipattern[0][5]=1;ipattern[0][6]=1;
		ipattern[1][2]=1;ipattern[1][3]=1;ipattern[1][4]=1;
		ipattern[1][5]=1;ipattern[1][6]=1;ipattern[1][7]=1;
		for(int i = 2 ; i < 8 ; i++){
			ipattern[i][1]=1;ipattern[i][2]=1;ipattern[i][3]=1;
			ipattern[i][6]=1;ipattern[i][7]=1;ipattern[i][8]=1;
		}
		ipattern[9][3]=1;ipattern[9][4]=1;ipattern[9][5]=1;ipattern[9][6]=1;
		ipattern[8][2]=1;ipattern[8][3]=1;ipattern[8][4]=1;
		ipattern[8][5]=1;ipattern[8][6]=1;ipattern[8][7]=1;

		input_p.add(ipattern);



		//1
		int[][] ipattern1 = new int[10][10];
		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				ipattern1[i][j]=-1;
			}//for j loop
		}//for i loop

		for(int i = 0; i < 10 ; i++){
			ipattern1[i][3]=1;ipattern1[i][4]=1;ipattern1[i][5]=1;ipattern1[i][6]=1;
			ipattern1[9][i]=1;
		}
		ipattern1[1][2]=1;ipattern1[2][1]=1;

		input_p.add(ipattern1);

		//2
		int[][] ipattern2 = new int[10][10];
		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				ipattern2[i][j]=-1;
			}//for j loop
		}//for i loop

		for(int i = 2; i< 9;i++){
			ipattern2[1][i]=1;ipattern2[4][i]=1;ipattern2[5][i]=1;
		}
		ipattern2[2][8]=1;ipattern2[2][9]=1;
		ipattern2[3][8]=1;ipattern2[3][9]=1;
		ipattern2[5][1]=1;
		ipattern2[6][0]=1;ipattern2[6][1]=1;
		ipattern2[7][0]=1;ipattern2[7][1]=1;
		ipattern2[4][9]=1;ipattern2[5][9]=1;
		for(int i = 0; i< 10;i++){
			ipattern2[8][i]=1;ipattern2[9][i]=1;	
		}


		input_p.add(ipattern2);


		//3
		int[][] ipattern3 = new int[10][10];
		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				ipattern3[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 1; i < 9 ; i++){
			ipattern3[1][i]=1;
		}
		ipattern3[2][7]=1;ipattern3[2][8]=1;
		ipattern3[3][5]=1;ipattern3[3][6]=1;ipattern3[3][7]=1;
		ipattern3[4][3]=1;ipattern3[4][4]=1;ipattern3[4][5]=1;ipattern3[4][6]=1;
		ipattern3[5][2]=1;ipattern3[5][3]=1;ipattern3[5][4]=1;ipattern3[5][5]=1;
		ipattern3[5][6]=1;ipattern3[5][7]=1;
		ipattern3[6][7]=1;ipattern3[6][8]=1;
		ipattern3[7][7]=1;ipattern3[7][8]=1;
		ipattern3[8][8]=1;

		for(int i = 0; i < 8 ; i++){
			ipattern3[8][i]=1; ipattern3[9][i]=1;
		}

		input_p.add(ipattern3);

	}


	public void add_noise(int pattern_index, int noise){
		Random random = new Random(2);
		int temp;
		for(int i = 0 ; i <10; i++){
			for(int j = 0; j <10 ; j++){
				temp = random.nextInt(100) + 1;
				if(temp < noise){
					input_p.get(pattern_index)[i][j] = pgroup.get(pattern_index)[i][j] * (-1);
				}
				else{
					input_p.get(pattern_index)[i][j] = pgroup.get(pattern_index)[i][j];
				}
			}
		}
	}



	public void training(){

		//fill weight matrix 
		int num_pattern = pgroup.size();
		for(int i = 0 ; i<100 ; i++){
			for(int j = 0 ; j<100; j++){
				weight[i][j] = 0 ;
			}
		}

		for(int n = 0; n < num_pattern; n++){
			for(int i = 0 ; i<100 ; i++){
				for(int j = 0 ; j<100; j++){
					if(i == j){
						weight[i][j] = 0;
					}
					else{
						weight[i][j] += (pgroup.get(n)[i/10][i%10]) * (pgroup.get(n)[j/10][j%10]);
					}
				}
			}			
		}

		for(int i = 0 ; i<100 ; i++){
			bias[i]=0;
			for(int j = 0 ;  j < 100; j++){
				bias[i] += weight[i][j]; 
			}
			bias[i] /= -2;
		}
	}// training

	public int[][] hop_update(int index){
		return update(input_p.get(index));
	}
	private int[][] update(int[][] input_pattern){
		int[][] updated = new int[10][10];
		int update_node;
		int update_flag=0;

		do{
			for(int i = 0; i <100; i++){
				update_node = bias[i];
				for(int j = 0 ; j < 100 ;  j++){
					update_node += weight[i][j] * input_pattern[j/10][j%10];
				}
				if(update_node > 0 ){
					updated[i/10][i%10] = 1;
					update_flag = 1;
				}
				else if (update_node < 0){
					updated[i/10][i%10] = 0;
					update_flag = 1;
				}
				else if(update_node == 0){
					updated[i/10][i%10] = input_pattern[i/10][i%10];
				}
			}

		}while(update_flag==0);
		return updated;
	}//update

	public int[][] get_pattern(char p,int index){
		if(p == 'i'){
			return input_p.get(index); 

		}
		return pgroup.get(index);

	}

}
