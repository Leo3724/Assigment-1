package sum25vietnxse184785.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25vietnxse184785.pojo.SonyAccount;

@Repository
public interface SonyAccountsRepository extends JpaRepository<SonyAccount, Long> {
}
