package com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vo.User;

@Controller
@RequestMapping("/json")
public class JsonControllerTest {
	Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(value = "toJsonTestPage")
	public String toJsonTestPage() {
		return "/JsonTest";
	}

	/*
	 * 备注：@ResponseBody是根据页面的contentType参数决定的， 但是如果是键值对：key/value，要去掉@ResponseBody注解，
	 * 会根据springmvc普通的http请求信息
	 */
	// 1.普通数据传输：@ResponseBody注解：不能加；application/x-www-form-urlencoded：可以加上，也可以不加，
	// 2.如果是json数据传入：@ResponseBody：要加上，contentType:'application/json;charset=utf-8'：要加上
	@RequestMapping(value = "JsonTest")
	public @ResponseBody User JsonTest(User user) {
		log.info("userinfo[username:" + user.getUsername() + ",password:" + user.getPassword() + "]");
		return user;
	}
}
