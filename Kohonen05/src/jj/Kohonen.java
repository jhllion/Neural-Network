package jj;

import java.util.ArrayList;
import java.util.Random;

public class Kohonen {

	ArrayList <int[][]> pgroup;
	int[][] input_p;

	double[][] weights;

	int Max_times;
	int cur_times;
	int distance;
	double a;


	public Kohonen(){
		pgroup = new ArrayList<>();
		input_p = new int[9][7];
		weights = new double[63][21];

		Max_times = 10000000;
		cur_times = 0;
		a = 0.1;
		distance = 10;
		
		
		makePattern();
		for(int i = 0 ; i < 63; i ++){
			for(int j = 0 ;  j < 21; j++){
				weights[i][j]=0;
			}
		}	

		Random random = new Random(1);
		for(int i = 0 ; i < 63; i ++){
			for(int j = 0 ;  j < 21; j++){
				weights[i][j]=random.nextInt(100)/100.00;
				//weights[i][j] = 0.00;
				System.out.print("	"+weights[i][j]);
			}
			System.out.println("");
		}	

	}


	public void makePattern(){


		//font1
		//A
		int[][] ipattern1a = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern1a[i][j]=-1;
			}//for j loop
		}//for i loop

		for(int i = 0; i<3;i++){
			ipattern1a[i][3] = 1;
		}
		ipattern1a[0][2]=1;
		ipattern1a[3][2]=1;ipattern1a[3][4]=1;ipattern1a[4][2]=1;ipattern1a[4][4]=1;
		for(int i = 1; i<6;i++){
			ipattern1a[5][i] = 1;
		}
		ipattern1a[6][1]=1;ipattern1a[6][5]=1;ipattern1a[7][1]=1;ipattern1a[7][5]=1;
		for(int i = 0; i<7;i++){
			ipattern1a[8][i] = 1;
		}ipattern1a[8][3] = -1;
		pgroup.add(ipattern1a);

		//B
		int[][] ipattern1b = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern1b[i][j]=-1;
			}//for j loop
		}//for i loop

		for(int i = 0; i<6;i++){
			ipattern1b[0][i]=1;ipattern1b[4][i]=1;ipattern1b[8][i]=1;
		}
		for(int i = 0 ; i <9;i++){
			ipattern1b[i][1]=1;ipattern1b[i][6]=1;
		}
		ipattern1b[0][6]=-1;ipattern1b[4][6]=-1;ipattern1b[8][6]=-1;ipattern1b[4][0]=-1;
		pgroup.add(ipattern1b);

		//C
		int[][] ipattern1c = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern1c[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 2; i < 7 ; i++){
			ipattern1c[i][0]=1;
		}
		for(int i = 2; i < 6 ; i++){
			ipattern1c[0][i]=1;ipattern1c[8][i]=1;
		}
		ipattern1c[1][1]=1;ipattern1c[7][1]=1;
		ipattern1c[0][6]=1;ipattern1c[1][6]=1;
		ipattern1c[7][6]=1;
		pgroup.add(ipattern1c);

		//D
		int[][] ipattern1d = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern1d[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0 ; i < 5 ; i++){
			ipattern1d[0][i]=1;ipattern1d[8][i]=1;
		}
		for(int i = 0 ; i < 9 ; i++){
			ipattern1d[i][1]=1;
		}
		for(int i = 2 ; i < 7 ; i++){
			ipattern1d[i][6]=1;
		}
		ipattern1d[1][5]=1;ipattern1d[7][5]=1;
		pgroup.add(ipattern1d);

		//E
		int[][] ipattern1e = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern1e[i][j]=-1;
			}//for j loop
		}//for i loop

		for(int i = 0 ; i < 9 ; i++){
			ipattern1e[i][1]=1;
		}
		for(int i = 0 ; i < 7 ; i++){
			ipattern1e[0][i]=1;ipattern1e[8][i]=1;
		}
		ipattern1e[4][2]=1;ipattern1e[4][3]=1;ipattern1e[3][3]=1;
		ipattern1e[5][3]=1;ipattern1e[1][6]=1;ipattern1e[7][6]=1;
		pgroup.add(ipattern1e);

		//J
		int[][] ipattern1j = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern1j[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0 ; i <8;i++){
			ipattern1j[i][5]=1;
		}

		ipattern1j[0][3]=1;ipattern1j[0][4]=1;ipattern1j[0][5]=1;ipattern1j[0][6]=1;
		ipattern1j[8][2]=1;ipattern1j[8][3]=1;ipattern1j[8][4]=1;
		ipattern1j[7][1]=1;ipattern1j[6][1]=1;
		pgroup.add(ipattern1j);

		//K
		int[][] ipattern1k = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern1k[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0; i<9;i++){
			ipattern1k[i][1] = 1;
		}
		for(int i = 0; i<3;i++){
			ipattern1k[0][i] = 1;ipattern1k[8][i] = 1;
		}
		ipattern1k[3][2] = 1;ipattern1k[4][2] = 1;
		ipattern1k[2][3] = 1;ipattern1k[5][3] = 1;
		ipattern1k[1][4] = 1;ipattern1k[6][4] = 1;
		ipattern1k[0][5] = 1;ipattern1k[7][5] = 1;
		ipattern1k[0][6] = 1;ipattern1k[8][6] = 1;ipattern1k[8][5] = 1;
		pgroup.add(ipattern1k);

		//////////////////////////////////////////
		//font2
		//A
		int[][] ipattern2a = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern2a[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0; i <3;i++){
			ipattern2a[i][3]=1;
		}
		for(int i = 3; i <5;i++){
			ipattern2a[i][2]=1;ipattern2a[i][4]=1;
		}
		for(int i = 5; i <9;i++){
			ipattern2a[i][1]=1;ipattern2a[i][5]=1;
		}
		for(int i = 1; i <6;i++){
			ipattern2a[6][i]=1;
		}
		pgroup.add(ipattern2a);

		//B
		int[][] ipattern2b = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern2b[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0; i <9;i++){
			ipattern2b[i][0]=1;ipattern2b[i][6]=1;
		}
		for(int i = 0; i <6;i++){
			ipattern2b[0][i]=1;ipattern2b[4][i]=1;ipattern2b[8][i]=1;
		}
		ipattern2b[0][6]=-1;ipattern2b[4][6]=-1;ipattern2b[8][6]=-1;
		pgroup.add(ipattern2b);

		//C
		int[][] ipattern2c = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern2c[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 2; i <7;i++){
			ipattern2c[i][0]=1;
		}
		ipattern2c[1][1]=1;ipattern2c[7][1]=1;
		ipattern2c[0][2]=1;ipattern2c[0][3]=1;ipattern2c[0][4]=1;
		ipattern2c[8][2]=1;ipattern2c[8][3]=1;ipattern2c[8][4]=1;
		ipattern2c[1][5]=1;ipattern2c[7][5]=1;
		ipattern2c[2][6]=1;ipattern2c[6][6]=1;
		pgroup.add(ipattern2c);

		//D
		int[][] ipattern2d = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern2d[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i=0;i<5;i++){
			ipattern2d[0][i]=1;ipattern2d[8][i]=1;
		}
		for(int i = 0; i < 9 ; i++){
			ipattern2d[i][0]=1;
		}
		for(int i = 2; i < 7 ; i++){
			ipattern2d[i][6]=1;
		}
		ipattern2d[1][5]=1;ipattern2d[7][5]=1;
		pgroup.add(ipattern2d);

		//E
		int[][] ipattern2e = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern2e[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0 ; i < 9; i++){
			ipattern2e[i][0]=1;
		}
		for(int i =  0 ; i < 7 ; i ++ ){
			ipattern2e[0][i]=1;ipattern2e[4][i]=1;ipattern2e[8][i]=1;
		}
		ipattern2e[4][6]=-1;ipattern2e[4][5]=-1;
		pgroup.add(ipattern2e);

		//J
		int[][] ipattern2j = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern2j[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0 ; i <8;i++){
			ipattern2j[i][5]=1;
		}		

		ipattern2j[8][2]=1;ipattern2j[8][3]=1;ipattern2j[8][4]=1;
		ipattern2j[7][1]=1;ipattern2j[6][1]=1;
		pgroup.add(ipattern2j);

		//K
		int[][] ipattern2k = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern2k[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0 ; i < 9; i++){
			ipattern2k[i][0]=1;
		}
		ipattern2k[4][1]=1;
		ipattern2k[3][2]=1;ipattern2k[5][2]=1;
		ipattern2k[2][3]=1;ipattern2k[6][3]=1;
		ipattern2k[1][4]=1;ipattern2k[7][4]=1;
		ipattern2k[0][5]=1;ipattern2k[8][5]=1;
		pgroup.add(ipattern2k);

		/////////////////////////////////////
		//font3
		//A
		int[][] ipattern3a = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern3a[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0 ; i < 2 ; i ++){
			ipattern3a[i][3]=1;
		}
		for(int i = 2 ; i < 4 ; i ++){
			ipattern3a[i][2]=1;ipattern3a[i][4]=1;
		}
		for(int i = 4 ; i < 6 ; i ++){
			ipattern3a[i][1]=1;ipattern3a[i][5]=1;
		}
		for(int i = 6 ; i < 9 ; i ++){
			ipattern3a[i][0]=1;ipattern3a[i][6]=1;
		}
		for(int i = 1 ; i < 6 ; i ++){
			ipattern3a[5][i]=1;
		}
		ipattern3a[8][1]=1;ipattern3a[8][5]=1;
		pgroup.add(ipattern3a);

		//B
		int[][] ipattern3b = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern3b[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0; i<6;i++){
			ipattern3b[0][i]=1;ipattern3b[3][i]=1;ipattern3b[8][i]=1;
		}
		for(int i = 0 ; i <9;i++){
			ipattern3b[i][1]=1;ipattern3b[i][6]=1;
		}
		ipattern3b[0][6]=-1;ipattern3b[3][6]=-1;ipattern3b[8][6]=-1;ipattern3b[3][0]=-1;

		pgroup.add(ipattern3b);

		//C
		int[][] ipattern3c = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern3c[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 2; i <7;i++){
			ipattern3c[i][0]=1;
		}
		ipattern3c[1][1]=1;ipattern3c[7][1]=1;
		ipattern3c[0][2]=1;ipattern3c[0][3]=1;ipattern3c[0][4]=1;
		ipattern3c[8][2]=1;ipattern3c[8][3]=1;ipattern3c[8][4]=1;
		ipattern3c[1][5]=1;ipattern3c[7][5]=1;
		ipattern3c[2][6]=1;ipattern3c[6][6]=1;
		ipattern3c[0][6]=1;ipattern3c[1][6]=1;
		pgroup.add(ipattern3c);

		//D
		int[][] ipattern3d = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern3d[i][j]=-1;
			}//for j loop
		}//for i loop

		for(int i = 0 ; i < 5 ; i++){
			ipattern3d[0][i]=1;ipattern3d[8][i]=1;
		}
		for(int i = 0 ; i < 9 ; i++){
			ipattern3d[i][1]=1;
		}
		for(int i = 2 ; i < 7 ; i++){
			ipattern3d[i][6]=1;
		}
		ipattern3d[1][5]=1;ipattern3d[7][5]=1;
		pgroup.add(ipattern3d);

		//E
		int[][] ipattern3e = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern3e[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0 ; i < 9 ; i++){
			ipattern3e[i][1]=1;
		}
		for(int i = 0 ; i < 7 ; i++){
			ipattern3e[0][i]=1;ipattern3e[8][i]=1;
		}
		ipattern3e[3][2]=1;ipattern3e[3][3]=1;ipattern3e[3][4]=1;
		ipattern3e[2][4]=1;ipattern3e[4][4]=1;
		ipattern3e[1][6]=1;ipattern3e[7][6]=1;
		pgroup.add(ipattern3e);

		//J
		int[][] ipattern3j = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern3j[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0 ; i <8;i++){
			ipattern3j[i][5]=1;
		}

		ipattern3j[0][4]=1;ipattern3j[0][5]=1;ipattern3j[0][6]=1;
		ipattern3j[8][2]=1;ipattern3j[8][3]=1;ipattern3j[8][4]=1;
		ipattern3j[7][1]=1;ipattern3j[7][1]=1;
		pgroup.add(ipattern3j);

		//K
		int[][] ipattern3k = new int[9][7];
		for(int i = 0; i < 9 ; i++){
			for(int j = 0; j < 7 ; j++){
				ipattern3k[i][j]=-1;
			}//for j loop
		}//for i loop
		for(int i = 0; i<9;i++){
			ipattern3k[i][1] = 1;
		}
		for(int i = 0; i<3;i++){
			ipattern3k[0][i] = 1;ipattern3k[8][i] = 1;
		}
		ipattern3k[4][2] = 1;
		ipattern3k[3][3] = 1;ipattern3k[5][3] = 1;
		ipattern3k[2][4] = 1;ipattern3k[6][4] = 1;
		ipattern3k[1][5] = 1;ipattern3k[7][5] = 1;
		ipattern3k[0][5] = 1;ipattern3k[8][5] = 1;
		ipattern3k[0][6] = 1;ipattern3k[8][6] = 1;
		pgroup.add(ipattern3k);

	}//makepattern

	public void learning(){

		double temp;
		double[] d = new double[21];
		int min_index=0;
		
		int cnt = 0;
		int winner = 0;
		int n_min = 0;
		int n_max = 21;
		/*
		do{
			cnt = 0;
			
			for(int p = 0 ; p <21; p ++){
				for(int j = 0 ; j<21;j++){
					d[j]=0;
				}
				temp=0;
				for(int j = 0 ; j<21;j++){
					for(int i = 0; i <63 ; i++){
						temp = weights[i][j] - pgroup.get(p)[i/7][i%7];
						d[j] += temp*temp;
					}
				}



				for(int j = 0 ; j<21;j++){
					if(d[j]<d[winner]){
						winner = j;
					}
				}

				
				double dweight;
				for(int i = 0 ; i < 63; i ++){
					for(int j = 0 ;  j < 21; j++){
						dweight = a*(pgroup.get(p)[i/7][i%7] - weights[i][j]);
						if(dweight != 0){
							weights[i][j] += dweight;
							cnt++;
						}
						
					}
				}		
				cur_times++;
				a = 0.10*(1 - (double)(cur_times/Max_times));
			}
		}while(cnt ==0 );
		*/
		
		
		
		
		do{
			cnt = 0;
			//pattern cycle
			for(int p = 0; p < 21 ; p++){
				min_index=0;
				n_min = 0;
				n_max = 20;
				for(int j = 0 ; j<21;j++){
					d[j]=0;
				}
				temp=0;
				for(int j = 0 ; j<21;j++){
					for(int i = 0; i <63 ; i++){
						temp = weights[i][j] - pgroup.get(p)[i/7][i%7];
						d[j] += temp*temp;
					}
				}//distance calculation
				
				for(int j = 0 ; j<21;j++){
					if(d[j]<d[min_index]){
						min_index = j;
					}
				}
				
				if( n_min < min_index-distance){
					n_min = min_index - distance;
				}
				if(n_max>min_index+distance){
					n_max = min_index + distance;
				}
				
				for(int j = n_min; j < n_max ; j++){
					double dweight=0;
					for(int i = 0 ; i <63; i ++){
						dweight = a * (pgroup.get(j)[i/7][i%7] - weights[i][j]);
						if(dweight != 0 ){
							cnt++;
							weights[i][j] += dweight;
						}
					}
				}
				
				
			}//pattern cycle;
			
			a = 0.10*(1 - (double)(cur_times/Max_times));
			distance = 10*(1-(cur_times/Max_times));
			
			
			if(cur_times == Max_times){
				System.out.println("cur_times == Max_times");
			}
			if(cnt == 0){
				System.out.println("cnt == 0");
			}
			
		}while(cnt == 0 || cur_times == Max_times );
		
		
		
		
		//System.out.println("End of learning");
	}//learning


	public int[][] update(){

		double temp=0;
		double[] d = new double[21];
		int winner=0;


		for(int j = 0 ; j<21;j++){
			d[j]=0;
			for(int i = 0; i <63 ; i++){
				temp = weights[i][j] - input_p[i/7][i%7];
				d[j] += temp*temp;
			}
			System.out.println("d "+j+"	 : "+d[j]);
		}


		for(int j = 0 ; j<21;j++){
			if(d[j]<d[winner]){
				winner = j;
			}
		}

		for(int i = 0 ; i <9; i++){
			for(int j = 0; j <7 ; j++){
				input_p[i][j] = pgroup.get(winner)[i][j];
			}
		}

		return input_p;
	}//update



	public void add_noise(int font, int index, int noise){
		Random random = new Random(2);
		int temp;
		int pattern_index =  font*7 + index;
		for(int i = 0 ; i <9; i++){
			for(int j = 0; j <7 ; j++){
				temp = random.nextInt(100) + 1;
				if(temp < noise){
					input_p[i][j] = pgroup.get(pattern_index)[i][j] * (-1);
				}
				else{
					input_p[i][j] = pgroup.get(pattern_index)[i][j];
				}
			}
		}
	}//add_noise
	public int[][] getPattern(int font, int index){
		for(int i = 0 ; i <9; i++){
			for(int j = 0; j <7 ; j++){
				input_p[i][j] = pgroup.get(font*7+index)[i][j];
			}
		}
		return pgroup.get(font*7+index);
	}
	public int[][] getPattern(){
		return input_p;
	}


}
