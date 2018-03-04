package dhbw.web;

import dhbw.pojo.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dennis Hoepfner
 */
@Stateless
@WebService(serviceName = "ProductService")
public class ProductService {

    //Connection to Entityclasses
    @PersistenceContext
    EntityManager em;
    
    //Method to get by id
    //Sample ID: 980005
    @WebMethod(operationName = "productById")
    public List<Product> productById (@WebParam(name = "productId") Integer productId) {
        return em.createNamedQuery("Product.findByProductId").setParameter("productId",productId).getResultList();
    }
    
    //Method to get all
    @WebMethod(operationName = "allProducts")
    public List<Product> allProducts () {
        return em.createNamedQuery("Product.findAll").getResultList();
    }
}
