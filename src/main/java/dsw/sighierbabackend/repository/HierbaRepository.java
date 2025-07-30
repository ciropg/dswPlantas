package dsw.sighierbabackend.repository;
import dsw.sighierbabackend.entity.Hierba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HierbaRepository extends JpaRepository<Hierba, Long> {
}
