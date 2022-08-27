package entities;

public class ImportedProduct extends Product {
	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFree) {
		super(name, price);
		this.customsFee = customsFree;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFree(Double customsFree) {
		this.customsFee = customsFree;
	}
	
	public double totalPrice() {
		return getPrice() + getCustomsFee();
	}
	
	@Override
	public String priceTag() {
		return getName() 
				+ " $ " 
				+ String.format("%.2f",totalPrice()) + " (Customs fee: $ " 
				+ String.format("%.2f",getCustomsFee()) 
				+ ")";
	}
}
