
public class Shell {
	
	
	
	
	public void ShellSort1(int tabToSort[],int tabOdleg[]) {
		long time=System.currentTimeMillis();
		int n=tabToSort.length-1;
		int index=0;
		for(int w=0;w<tabOdleg.length;w++) {
			if(tabOdleg[w]>n) {
				index=w-1;
				break;
			}
		}
		for(int i=index;i>=0;i--) {		
			int gap=tabOdleg[i];
			for(int j=gap;j<=n;j++) {		// Okreœlam element który bêdê porónywa³ 
				int temp=tabToSort[j];
				
				int p;
				for(p=j; p>=gap && tabToSort[p-gap]>temp;p=p-gap ) {
					tabToSort[p]=tabToSort[p-gap];
				}
				tabToSort[p]=temp;
			}
			
		}
		time=System.currentTimeMillis()-time;
	     System.out.println("ShellSort1 czas to:"+time);
	}
	
	public void ShellSort2(int tabToSort[],int tabOdleg[]) {
		long time=System.currentTimeMillis();
		int n=tabToSort.length-1;
		int index=0;
		for(int w=0;w<tabOdleg.length;w++) {
			if(tabOdleg[w]>n) {
				index=w-1;
				break;
			}
		}
		for(int i=index;i>=0;i--) {
			int gap=tabOdleg[i];
			if(gap==1) {
				for (int k = 1; k <n+1; k++)
		            for (int q = 0; q < n-k; q++)
		                if (tabToSort[q] > tabToSort[q+1])
		                {
		                    // swap temp and arr[i]
		                    int temp1 = tabToSort[q];
		                    tabToSort[q] = tabToSort[q+1];
		                    tabToSort[q+1] = temp1;
		                }
			}
			else {
					
					
					for(int j=gap;j<=n;j++) {		// Okreœlam element który bêdê porónywa³ 
						int temp=tabToSort[j];
						
						int p;
						for(p=j; p>=gap && tabToSort[p-gap]>temp;p=p-gap ) {
							tabToSort[p]=tabToSort[p-gap];
						}
						tabToSort[p]=temp;
					}
					
				
			}
		}
		time=System.currentTimeMillis()-time;
	     System.out.println("ShellSort2 czas to:"+time);
	}
	
	public void ShellSort3(int tabToSort[],int tabOdleg[]) {
		long time=System.currentTimeMillis();
		int n=tabToSort.length-1;
		int index=0;
		for(int w=0;w<tabOdleg.length;w++) {
			if(tabOdleg[w]>n) {
				index=w-1;
				break;
			}
		}
		for(int i=index;i>=0;i--) {
			int gap=tabOdleg[i];
			if(gap==1) {
				for (int k=1; k<=n;k++) {
		        
		            int key = tabToSort[k];
		            int j = k-1;
		 
		            /* Move elements of arr[0..i-1], that are
		               greater than key, to one position ahead
		               of their current position */
		            while (j>=0 && tabToSort[j] > key){
		            
		            	tabToSort[j+1] = tabToSort[j];
		                j = j-1;
		            }
		            tabToSort[j+1] = key;
		        }
			}
			else {
				for(int pass=0;pass<n;pass++) {
					int right;
					for(int left=0;left<(n-pass) && (right=left+gap)<n+1;left++) { 
						//int right=left+gap;
						if(tabToSort[left]>tabToSort[right]) {
							int temp=tabToSort[left];
							tabToSort[left]=tabToSort[right];
							tabToSort[right]=temp;
						}
					}
				}
			}
		}
		time=System.currentTimeMillis()-time;
	     System.out.println("ShellSort3 czas to:"+time);
	}
	

}
