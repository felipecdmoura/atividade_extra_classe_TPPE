package app;

public class QuickSort {

	private int[] valores;

	private QuickSort(int[] valores) {
		this.valores = valores; 
	}

	public static QuickSort getInstancia(int[] valores) {
		return new QuickSort(valores);
	}

	public int getSize() {
		return valores.length;
	}

	public int[] ordenar(int left, int right) {
		
		if (left < right) {
			Particionamento parti = new Particionamento(left, right, valores);
			
			int indicePivot = parti.execute();
			ordenar(left, indicePivot -1);
			ordenar(indicePivot + 1, right);
		}
		return valores;
	}
}

class Particionamento {
	
	private int left, right;
	private int[] valores;
	
	private int pivot;
	private int i;

	public Particionamento(int left, int right, int[] valores){
		this.left = left;
		this.right = right;
		this.valores = valores;
	}

	private void init(){
		this.pivot = valores[left];
		this.i = left;
	}

	private void scan(){
		for (int j=i+1; j<=right; j++) {
			if (valores[j] <= pivot) {
				i++; 
				swap(i, j); 
			}
		}
	}

	private void swap(int i, int j) {
		int temp = valores[i];
		valores[i] = valores[j];
		valores[j] = temp;
	}

	public int execute(){
		this.init();

		this.scan();

		swap(left, i);
		return i;
	}
}	


