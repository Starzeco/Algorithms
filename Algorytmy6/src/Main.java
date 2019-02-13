import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random k=new Random();
		int t=0;
		Sortowania s=new Sortowania();				
		
		/*for(int i=0;i<tab.length;i++) {
			tab[i]=k.nextInt();
		}
		for(int u=0;u<tab1.length;u++) {
			tab1[u]=u;
		}
		for(int j=10000;j>0;--j) {

			tab2[t]=j;
			t++;
			
		} */
		
		
		
		
		// TABLICE POMIESZANE 
		int tab1[]=new int[50000];
		int tab2[]=new int[50000];
		int tab3[]=new int[50000];
		int tab4[]=new int[50000];
		int tab5[]=new int[50000];
		int tab6[]=new int[50000];
		// TABLICE POSORTOWANE ROSNACO
		int tab7[]=new int[50000];
		int tab8[]=new int[50000];
		int tab9[]=new int[50000];
		int tab10[]=new int[50000];
		int tab11[]=new int[50000];
		int tab12[]=new int[50000];
		// TABLICE POSORTOWANE MALEJACO 
		int tab13[]=new int[50000];
		int tab14[]=new int[50000];
		int tab15[]=new int[50000];
		int tab16[]=new int[50000];
		int tab17[]=new int[50000];
		int tab18[]=new int[50000];
		
		/// WYPELNIANIE TABLIC ////
		
		for(int i=0;i<tab1.length;i++) {
			tab1[i]=k.nextInt();
			tab2[i]=k.nextInt();
			tab3[i]=k.nextInt();
			tab4[i]=k.nextInt();
			tab5[i]=k.nextInt();
			tab6[i]=k.nextInt();
		}
		for(int u=0;u<tab7.length;u++) {
			tab7[u]=u;
			tab8[u]=u;
			tab9[u]=u;
			tab10[u]=u;
			tab11[u]=u;
			tab12[u]=u;
		}
		for(int j=50000;j>0;--j) {
			tab13[t]=j;
			tab14[t]=j;
			tab15[t]=j;
			tab16[t]=j;
			tab17[t]=j;
			tab18[t]=j;
			t++;
			
		}
		
		//// SORTOWANIE //////
		
		s.InsertSort(tab1);
		s.InsertSort(tab7);
		s.InsertSort(tab13);
		System.out.println("InsertSort Koniec  ////////");
		s.SelectSort(tab2);
		s.SelectSort(tab8);
		s.SelectSort(tab14);
		System.out.println("SelectSort Koniec  ////////");
		s.BubbleSort(tab3);
		s.BubbleSort(tab9);
		s.BubbleSort(tab15);
		System.out.println("BubbleSort Koniec  ////////");
		s.QuickSort(tab4, 0, tab4.length-1);
		s.QuickSort(tab10, 0, tab10.length-1);
		s.QuickSort(tab16, 0, tab16.length-1);
		System.out.println("QuickSort Koniec  ////////");
		s.MergeSort(tab5, 0, tab5.length-1);
		s.MergeSort(tab11, 0, tab11.length-1);
		s.MergeSort(tab17, 0, tab17.length-1);
		System.out.println("MergeSort Koniec  ////////");
		s.HeapSort(tab6);
		s.HeapSort(tab12);
		s.HeapSort(tab18);
		System.out.println("HeapSort Koniec  ////////");
		
	/*	for(Integer p:tab5) {
			System.out.println(p);
		}
		for(Integer as:tab10) {
			System.out.println(as);
		}*/
		
		
					// MergeSort (int[] arr;0;arr.length-1)
					//QuickSort  arr[] --> Array to be sorted,
						//low  --> Starting index,
					//	high  --> Ending index
		

		
		//s.QuickSort(tab1, 0, tab1.length-1);
		//s.BubbleSort(tab1);
		//s.MergeSort(tab,0,tab.length-1);
		
	}

}
