import java.util.Optional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class Prac {

}

@Entity
@Table(name = "product-redis")
class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productName;
	private Double price;
	private Integer inventory;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	
}


interface ProductRepository extends JpaRepository<Product, Long>{
	
}


@Service
class productService{
	
	private final ProductRepository productRepository;
	public productService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Cacheable(value = "upstashProductCache", key="#id")
	public Product findProductById(Long id) {
		Optional<Product> prod = productRepository.findById(id);
		if(prod.isPresent()) return prod.get();
		throw new RuntimeException("prod with id did not found");
	}
	
	@CachePut(value = "upstashProductCache", key="#product.id")
	public Product updateProductDetails(Product product) {
		
		if(productRepository.existsById(product.getId()) == false)
			throw new RuntimeException("No such product with id");
		
		return productRepository.save(product);
	}
	
}