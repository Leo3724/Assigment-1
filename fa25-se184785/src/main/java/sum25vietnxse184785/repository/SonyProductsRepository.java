package sum25vietnxse184785.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25vietnxse184785.pojo.SonyProduct;

@Repository
public interface SonyProductsRepository extends JpaRepository<SonyProduct, Integer> {
}
