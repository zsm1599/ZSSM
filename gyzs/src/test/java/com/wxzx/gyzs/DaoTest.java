package com.wxzx.gyzs;

import com.wxzx.gyzs.dao.HouseBaseInfoDao;
import com.wxzx.gyzs.domain.HouseBaseInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.DaoTest
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2019/1/30 15:02
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2019/1/30 15:02
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class DaoTest extends TestBase {

	@Autowired
	private HouseBaseInfoDao houseBaseInfoDao;

	@Test
	public void testHouseBaseInfoDao(){
		HouseBaseInfo houseBaseInfo = new HouseBaseInfo();
		houseBaseInfo.setCreateOperator("test");
		houseBaseInfoDao.insert(houseBaseInfo);
	}
}
