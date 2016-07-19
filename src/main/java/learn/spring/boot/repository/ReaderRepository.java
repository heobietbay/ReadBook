package learn.spring.boot.repository;

import learn.spring.boot.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 7/19/2016.
 */
public interface ReaderRepository extends JpaRepository<Reader,String> {
}
