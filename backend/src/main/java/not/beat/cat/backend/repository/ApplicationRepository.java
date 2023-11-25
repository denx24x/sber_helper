package not.beat.cat.backend.repository;

import not.beat.cat.backend.model.Application;
import not.beat.cat.backend.model.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT app FROM Application app WHERE app.status in (:statuses)")
    List<Application> findAllByStatuses(@Param("statuses") Set<ApplicationStatus> statuses);
}
