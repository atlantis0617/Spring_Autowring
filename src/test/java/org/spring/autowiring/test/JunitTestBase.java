package org.spring.autowiring.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class JunitTestBase {

	private ClassPathXmlApplicationContext context;
	private String springXmlPath;

	/**
	 * 无参构造器，使用此构造器创建对象，使用默认spring配置文件
	 */
	public JunitTestBase() {

	}

	/**
	 * 含参构造器，初始化spring配置文件路径
	 *
	 * @param springXmlPath
	 *            spring配置文件路径
	 */
	public JunitTestBase(String springXmlPath) {

		this.springXmlPath = springXmlPath;

	}

	/**
	 * 启动spring容器，在@Test方法执行之前执行
	 */
	@Before
	public void start() {

		if (StringUtils.isEmpty(springXmlPath)) {// 设置默认spring配置文件路径
			springXmlPath = "classpath:spring-*.xml";
		}
		// 加载spring配置文件到spring容器中
		context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
		// 启动spring容器，并扩散启动信号到该容器下的所有组件
		context.start();

	}

	/**
	 * 销毁spring容器，在@Test方法执行之前执行
	 */
	@After
	public void stop() {

		if (context != null) {
			context.destroy();
		}

	}

	/**
	 * 通过bean id获取bean对象
	 *
	 * @param beanId
	 *            bean id
	 * @return
	 */
	public Object getBean(String beanId) {

		return context.getBean(beanId);

	}

}
