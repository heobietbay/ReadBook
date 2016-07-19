package learn.spring.boot.repository;

import learn.spring.boot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 7/19/2016.
 */
@Repository
public interface ReadingListRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);
}
