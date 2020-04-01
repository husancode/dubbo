package provider;

import api.GreetingService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: husan
 * @Date: 2020/3/23 10:28
 * @Description:
 */
public class ProviderApplication {

	public static void main(String[] args) throws InterruptedException {
		ServiceConfig<GreetingService> service = new ServiceConfig<>();
		service.setApplication(new ApplicationConfig("first-dubbo-provider"));

		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setPort(-1);
		protocolConfig.setName("dubbo");
		service.setProtocol(protocolConfig);
		service.setRegistry(new RegistryConfig("zookeeper://"  + "127.0.0.1:2181"));
		service.setInterface(GreetingService.class);
		service.setRef(new GreetingsServiceImpl());
		service.export();
		System.out.println("dubbo service started");
		new CountDownLatch(1).await();
	}
}
