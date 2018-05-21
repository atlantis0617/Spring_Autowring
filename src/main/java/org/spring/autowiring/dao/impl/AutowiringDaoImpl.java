package org.spring.autowiring.dao.impl;

import org.spring.autowiring.dao.AutowiringDao;

public class AutowiringDaoImpl implements AutowiringDao{

	@Override
	public void say(String word) {
		
		 System.out.println("AutowiringDaoImpl接受参数：" + word);
	}

}
