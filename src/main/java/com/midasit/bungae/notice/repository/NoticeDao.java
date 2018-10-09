package com.midasit.bungae.notice.repository;

import com.midasit.bungae.admin.dto.Notice;
import com.midasit.bungae.generator.mapper.NoticeMapper;
import com.midasit.bungae.user.Gender;
import com.midasit.bungae.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
@Transactional
public class NoticeDao implements NoticeRepository {
    @Autowired
    NoticeMapper noticeMapper;

    private JdbcTemplate jdbcTemplate;

    private RowMapper<Notice> noticeRowMapper = new RowMapper<Notice>() {
        public Notice mapRow(ResultSet rs, int i) throws SQLException {
            Notice notice = new Notice(rs.getInt("noticeNo"),
                    rs.getString("noticeTitle"),
                    rs.getString("noticePassword"),
                    rs.getString("noticeImage"),
                    rs.getString("noticeContent"),
                    new User(rs.getInt("userNo"),
                            rs.getString("userId"),
                            rs.getString("userPassword"),
                            rs.getString("userName"),
                            rs.getString("userEmail"),
                            Gender.valueOf(rs.getInt("userGender"))));

            return notice;
        }
    };

    public NoticeDao() { }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Notice> getAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public Notice get(int no) {
        return noticeMapper.selectByNo(no);
    }

    @Override
    public int add(Notice notice) {
        noticeMapper.insert(notice);

        return notice.getNo();
    }

    @Override
    public void update(Notice notice) {
        noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public void delete(Integer noticeNo) {
        noticeMapper.deleteByPrimaryKey(noticeNo);
    }
}
