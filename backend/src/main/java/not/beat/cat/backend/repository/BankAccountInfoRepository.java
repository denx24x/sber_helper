package not.beat.cat.backend.repository;

import not.beat.cat.backend.model.BankAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountInfoRepository extends JpaRepository<BankAccountInfo, Long> {

}
