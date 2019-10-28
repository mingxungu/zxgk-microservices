package cn.com.pingtech.spring;

import cn.com.pingtech.util.VehicleBrandUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringInitContext implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
        VehicleBrandUtil.initBrand();
	}

}
