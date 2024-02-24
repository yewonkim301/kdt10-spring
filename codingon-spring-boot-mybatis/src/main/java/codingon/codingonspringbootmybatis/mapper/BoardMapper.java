package codingon.codingonspringbootmybatis.mapper;

import codingon.codingonspringbootmybatis.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> retrieveAll();

    @Select("select * from board where title=#{title}")
    Board findBoard(String title);

    @Insert("insert into board(title, content, writer) values(#{title}, #{content}, #{writer})")
    void insertBoard(Board board);

    @Update("update board set title=#{title}, content=#{content}, writer=#{writer} where id=#{id}")
    void updateBoard(Board board);

    @Delete("delete from board where id=#{id}")
    void deleteBoard(Board board);
}
