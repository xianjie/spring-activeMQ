package spring.activeMQ.topic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Title: TopicMessageListenerStart
 * @Description:
 * @author: xian jie
 * @date: 2016/1/4 10:44
 * 杭州尚尚签网络科技有限公司
 * @version: 2.0
 */
public class TopicMessageListenerStart {

    /**
     * 消息主题监听者 和 主题监听容器 可以配置多个，即多个订阅者
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-topic-receive.xml");
    }
}
