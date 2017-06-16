package com.emi;

import com.emi.common.util.OkHttpUtils;
import com.emi.dto.UserRegisterRequest;
import com.emi.dto.UserRegisterResponse;
import com.emi.dto.UserSearchRequest;
import com.emi.dto.UserSearchResponse;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo3ApplicationTests {

	@Autowired
	private OkHttpUtils okUtils;


	private static final String urlPrefix = "http://localhost:" + "8002" + "/demo";
	Gson gson = new Gson();
	Logger logger = LoggerFactory.getLogger(this.getClass());


	@Test
	public void userRegister1() throws IOException {

		String url = urlPrefix + "/api/user/register";
		UserRegisterRequest request = new UserRegisterRequest("emi21", "123456", "emi21_");
		UserRegisterResponse response = okUtils.postJson(url, request, UserRegisterResponse.class);
		logger.info(gson.toJson(response));
	}

	@Test
	public void userRegister2() throws IOException {

		String url = urlPrefix + "/api/user/register2";
		UserRegisterRequest request = new UserRegisterRequest("okmnhyxx", "123456", "emi21_");
		UserRegisterResponse response = okUtils.post(url, request, UserRegisterResponse.class);
		logger.info(gson.toJson(response));
	}

	@Test
	public void userList() {

		String url = urlPrefix + "/api/user/search1";
		UserSearchRequest request = new UserSearchRequest("emi", null, null, null, null, 3,0);
//        Class c = request.fetchResponseClass();
		UserSearchResponse response = okUtils.get(url, request, UserSearchResponse.class);
		logger.info(gson.toJson(response));
	}
	@Test
	public void userList2() {

		String url = urlPrefix + "/api/user/search2";
		UserSearchRequest request = new UserSearchRequest("emi", null, null, null, null, 3,1);
//        Class c = request.fetchResponseClass();
		UserSearchResponse response = okUtils.get(url, request, UserSearchResponse.class);
		logger.info(gson.toJson(response));
	}


	@Test
	public void testReflexEfficiency() {

	}

}
