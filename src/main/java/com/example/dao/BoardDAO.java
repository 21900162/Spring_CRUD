package com.example.dao;

import com.example.bean.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class BoardDAO {

//
//    //Connection conn = null;
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
    private JdbcTemplate template;
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    private final String BOARD_INSERT = "insert into recipe (name, instruction) values (?,?)";
    private final String BOARD_UPDATE = "update recipe set name=?, instruction=? where id=?";
    private final String BOARD_DELETE = "delete from recipe  where id=?";
    private final String BOARD_GET = "select * from recipe  where id=?";
    private final String BOARD_LIST = "select * from recipe order by id desc";

    public int insertBoard(BoardVO vo) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        try {
            return template.update(BOARD_INSERT, new Object[]{vo.getName(), vo.getInstruction()});

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteBoard(int id) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        try {
            return template.update(BOARD_DELETE, new Object[]{id});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int updateBoard(BoardVO vo) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        try {
            return template.update(BOARD_UPDATE,
                    new Object[]{vo.getName(), vo.getInstruction(), vo.getId()});

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public BoardVO getBoard(int id) {
        return template.queryForObject(BOARD_GET,
                new Object[]{id},
                new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    public List<BoardVO> getBoardList(){
        return template.query(BOARD_LIST, new RowMapper<BoardVO>() {

            @Override
            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVO data = new BoardVO();
                data.setId(rs.getInt("id"));
                data.setName(rs.getString("name"));
                data.setInstruction(rs.getString("instruction"));
                return data;
            }
        });
    }


}

