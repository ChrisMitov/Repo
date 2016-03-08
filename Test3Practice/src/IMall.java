
public interface IMall {

	void addProduct(Product p, int quantity) throws WarehouseException;

	void sellProduct(Product p, int quantity) throws WarehouseException;

}