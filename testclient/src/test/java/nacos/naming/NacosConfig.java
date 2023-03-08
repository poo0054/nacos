package nacos.naming;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author zhangzhi
 * @date 2023/2/16
 */
public class NacosConfig {
    @Test
    public void test() throws NacosException, IOException {
        String serverAddr = "192.168.56.1:8848";
        String dataId = "test";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);

        //监听指定nacis的配置
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("configInfo:" + configInfo);
            }
        });

        System.in.read();
    }
}
