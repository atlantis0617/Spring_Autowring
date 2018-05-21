package org.spring.autowiring.test;

import org.junit.Test;
import org.spring.autowiring.service.AutowiringService;

public class TestAutowiring extends JunitTestBase{
	/**
     * 通过构造器传递spring配置文件路径
     */
    public TestAutowiring() {
         
        super("classpath:spring-autowiring.xml");
         
    }
     
    @Test
    public void testAutowiring() {
         
        AutowiringService autowiringService =(AutowiringService) super.getBean("autowiringService");
        autowiringService.say("test");
         
    }
}
