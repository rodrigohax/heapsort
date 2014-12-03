public class HeapSort
{
	private static int[] array;
	private static int n;
	private static int izq;
	private static int der;
	private static int largo;

	public static void crearHeap(int []array){
		n=array.length-1;
		for(int i=n/2;i>=0;i--){
			heapMaximo(array,i);
		}
	}

	public static void heapMaximo(int[] array, int i){
		izq=2*i;
		der=2*i+1;
		if(izq <= n && array[izq] > array[i]){
			largo=izq;
		}else{
			largo=i;
		}
		if(der <= n && array[der] > array[largo]){
			largo=der;
		}if(largo!=i){
			intercambio(i,largo);
			heapMaximo(array, largo);
		}
	}

	public static void intercambio(int i, int j){
		int t=array[i];
		array[i]=array[j];
		array[j]=t;
	}

	public static void ordenar(int [] arr){
		array=arr;
		crearHeap(array);
		for(int i=n;i>0;i--){
			intercambio(0, i);
			n=n-1;
			heapMaximo(array, 0);
		}
	}
	public static void main(String[] args) {
		int []arr={3,5,1,2,4,666,999,-666,-999};
		ordenar(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
}