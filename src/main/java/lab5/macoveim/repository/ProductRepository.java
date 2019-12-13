package lab5.macoveim.repository;

import lab5.macoveim.model.Employee;
import lab5.macoveim.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT* FROM product",
                (response, rowNumber) ->
                        new Product(response.getLong("id_product"),
                                response.getLong("id_organisation"),
                                response.getString("name_product"),
                                response.getDouble("weight"),
                                response.getDouble("price")));
    }

    public void save(Product product) {
        jdbcTemplate.update("INSERT  INTO product (id_organisation,name_product,weight,price    VALUES ?,?,?,?)",
                product.getOrganisationID(), product.getName(), product.getName(), product.getWeight(), product.getPrice());

    }

    public Product findById(long productId) {
        return jdbcTemplate.queryForObject("SELECT *FROM  product WHERE id_product=? ", new Object[]{productId},
                (response, rowNum) -> new Product(response.getLong("id_product"),
                        response.getLong("id_organisation"),
                        response.getString("name_product"),
                        response.getDouble("weight"),
                        response.getDouble("price")));
    }

    public void delete(long id_product) {
        jdbcTemplate.update("DELETE * FROM product WHERE id_product= ?", id_product);
    }

    public void update(Product product) {
        jdbcTemplate.update("UPDATE product SET id_organisation= ? , name_product= ? , weight= ? , price=? , WHERE id_product= ?",
                product.getOrganisationID(), product.getName(), product.getWeight(), product.getPrice(), product.getId());
    }

    public List<Product> findByOrgId(long prodId) {
        return jdbcTemplate.query(
                "SELECT* FROM product where id_product =?", new Object[]{prodId},
                (response, rowNumber) ->
                        new Product(response.getLong("id_product"),
                                response.getLong("id_organisation"),
                                response.getString("name_product"),
                                response.getDouble("weight"),
                                response.getDouble("price")));
    }
}