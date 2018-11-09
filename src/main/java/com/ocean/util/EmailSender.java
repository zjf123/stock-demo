package com.ocean.util;

//import com.zhaogang.common.base.APIConfigCenter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Slf4j
@Component
public class EmailSender {

//	@Resource
//	private APIConfigCenter cc;

	//邮箱服务商的smtp地址
	private static final String MAIL_HOST = "smtp.qq.com";

	//邮件发送方邮箱地址
	private static final String MAIL_FROM_USER_ADDR = "1154944112@qq.com";

	//邮件登录域账户
	private static final String MAIL_FROM_USER = "1154944112@qq.com";

	//邮件发送方邮箱密码
	private static final String MAIL_FROM_USER_PWD = "qpjaxxoafkdwighf";

	public void send(String title,
			String content) {

		String[] receiver = StringUtils.split(MAIL_FROM_USER_ADDR, ",");
//		String[] receiver = StringUtils.split(cc.warnEmailReceiver, ",");
		String  envTitle = "[提示]"+title;
		sendEmail(receiver, MAIL_FROM_USER_ADDR, envTitle, content);
	}

	/**
	 * 发送邮件工具方法
	 *
	 * @param toAddressArray
	 * @param mailContent
	 * @param mailTitle
	 * @param emailPersonalStr
	 */
	private void sendEmail(String[] toAddressArray,
			String emailPersonalStr,
			String mailTitle,
			String mailContent) {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		// 设定mail server
		senderImpl.setHost(MAIL_HOST);
		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, "UTF-8");
		try {
			// 设置收件人，寄件人
			messageHelper.setTo(toAddressArray);
			//发送人
			messageHelper.setFrom(MAIL_FROM_USER_ADDR, emailPersonalStr);
			//邮件标题
			messageHelper.setSubject(mailTitle);
			// true 表示启动HTML格式的邮件
			messageHelper.setText(mailContent, true);
			//账号
			senderImpl.setUsername(MAIL_FROM_USER);
			//密码
			senderImpl.setPassword(MAIL_FROM_USER_PWD);
			//域账号认证配置
			Properties prop = new Properties();
			//将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.timeout", "45000");
			senderImpl.setJavaMailProperties(prop);
			// 发送邮件
			senderImpl.send(mailMessage);
		} catch (Exception e) {
			log.error(e.getMessage(), "send email error");
		}
	}

}
