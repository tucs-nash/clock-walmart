package com.walmart.clock.api.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.walmart.clock.api.core.model.ClockAngle;
import com.walmart.clock.api.repository.ClockDao;

@Repository 
public class ClockDaoImpl implements ClockDao {

	@Autowired private JdbcTemplate jdbcTemplate;

	@Override
	public ClockAngle getAngle(Long hour, Long minutes) {
		String getAngleSql = "SELECT angle FROM ANGLES WHERE hour = ? and minute = ?"; 
		
		List<ClockAngle> clockAngles = jdbcTemplate.query(getAngleSql, new RowMapper<ClockAngle>() {
			public ClockAngle mapRow(ResultSet rs, int arg1) throws SQLException {
				return new ClockAngle(rs.getLong("angle"));
			}
		}, hour, minutes);
		
		if(clockAngles.isEmpty()) {
			return null;
		}
		
		return clockAngles.get(0);
	}

	@Override
	public void addAngle(Long hour, Long minutes, Long angle) {
		String insertAngleSql = "INSERT INTO ANGLES (hour, minute, angle) VALUES (?,?,?)";		
		jdbcTemplate.update(insertAngleSql, hour, minutes, angle);
	}
	
}
