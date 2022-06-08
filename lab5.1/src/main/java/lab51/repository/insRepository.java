package lab51.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import lab51.insect.Insect;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface insRepository extends JpaRepository<Insect, Integer>{

}
