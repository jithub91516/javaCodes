package CIT_242final;

public class DAOfactory
{
	// this method maps the ProductDAO interface
	// to the appropriate data storage mechanism
	public static ProductDAO getProductDAO()
	{
		ProductDAO pDAO = new ProductXMLFile();
		return pDAO;
	}
}