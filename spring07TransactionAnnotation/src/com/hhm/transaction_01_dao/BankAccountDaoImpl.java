package com.hhm.transaction_01_dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hhm.transaction_01_domain.BankAccount;

/**
 * 银行接口的实现类，在这里实现增删改查的操作
 * 
 * @author 黄帅哥
 * 
 */
@Repository("bankDao")
public class BankAccountDaoImpl implements IBankAccountDao {

	// 利用beans.xml获取操作数据库的对象
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate = null;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 增
	 */
	public void addBankAccount(BankAccount bankAccount) {
		// 准备sql语句
		String sql = "insert into bankAccount(userName,accountNumber) values(?,?)";
		// 准备参数
		Object[] args = { bankAccount.getUserName(),
				bankAccount.getAccountNumber() };

		// 插入数据库
		this.getJdbcTemplate().update(sql, args);
	}

	/**
	 * 删
	 */
	public void deleteBankAccount(BankAccount bankAccount) {
		// 准备sql语句
		String sql = "delete from bankAccount where userName=?";
		// 准备参数
		Object[] args = { bankAccount.getUserName() };

		// 插入数据库
		this.getJdbcTemplate().update(sql, args);

	}

	/**
	 * 改
	 */
	public void updateBankAccount(BankAccount bankAccount) {
		// 准备sql语句
		String sql = "update bankAccount set accountNumber=? where userName=?";
		// 准备参数
		Object[] args = { bankAccount.getAccountNumber(),bankAccount.getUserName() };

		// 插入数据库
		this.getJdbcTemplate().update(sql, args);
	}

	/**
	 * 查询全部
	 */
	public List<BankAccount> queryAllBankAccount() {
		// 准备sql语句
		String sql = "select * from bankAccount";

		// 准备存储数据的行容器
		RowMapper<BankAccount> rowMapper = new RowMapper<BankAccount>() {

			public BankAccount mapRow(ResultSet rs, int row)
					throws SQLException {
				// 一个一个的返回
				BankAccount bankAccount = new BankAccount();
				bankAccount.setUserName(rs.getString("userName"));
				bankAccount.setAccountNumber(rs.getDouble("accountNumber"));
				return bankAccount;
			}
		};

		// 获取返回数据的链表
		List<BankAccount> bankAccountList = this.getJdbcTemplate().query(sql,
				rowMapper);

		return bankAccountList;
	}

	/**
	 * 根据用户名查询
	 */
	public BankAccount queryBankAccountByName(String userName) {
		// 准备sql语句
		String sql = "select * from bankAccount where userName=?";
		//准备参数
		Object[] args={userName};
		
		// 准备存储数据的行容器
		RowMapper<BankAccount> rowMapper = new RowMapper<BankAccount>() {

			public BankAccount mapRow(ResultSet rs, int row)
					throws SQLException {
				// 一个一个的返回
				BankAccount bankAccount = new BankAccount();
				bankAccount.setUserName(rs.getString("userName"));
				bankAccount.setAccountNumber(rs.getDouble("accountNumber"));
				return bankAccount;
			}
		};
		
		BankAccount bankAccount=this.getJdbcTemplate().query(sql, args, rowMapper).get(0);
		return bankAccount;
	}

}
