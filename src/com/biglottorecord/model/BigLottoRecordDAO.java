package com.biglottorecord.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.util.sql.RunSQLForOracle;


public class BigLottoRecordDAO implements BigLottoRecordDAO_interface{

	private static javax.sql.DataSource dataSource= null;
	static {
		try {
			javax.naming.Context context = new javax.naming.InitialContext();
			dataSource = (javax.sql.DataSource)context.lookup("java:comp/env/jdbc/inkpainting");
		}catch(javax.naming.NamingException e) {
			e.printStackTrace();
		}
	}
	private String createSQLForOracle;
	private List<String> propertyContentList;
	
	private final String INSERT_SQL = "insert into BigLottoRecord"
			+ " ( gameRecordNo, gameNo, gameLotteryDate, number1, number2, number3, number4, number5, number6, specialNumber)"
			+ " values (?,?,?,?,?,?,?,?,?,?)";
	


	private final String UPDATE_SQL = "update BigLottoRecord set gameNo = ?, gameLotteryDate = ?,"
	+ " number1 = ?, number2 = ?, number3 = ?, number4 = ?, number5 = ?, number6 = ?, specialNumber = ?"
	+ " where gameRecordNo = ?";



	private final String FIND_ONE_BY_PK_SQL = "Select * from bigLottoRecord where gamerecordno = ?";
	private final String GET_ALL_SQL = "Select * from bigLottoRecord order by gameRecordNo ASC";



	private void setPropertyContentList(BigLottoRecordVO bigLottoRecordVO) {
		propertyContentList = new LinkedList<>();
		propertyContentList.add(" '"+bigLottoRecordVO.getGameRecordNo()+"'");
		propertyContentList.add(" '"+bigLottoRecordVO.getGameNo()+"'");
		propertyContentList.add(" to_date('"+bigLottoRecordVO.getGameLotteryDate().toString()+"','yyyy-MM-dd')");
		propertyContentList.add(" "+bigLottoRecordVO.getNumber1().toString());
		propertyContentList.add(" "+bigLottoRecordVO.getNumber2().toString());
		propertyContentList.add(" "+bigLottoRecordVO.getNumber3().toString());
		propertyContentList.add(" "+bigLottoRecordVO.getNumber4().toString());
		propertyContentList.add(" "+bigLottoRecordVO.getNumber5().toString());
		propertyContentList.add(" "+bigLottoRecordVO.getNumber6().toString());
		propertyContentList.add(" "+bigLottoRecordVO.getSpecialNumber().toString());
	}
	private List<String> getPropertyContentList(){
		return propertyContentList;
	}
	@Override
	public void insert(BigLottoRecordVO bigLottoRecordVO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, bigLottoRecordVO.getGameRecordNo());
			preparedStatement.setString(2, bigLottoRecordVO.getGameNo());
			preparedStatement.setDate(3, bigLottoRecordVO.getGameLotteryDate());
			preparedStatement.setInt(4, bigLottoRecordVO.getNumber1());
			preparedStatement.setInt(5, bigLottoRecordVO.getNumber2());
			preparedStatement.setInt(6, bigLottoRecordVO.getNumber3());
			preparedStatement.setInt(7, bigLottoRecordVO.getNumber4());
			preparedStatement.setInt(8, bigLottoRecordVO.getNumber5());
			preparedStatement.setInt(9, bigLottoRecordVO.getNumber6());
			preparedStatement.setInt(10, bigLottoRecordVO.getSpecialNumber());
			int i = preparedStatement.executeUpdate();
			
			this.setPropertyContentList(bigLottoRecordVO);
			createSQLForOracle = RunSQLForOracle.createRunSQL(INSERT_SQL, propertyContentList);
	System.out.println(createSQLForOracle);
			if(i==1) {
				System.out.println("---輸入成功---");
			}else {
				System.out.println("---輸入失敗---");
			}
		} catch (SQLException e) {
			throw new RuntimeException("DataBase Error "+e.getMessage());
		} finally {
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(BigLottoRecordVO bigLottoRecordVO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, bigLottoRecordVO.getGameNo());
			preparedStatement.setDate(2, bigLottoRecordVO.getGameLotteryDate());
			preparedStatement.setInt(3, bigLottoRecordVO.getNumber1());
			preparedStatement.setInt(4, bigLottoRecordVO.getNumber2());
			preparedStatement.setInt(5, bigLottoRecordVO.getNumber3());
			preparedStatement.setInt(6, bigLottoRecordVO.getNumber4());
			preparedStatement.setInt(7, bigLottoRecordVO.getNumber5());
			preparedStatement.setInt(8, bigLottoRecordVO.getNumber6());
			preparedStatement.setInt(9, bigLottoRecordVO.getSpecialNumber());
			preparedStatement.setString(10, bigLottoRecordVO.getGameRecordNo());
			int i = preparedStatement.executeUpdate();
			
			this.setPropertyContentList(bigLottoRecordVO);
			LinkedList<String> linkedList = (LinkedList<String>)this.getPropertyContentList();
			linkedList.add(linkedList.removeFirst());
			createSQLForOracle = RunSQLForOracle.createRunSQL(UPDATE_SQL, propertyContentList);
	System.out.println(createSQLForOracle);
			if(i==1) {
				System.out.println("---更新成功---");
			}else {
				System.out.println("---更新失敗---");
			}
		} catch (SQLException e) {
			throw new RuntimeException("DataBase Error "+e.getMessage());
		} finally {
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	
	private BigLottoRecordVO getBigLottoRecordVOFromResultSet(ResultSet resultSet) throws SQLException {
		BigLottoRecordVO bigLottoRecordVO = new BigLottoRecordVO();
		bigLottoRecordVO.setGameRecordNo(resultSet.getString("gameRecordNo"));
		bigLottoRecordVO.setGameNo(resultSet.getString("gameNo"));
		bigLottoRecordVO.setGameLotteryDate(resultSet.getDate("gameLotteryDate"));
		bigLottoRecordVO.setNumber1(resultSet.getInt("number1"));
		bigLottoRecordVO.setNumber2(resultSet.getInt("number2"));
		bigLottoRecordVO.setNumber3(resultSet.getInt("number3"));
		bigLottoRecordVO.setNumber4(resultSet.getInt("number4"));
		bigLottoRecordVO.setNumber5(resultSet.getInt("number5"));
		bigLottoRecordVO.setNumber6(resultSet.getInt("number6"));
		bigLottoRecordVO.setSpecialNumber(resultSet.getInt("specialNumber"));
		return bigLottoRecordVO;
	}
	
	@Override
	public BigLottoRecordVO findOneByPK(String gameRecordNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BigLottoRecordVO bigLottoRecordVO = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(FIND_ONE_BY_PK_SQL);
			preparedStatement.setString(1, gameRecordNo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				bigLottoRecordVO = getBigLottoRecordVOFromResultSet(resultSet);
			}
			
			List<String> list = new ArrayList<>();
			list.add("'"+gameRecordNo+"'");
			createSQLForOracle = RunSQLForOracle.createRunSQL(FIND_ONE_BY_PK_SQL, list);
	System.out.println(createSQLForOracle);
		} catch (SQLException e) {
			throw new RuntimeException("DataBase Error "+e.getMessage());
		} finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bigLottoRecordVO;
	}

	@Override
	public List<BigLottoRecordVO> getAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<BigLottoRecordVO> resultList = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(GET_ALL_SQL);
			resultSet = preparedStatement.executeQuery();
			resultList = new ArrayList<>();
			while(resultSet.next()) {
				resultList.add(getBigLottoRecordVOFromResultSet(resultSet));
			}
			List<String> list = new ArrayList<>();
			createSQLForOracle = RunSQLForOracle.createRunSQL(GET_ALL_SQL, list);
	System.out.println(createSQLForOracle);
		} catch (SQLException e) {
			resultList = null;
			throw new RuntimeException("DataBase Error "+e.getMessage());
		} finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resultList;
	}

	@Override
	public List<BigLottoRecordVO> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
