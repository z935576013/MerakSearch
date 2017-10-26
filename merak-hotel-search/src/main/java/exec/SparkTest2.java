//package exec;
//
//import com.alibaba.dubbo.config.ApplicationConfig;
//import com.alibaba.dubbo.config.MonitorConfig;
//import com.alibaba.dubbo.config.ReferenceConfig;
//import com.alibaba.dubbo.config.RegistryConfig;
//import com.sdx.merak.service.inft.hotel.dto.HotelSearchService;
//
//public class SparkTest2 {
//
//	public static void main(String[] args) {
//
//		ApplicationConfig application = new ApplicationConfig();
//		application.setName("merak-hotel-search");
//
//		// 连接注册中心配置
//		RegistryConfig registry = new RegistryConfig();
//		registry.setAddress("119.254.97.130:2181");
//		registry.setProtocol("zookeeper");
//
//		MonitorConfig monitor = new MonitorConfig();
//		monitor.setProtocol("registry");
//		
//		// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
//		ReferenceConfig<HotelSearchService> reference = new ReferenceConfig<HotelSearchService>();
//		reference.setApplication(application);
//		reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
//		reference.setMonitor(monitor);
//		reference.setInterface(HotelSearchService.class);
//		reference.setCheck(false);
//		reference.setTimeout(2000);
//		reference.setRetries(2);
//		
//		HotelSearchService  service=reference.get();
//		String b=service.search(" saonima ");
//		
//		System.out.println(b);
//	}
//
//}
