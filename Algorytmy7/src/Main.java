import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Shell s=new Shell();
		Random k=new Random();
	
		
		int h1=1;
		int k1=1;
		int k2=1;
		
		int f0=0;
		int f1=1;
		
		
		//////// TABLICE Z ODLEG£OŒCIAMI ///////////
		int tabOdleg1[]=new int[100003]; 	// h1=1 ,  h(i+1)=3hi+1
		int tabOdleg2[]=new int[100003];	// 2k-1  przy k1=1
		int tabOdleg3[]=new int[100003];	// 2k+1  przy k1=0
		int tabOdleg4[]=new int[100003];	// Liczby Fibonacciego  Dla n>1  F(n-1)+F(n-2)
		int tabOdleg5[]=new int[100003]; 
		
		int tabOdleg6[]=new int[100003];
		
		int kasp=(tabOdleg5.length-1)/2;
		int ha=1;
		/////// WYPELNIANIE TABLIC Z ODLEGLOSCIAMI //////////
		
		for(int i=0;i<tabOdleg1.length;i++) {
			
			tabOdleg1[i]=h1;
			h1=3*h1+1;
		}
		for(int i=0;i<tabOdleg2.length;i++) {
			
			tabOdleg2[i]=(int)(Math.pow(2,k1))-1;
			k1=k1+1;
		}
		for(int i=0;i<tabOdleg3.length-1;i++) {
			tabOdleg3[0]=1;
			tabOdleg3[i+1]=(int)(Math.pow(2,k2))+1;
			k2=k2+1;
			
		}
		for(int i=0;i<tabOdleg4.length;i++) {
			if(i==0) {
				tabOdleg4[i]=f0;
			}
			if(i==1) {
				tabOdleg4[i]=f1;
			}
			else {
				int y=f1+f0;
				tabOdleg4[i]=y;
				f0=f1;
				f1=y;
			}
			
		}
		for(int i=tabOdleg5.length-1;i>=0;i--) {
			tabOdleg5[i]=kasp;
			kasp=3*kasp/4;
		}
		for(int i=0;i<tabOdleg6.length;i++) {
			int yu=tabOdleg5.length-1;
			tabOdleg6[i]=tabOdleg5[yu];
		}
		
	
		/////////// TABLICE DO SORTOWANIA /////////////
		
			/////5000 Elementów ///////
		int tab1[]=new int[5000];
		int tab2[]=new int[5000];
		int tab3[]=new int[5000];
		int tab4[]=new int[5000];
		int tab5[]=new int[5000];
		int tab6[]=new int[5000];
		int tab7[]=new int[5000];
		int tab8[]=new int[5000];
		int tab9[]=new int[5000];
		int tab10[]=new int[5000];
		int tab11[]=new int[5000];
		int tab12[]=new int[5000];
		
		int tab13[]=new int[5000];
		
			/////10,000 Elementow//////
		int tab1a[]=new int[10000];
		int tab2a[]=new int[10000];
		int tab3a[]=new int[10000];
		int tab4a[]=new int[10000];
		int tab5a[]=new int[10000];
		int tab6a[]=new int[10000];
		int tab7a[]=new int[10000];
		int tab8a[]=new int[10000];
		int tab9a[]=new int[10000];
		int tab10a[]=new int[10000];
		int tab11a[]=new int[10000];
		int tab12a[]=new int[10000];
		
		int tab13a[]=new int[10000];
			/////50,000 Elementow ////
		int tab1b[]=new int[50000];
		int tab2b[]=new int[50000];
		int tab3b[]=new int[50000];
		int tab4b[]=new int[50000];
		int tab5b[]=new int[50000];
		int tab6b[]=new int[50000];
		int tab7b[]=new int[50000];
		int tab8b[]=new int[50000];
		int tab9b[]=new int[50000];
		int tab10b[]=new int[50000];
		int tab11b[]=new int[50000];
		int tab12b[]=new int[50000];
		
		int tab13b[]=new int[50000];
			///// 100,000 Elementów//////
		
		int tab1c[]=new int[100000];
		int tab2c[]=new int[100000];
		int tab3c[]=new int[100000];
		int tab4c[]=new int[100000];
		int tab5c[]=new int[100000];
		int tab6c[]=new int[100000];
		int tab7c[]=new int[100000];
		int tab8c[]=new int[100000];
		int tab9c[]=new int[100000];
		int tab10c[]=new int[100000];
		int tab11c[]=new int[100000];
		int tab12c[]=new int[100000];
		
		int tab13c[]=new int [100000];
		int tab16[]=new int[100000];
		////// WYPELNIENIE TABLIC DO SORTOWANIA ///////
		
		for(int i=0;i<tab1.length;i++) {
			 tab1[i]=k.nextInt();
			 tab2[i]=k.nextInt();
			 tab3[i]=k.nextInt();
			 tab4[i]=k.nextInt();
			 tab5[i]=k.nextInt();
			 tab6[i]=k.nextInt();
			 tab7[i]=k.nextInt();
			 tab8[i]=k.nextInt();
			 tab9[i]=k.nextInt();
			 tab10[i]=k.nextInt();
			 tab11[i]=k.nextInt();
			 tab12[i]=k.nextInt();
			 
			 tab13[i]=k.nextInt();
			 
			}
		for(int i=0;i<tabOdleg5.length;i++) {
			tabOdleg5[i]=ha;
			ha=ha*6/4;
		}
		for(int i=0;i<tab1a.length;i++) {
			 tab1a[i]=k.nextInt();
			 tab2a[i]=k.nextInt();
			 tab3a[i]=k.nextInt();
			 tab4a[i]=k.nextInt();
			 tab5a[i]=k.nextInt();
			 tab6a[i]=k.nextInt();
			 tab7a[i]=k.nextInt();
			 tab8a[i]=k.nextInt();
			 tab9a[i]=k.nextInt();
			 tab10a[i]=k.nextInt();
			 tab11a[i]=k.nextInt();
			 tab12a[i]=k.nextInt();
			 
			 tab13a[i]=k.nextInt();
		}
		for(int i=0;i<tab1b.length;i++) {
			 tab1b[i]=k.nextInt();
			 tab2b[i]=k.nextInt();
			 tab3b[i]=k.nextInt();
			 tab4b[i]=k.nextInt();
			 tab5b[i]=k.nextInt();
			 tab6b[i]=k.nextInt();
			 tab7b[i]=k.nextInt();
			 tab8b[i]=k.nextInt();
			 tab9b[i]=k.nextInt();
			 tab10b[i]=k.nextInt();
			 tab11b[i]=k.nextInt();
			 tab12b[i]=k.nextInt();
			 
			 tab13b[i]=k.nextInt();
		}
		for(int i=0;i<tab1c.length;i++) {
			 tab1c[i]=k.nextInt();
			 tab2c[i]=k.nextInt();
			 tab3c[i]=k.nextInt();
			 tab4c[i]=k.nextInt();
			 tab5c[i]=k.nextInt();
			 tab6c[i]=k.nextInt();
			 tab7c[i]=k.nextInt();
			 tab8c[i]=k.nextInt();
			 tab9c[i]=k.nextInt();
			 tab10c[i]=k.nextInt();
			 tab11c[i]=k.nextInt();
			 tab12c[i]=k.nextInt();
			 tab13c[i]=k.nextInt();
			 tab16[i]=k.nextInt();
			 
		}
		
		//////// Sortowanie Pierwsze  ////////
	/*	System.out.println("////////////// Sortowanie 1 /////////////////");
		s.ShellSort1(tab1, tabOdleg1);
		s.ShellSort1(tab1a, tabOdleg1);
		s.ShellSort1(tab1b, tabOdleg1);
		s.ShellSort1(tab1c, tabOdleg1);
		System.out.println("/// Koniec Dla Odl1 /////");
		s.ShellSort1(tab2, tabOdleg2);
		s.ShellSort1(tab2a, tabOdleg2);
		s.ShellSort1(tab2b, tabOdleg2);
		s.ShellSort1(tab2c, tabOdleg2);
		System.out.println("/// Koniec Dla Odl2 /////");
		s.ShellSort1(tab3, tabOdleg3);
		s.ShellSort1(tab3a, tabOdleg3);
		s.ShellSort1(tab3b, tabOdleg3);
		s.ShellSort1(tab3c, tabOdleg3);
		System.out.println("/// Koniec Dla Odl3 /////");
		s.ShellSort1(tab4, tabOdleg4);
		s.ShellSort1(tab4a, tabOdleg4);
		s.ShellSort1(tab4b, tabOdleg4);
		s.ShellSort1(tab4c, tabOdleg4);
		System.out.println("/// Koniec Dla Odl4 /////"); 

		
		System.out.println("////////////// Sortowanie 2 /////////////////");
		s.ShellSort2(tab5, tabOdleg1);
		s.ShellSort2(tab5a, tabOdleg1);
		s.ShellSort2(tab5b, tabOdleg1);
		s.ShellSort2(tab5c, tabOdleg1);
		System.out.println("/// Koniec Dla Odl1 /////");
		s.ShellSort2(tab6, tabOdleg2);
		s.ShellSort2(tab6a, tabOdleg2);
		s.ShellSort2(tab6b, tabOdleg2);
		s.ShellSort2(tab6c, tabOdleg2);
		System.out.println("/// Koniec Dla Odl2 /////");
		s.ShellSort2(tab7, tabOdleg3);
		s.ShellSort2(tab7a, tabOdleg3);
		s.ShellSort2(tab7b, tabOdleg3);
		s.ShellSort2(tab7c, tabOdleg3);
		System.out.println("/// Koniec Dla Odl3 /////");
		s.ShellSort2(tab8, tabOdleg4);
		s.ShellSort2(tab8a, tabOdleg4);
		s.ShellSort2(tab8b, tabOdleg4);
		s.ShellSort2(tab8c, tabOdleg4);
		System.out.println("/// Koniec Dla Odl4 /////"); 
		
		
		System.out.println("////////////// Sortowanie 3 /////////////////");
		s.ShellSort3(tab9, tabOdleg1);
		s.ShellSort3(tab9a, tabOdleg1);
		s.ShellSort3(tab9b, tabOdleg1);
		s.ShellSort3(tab9c, tabOdleg1);
		System.out.println("/// Koniec Dla Odl1 /////"); 
		s.ShellSort3(tab10, tabOdleg2);
		s.ShellSort3(tab10a, tabOdleg2);
		s.ShellSort3(tab10b, tabOdleg2);
		s.ShellSort3(tab10c, tabOdleg2);
		System.out.println("/// Koniec Dla Odl2 /////");
		s.ShellSort3(tab11, tabOdleg3);
		s.ShellSort3(tab11a, tabOdleg3);
		s.ShellSort3(tab11b, tabOdleg3);
		s.ShellSort3(tab11c, tabOdleg3);
		System.out.println("/// Koniec Dla Odl3 /////");
		s.ShellSort3(tab12, tabOdleg4);
		s.ShellSort3(tab12a, tabOdleg4);
		s.ShellSort3(tab12b, tabOdleg4);
		s.ShellSort3(tab12c, tabOdleg4);
		System.out.println("/// Koniec Dla Odl4 /////");  */
		
		System.out.println("////////////// Sortowanie Dodatkowe /////////////////");
		s.ShellSort1(tab13, tabOdleg5);
		s.ShellSort1(tab13a, tabOdleg5);
		s.ShellSort1(tab13b, tabOdleg5);
		s.ShellSort1(tab16, tabOdleg5); 
		
		/*for(Integer re:tabOdleg5) {
			System.out.println(re);
		}
		*/
	}

}
