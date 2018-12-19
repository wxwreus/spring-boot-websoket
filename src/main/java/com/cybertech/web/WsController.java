package com.cybertech.web;

import com.cybertech.entity.WiselyMessage;
import com.cybertech.entity.WiselyResponse;
import com.cybertech.service.WebSocketService;
import com.cybertech.util.Constant;
import java.util.List;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/19. 10:56 AM
 */

@Controller
public class WsController {

	@Resource
	WebSocketService webSocketService;

	@MessageMapping(Constant.FORETOSERVERPATH)//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
	@SendTo(Constant.PRODUCERPATH)//如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
	public WiselyResponse say(WiselyMessage message) throws Exception {

		List<String> users = new ArrayList<String>();
		users.add("d892bf12bf7d11e793b69c5c8e6f60fb");//此处写死只是为了方便测试,此值需要对应页面中订阅个人消息的userId
		webSocketService.send2Users( users, new WiselyResponse("admin hello"));
//
		return new WiselyResponse("Welcome, " + message.getName() + "!");
	}

	@RequestMapping("/index")//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
	public Object test(WiselyMessage message) throws Exception {


		return "index";
	}
}
