package com.wxzx.gyzs.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.handler.BooleanTinyIntTypeTypeHandler
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/30 14:37
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/30 14:37
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class BooleanTinyIntTypeTypeHandler implements TypeHandler<Boolean> {

	@Override
	public Boolean getResult(ResultSet arg0, String arg1) throws SQLException {
		return arg0.getByte(arg1) == 1;
	}

	@Override
	public Boolean getResult(ResultSet arg0, int arg1) throws SQLException {
		return arg0.getByte(arg1) == 1;
	}

	@Override
	public Boolean getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		return arg0.getByte(arg1) == 1;
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, Boolean arg2,
							 JdbcType arg3) throws SQLException {
		arg0.setByte(arg1, arg2 != null && arg2.booleanValue() ? (byte)1: (byte)0 );
	}
}
