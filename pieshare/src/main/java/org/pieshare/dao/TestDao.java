/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *
 * @author richy
 */
public class TestDao
{
	JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
}
