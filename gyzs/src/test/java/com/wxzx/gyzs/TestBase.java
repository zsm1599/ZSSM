package com.wxzx.gyzs;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * ---------------------------------------------------------------
 * <p/>
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.TestBase
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2019/1/30 15:01
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2019/1/30 15:01
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class TestBase {
}
