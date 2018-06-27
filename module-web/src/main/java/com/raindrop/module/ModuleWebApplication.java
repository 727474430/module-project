package com.raindrop.module;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @name: com.raindrop.module.ModuleWebApplication.java
 * @description: 启动类
 * @author: Wang Liang
 * @create Time: 2018/6/21 17:27
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.raindrop.module.dao")
public class ModuleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleWebApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerFactory containerFactory() {
		TomcatEmbeddedServletContainerFactory containerFactory = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				// 对所有路径进行加密约束
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				// 添加约束
				context.addConstraint(securityConstraint);
			}
		};
		containerFactory.addAdditionalTomcatConnectors(tomcatConnector());
		return containerFactory;
	}

	/**
	 * Http请求转Https: 需要保留tomcat默认8080端口,将项目端口改为其他
	 *
	 * @return
	 */
	@Bean
	public Connector tomcatConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		// 来源协议
		connector.setScheme("http");
		// 来源端口
		connector.setPort(8080);
		// 如果同时需要支持http和https则为true
		connector.setSecure(false);
		// 监听到以Http 8080开头的地址转向Https 8088地址
		connector.setRedirectPort(8088);
		return connector;
	}

}
