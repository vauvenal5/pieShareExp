/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.dao;

import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *
 * @author richy
 */
public class TestDao
{
	
	
	/*
	 * to view database install:  sudo apt-get install sqlitebrowser
	 */
	
	JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("CREATE TABLE richystable (testENT char(50));");
	}
}
