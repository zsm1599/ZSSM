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
 * 类名称:    com.wxzx.gyzs.handler.BooleanCharTypeTypeHandler
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/30 14:24
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/30 14:24
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class BooleanCharTypeTypeHandler implements TypeHandler<Boolean> {

	private static String STR_TRUE_Y = "Y";
	private static String STR_TRUE_1 = "1";
	private static String STR_TRUE_YES = "YES";
	private static String STR_TRUE_TRUE = "TRUE";
	private static String STR_TRUE_FALSE = "FALSE";

	@Override
	public Boolean getResult(ResultSet arg0, String arg1) throws SQLException {
		return channgeCharToBoolean(arg0.getString(arg1));
	}


	private Boolean channgeCharToBoolean(String str) {
		if (str == null) {
			return Boolean.FALSE;
		}
		str = str.toUpperCase();
		if (STR_TRUE_TRUE.equalsIgnoreCase(str)
				|| STR_TRUE_YES.equalsIgnoreCase(str)
				|| STR_TRUE_Y.equalsIgnoreCase(str)
				|| STR_TRUE_1.equalsIgnoreCase(str)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean getResult(ResultSet arg0, int arg1) throws SQLException {
		return channgeCharToBoolean(arg0.getString(arg1));
	}

	@Override
	public Boolean getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		return channgeCharToBoolean(arg0.getString(arg1));
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, Boolean arg2,
							 JdbcType arg3) throws SQLException {
		arg0.setString(arg1, channgeBooleanToChar(arg2));
	}

	private String channgeBooleanToChar(Boolean bool) {
		if (bool == null || !bool.booleanValue()) {
			return STR_TRUE_FALSE;
		}
		return STR_TRUE_TRUE;
	}
}
