package com.wxzx.gyzs;

import com.wxzx.gyzs.service.TokenTimer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GyzsApplicationTests {

	@Autowired
	private TokenTimer tokenTimer;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		System.out.println(">>>>>>>>>>>>>>>>>>" + tokenTimer.getAccessToken());
	}

}
