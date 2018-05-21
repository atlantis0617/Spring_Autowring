package org.spring.autowiring.service.impl;

import org.spring.autowiring.dao.AutowiringDao;
import org.spring.autowiring.service.AutowiringService;

public class AutowiringServiceImpl implements AutowiringService{
	
	//byName时，必须与bean配置的id一致；byType时，可随意命名。本次修改bean的id，不再修改该属性名；效果一样
    private AutowiringDao autowiringDao;
    
    /**
     * (byName和byType)只需setter方法
     * @param autowiringDao
     */
    public void setAutowiringDao(AutowiringDao autowiringDao) {
         
        this.autowiringDao = autowiringDao;
         
    }

	@Override
	public void say(String word) {
		
		System.out.println("AutowiringServiceImpl接受参数:" + word);
        autowiringDao.say(word);
		
	}

}
