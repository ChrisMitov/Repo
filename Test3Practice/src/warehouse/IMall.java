package warehouse;

public interface IMall {
	void addProduct(Product p, int quantity) throws WarehouseException;
	void removeProduct(Product p, int quantity) throws WarehouseException;
	
}
