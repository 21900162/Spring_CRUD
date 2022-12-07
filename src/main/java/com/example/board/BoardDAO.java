package com.example.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {

    //
//    //Connection conn = null;
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
    @Autowired
    SqlSession sqlSession;

//    private final String BOARD_INSERT = "insert into recipe (category, name, instruction) values (?,?,?)";
//    private final String BOARD_UPDATE = "update recipe set category=?, name=?, instruction=? where id=?";
//    private final String BOARD_DELETE = "delete from recipe  where id=?";
//    private final String BOARD_GET = "select * from recipe  where id=?";
//    private final String BOARD_LIST = "select * from recipe order by id desc";

    public int insertBoard(BoardVO vo) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        int result = sqlSession.insert("Board.insertBoard", vo);
        return result;
    }

    public int deleteBoard(int id) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
//        try {
//            return template.update(BOARD_DELETE, new Object[]{id});
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
        int result = sqlSession.delete("Board.deleteBoard",id);
        return result;
    }

    public int updateBoard(BoardVO vo) {
//        System.out.println("===> JDBC로 updateBoard() 기능 처리");
//        try {
//            return template.update(BOARD_UPDATE,
//                    new Object[]{vo.getCategory(), vo.getName(), vo.getInstruction(), vo.getId()});
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
        int result = sqlSession.update("Board.updateBoard", vo);
        return result;
    }

    public BoardVO getBoard(int id) {
        BoardVO one = sqlSession.selectOne("Board.getBoard", id);
        return one;
//        return template.queryForObject(BOARD_GET,
//                new Object[]{id},
//                new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    public List<BoardVO> getBoardList(){
        List<BoardVO> list = sqlSession.selectList("Board.getBoardList");
        return list;

//        return template.query(BOARD_LIST, new RowMapper<BoardVO>() {
//
//            @Override
//            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//                BoardVO data = new BoardVO();
//                data.setId(rs.getInt("id"));
//                data.setCategory(rs.getString("category"));
//                data.setName(rs.getString("name"));
//                data.setInstruction(rs.getString("instruction"));
//                data.setRegdate(rs.getDate("regdate"));
//                return data;
//            }
//        });
    }


}

