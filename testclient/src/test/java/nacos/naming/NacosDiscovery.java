package nacos.naming;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.junit.Test;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

/**
 * @author zhangzhi
 * @date 2023/2/16
 */
public class NacosDiscovery {
    @Test
    public void test() throws NacosException, IOException {
        Properties properties = new Properties();
        properties.setProperty("serverAddr", "192.168.56.1:8848");
        properties.setProperty("namespace", "public");
        NamingService naming = NamingFactory.createNamingService(properties);
        naming.registerInstance("nacos.test.1", "test", "13.22.22.22", 8882);
        Instance instance = new Instance();
        instance.setIp("55.55.55.55");
        instance.setPort(9999);
        instance.setWeight(2.0);
        Instance instance1 = new Instance();
        instance1.setIp("66.55.55.55");
        instance1.setPort(9999);
        instance1.setWeight(1);
        naming.batchRegisterInstance("nacos.test", "test", Arrays.asList(instance1, instance));
        System.in.read();
        /* Instance instance = new Instance();
        instance.setIp("55.55.55.55");
        instance.setPort(9999);
        instance.setHealthy(false);
        instance.setWeight(2.0);
        Map<String, String> instanceMeta = new HashMap<>();
        instanceMeta.put("site", "et2");
        instance.setMetadata(instanceMeta);
        naming.registerInstance("nacos.test.4", instance);*/
    }

}
