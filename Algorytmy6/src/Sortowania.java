import java.util.Random;

public class Sortowania {

	
	
	public void SelectSort(int arr[]) {
		long time=System.currentTimeMillis();
		  int n = arr.length;
		  
	        // One by one move boundary of unsorted subarray
	        for (int i = 0; i < n-1; i++)
	        {
	            // Find the minimum element in unsorted array
	            int min_idx = i;
	            for (int j = i+1; j < n; j++)
	                if (arr[j] < arr[min_idx])
	                    min_idx = j;
	 
	            // Swap the found minimum element with the first
	            // element
	            int temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	        }
	     time=System.currentTimeMillis()-time;
	     System.out.println("SelectionSort czas to:"+time);
	}
	public void BubbleSort(int arr[]) {
		long time=System.currentTimeMillis();
		 int n = arr.length;
	        for (int i = 0; i < n-1; i++)
	            for (int j = 0; j < n-i-1; j++)
	                if (arr[j] > arr[j+1])
	                {
	                    // swap temp and arr[i]
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	        time=System.currentTimeMillis()-time; 
	        System.out.println("BubbleSort czas to:"+time);
	}
	public void InsertSort(int arr[]) {
		long time=System.currentTimeMillis();
		 int n = arr.length;
	        for (int i=1; i<n; ++i)
	        {
	            int key = arr[i];
	            int j = i-1;
	 
	            /* Move elements of arr[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            while (j>=0 && arr[j] > key)
	            {
	                arr[j+1] = arr[j];
	                j = j-1;
	            }
	            arr[j+1] = key;
	        }
	        time=System.currentTimeMillis()-time; 
	        System.out.println("InsertSort czas to:"+time);
	}
	public void MergeSort1(int arr[],int l,int m, int r) {
		
		 // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
	}
	public void MergeSort2(int arr[],int l, int r) {
		
		 if (l < r)
	        {
	            // Find the middle point
	            int m = (l+r)/2;
	 
	            // Sort first and second halves
	            MergeSort2(arr, l, m);
	            MergeSort2(arr , m+1, r);
	 
	            // Merge the sorted halves
	            MergeSort1(arr, l, m, r);
	        }
		 
	}
	public void MergeSort(int arr[],int l, int r) {
		long time=System.currentTimeMillis();
		MergeSort2(arr,l,r);
		time=System.currentTimeMillis()-time; 
		System.out.println("MergeSort czas to:"+time);
		
	}
	public int QuickSort1(int arr[], int low, int high) {
		Random as=new Random();
		//int pivot = arr[high]; 
		int pivot=arr[as.nextInt(high)];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
		
	}
	public void QuickSort2(int arr[], int low, int high) {
		//long time=System.currentTimeMillis();
		 if (low < high)
	        {
	            /* pi is partitioning index, arr[pi] is 
	              now at right place */
	            int pi = QuickSort1(arr, low, high);
	 
	            // Recursively sort elements before
	            // partition and after partition
	            QuickSort2(arr, low, pi-1);
	            QuickSort2(arr, pi+1, high);
	        }
		//time=System.currentTimeMillis()-time;
		//System.out.println("QuickSort czas to:"+time);
	}
	public void QuickSort(int arr[], int low, int high) {
		long time=System.currentTimeMillis();
		QuickSort2(arr,low,high);
		time=System.currentTimeMillis()-time;
		System.out.println("QuickSort czas to:"+time);
		
		
	}
	public void HeapSort1(int arr[], int n, int i) {
		
		 int largest = i;  // Initialize largest as root
	        int l = 2*i + 1;  // left = 2*i + 1
	        int r = 2*i + 2;  // right = 2*i + 2
	 
	        // If left child is larger than root
	        if (l < n && arr[l] > arr[largest])
	            largest = l;
	 
	        // If right child is larger than largest so far
	        if (r < n && arr[r] > arr[largest])
	            largest = r;
	 
	        // If largest is not root
	        if (largest != i)
	        {
	            int swap = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = swap;
	 
	            // Recursively heapify the affected sub-tree
	            HeapSort1(arr, n, largest);
	        }
	}
	public void HeapSort(int arr[]) {
		long time=System.currentTimeMillis();
		int n = arr.length;
		 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            HeapSort1(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            HeapSort1(arr, i, 0);
        }
        time=System.currentTimeMillis()-time;
        System.out.println("HeapSort czas to:"+time);
	}
}
