package codingon.condingonspringbootjpa.repository;

import codingon.condingonspringbootjpa.dto.BoardDTO;
import codingon.condingonspringbootjpa.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> { // pk 가 id integer 니까 Integer 넣어줌
    // 게시글 제목으로 조회
    List<BoardEntity> findByTitle(String title);

    // 게시글 삭제
    Optional<BoardDTO> deleteById(int id);

    Optional<BoardEntity> findById(int id);
}
