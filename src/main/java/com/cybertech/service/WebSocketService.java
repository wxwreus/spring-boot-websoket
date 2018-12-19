package com.cybertech.service;

import com.cybertech.entity.WiselyResponse;
import com.cybertech.util.Constant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/19. 10:55 AM
 */
@Service
public class WebSocketService {

	@Autowired
	private SimpMessagingTemplate template;

	/**
	 * 广播
	 * 发给所有在线用户
	 *
	 * @param msg
	 */
	public void sendMsg(WiselyResponse msg) {
		template.convertAndSend(Constant.PRODUCERPATH, msg);
	}

	/**
	 * 发送给指定用户
	 * @param users
	 * @param msg
	 */
	public void send2Users(List<String> users, WiselyResponse msg) {

		users.forEach(userName -> {
			template.convertAndSendToUser(userName, Constant.P2PPUSHPATH, msg);
		});
	}
}
