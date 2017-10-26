package exec;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.sdx.merak.service.inft.hotel.dto.HotelSearchService;

import merak.hotel.search.HotelSearchServiceImpl;
import merak.hotel.search.SearcherStarter;

public class DubboStarter {

	public void start() {
		ApplicationConfig application = new ApplicationConfig();
		application.setName("merak-hotel-search");
		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(20895);
		protocol.setThreads(200);

		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress(SearcherStarter.zkHost());
		registry.setProtocol("zookeeper");

		// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

		// 服务提供者暴露服务配置
		ServiceConfig<HotelSearchService> service = new ServiceConfig<HotelSearchService>();
		service.setApplication(application);
		service.setRegistry(registry); // 多个注册中心可以用setRegistries()
		service.setProtocol(protocol); // 多个协议可以用setProtocols()
		service.setInterface(HotelSearchService.class);
		service.setRef(new HotelSearchServiceImpl());
		service.setRetries(0);
		service.export();

		System.out.println("hehehhehhee ");
		while (true) {

		}
	}
}
