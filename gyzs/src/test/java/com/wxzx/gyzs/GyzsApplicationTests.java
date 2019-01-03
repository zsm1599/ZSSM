package com.wxzx.gyzs;

import com.wxzx.gyzs.service.TokenTimer;
import com.wxzx.gyzs.util.MenuUtil;
import com.wxzx.gyzs.util.WeiXinUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GyzsApplicationTests {
	private static final String TEXT_URL  = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	@Autowired
	private TokenTimer tokenTimer;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		System.out.println(">>>>>>>>>>>>>>>>>>" + tokenTimer.getAccessToken());
		String accessToken  = tokenTimer.getAccessToken();
		String menu = MenuUtil.initMenu();
		System.out.println(menu);
		int result = MenuUtil.createMenu(accessToken,menu);
		if(result==0){
			System.out.println("菜单创建成功");
		}else{
			System.out.println("错误码"+result);
		}
	}

}
