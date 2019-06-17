package containers;

public class Produto implements Comparable<Produto>{
	private String id;
	private double volume;
	private double peso;
	private double lucro;        
        
	public Produto(String numProduto, double volume, double peso, double lucro) {
		this.id = numProduto;
		this.volume = volume;
		this.peso = peso;
		this.lucro = lucro;
	}
	
	public String getNumProduto() {
		return id;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getLucro() {
		return lucro;
	}
	
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof Produto) {
			obj = (Produto) obj;
			flag = this.id.equals(((Produto) obj).id);
		}
		return flag;
	}

	@Override
	public int compareTo(Produto obj) {
		if(this.peso > obj.peso)
			return 1;
		else if(this.peso < obj.peso)
			return -1;  
		return 0;
	}
}