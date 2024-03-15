package test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import test.beans.Staff;

public class StaffDao {

	JdbcTemplate t1;

	public void setT1(JdbcTemplate t1) {
		this.t1 = t1;
	}

	public int saveStaffData(Staff s1) {
		return t1.update("insert into staff (sname,semail,spass)values('" + s1.getSname() + "','" + s1.getSemail()
				+ "','" + s1.getSpass()+ "')");

	}

	public List<Staff> getStaffData() {
		return t1.query("select * from Staff", new RowMapper<Staff>() {
			@Override
			public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
				Staff staf = new Staff();
				staf.setSid(rs.getInt(1));
				staf.setSname(rs.getString(2));
				staf.setSemail(rs.getString(3));
				staf.setSpass(rs.getString(4));
				return staf;
			}
		});
	}

	public int delete(int id) {
		return t1.update("delete from staff where sid ='" + id + "'");
	}

	public Staff getStaffById(int id) {
		String query = "SELECT * FROM staff WHERE sid = ?";
		return t1.queryForObject(query, new Object[] { id }, new RowMapper<Staff>() {
			@Override
			public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
				Staff staff = new Staff();
				staff.setSid(rs.getInt(1));
				staff.setSname(rs.getString(2));
				staff.setSemail(rs.getString(3));
				staff.setSpass(rs.getString(4));
				return staff;
			}
		});
	}

	public int updateData(Staff staf) {
		return t1.update("update staff set sname='" + staf.getSname() + "',semail='" + staf.getSemail() + "',spass='"
				+ staf.getSpass() + "' where sid='" + staf.getSid() + "'");
	}
	

}
