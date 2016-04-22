package spring.activeMQ.queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.activeMQ.queue.ActiveMQConsumer;

/**
 * @Title: ActiveMQConsumerTest
 * @Description:
 * @author: xian jie
 * @date: 2015/12/30 17:43
 * 杭州尚尚签网络科技有限公司
 * @version: 2.0
 */
public class ActiveMQConsumerTest {

    /**
     * 消息消费者
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-queue-consumer.xml");

        ActiveMQConsumer activeMQConsumer = (ActiveMQConsumer) applicationContext.getBean("activeMQConsumer");

        System.out.println("ActiveMQ Consumer start");

        activeMQConsumer.receive();

        /**
         * 如果 server 没有开启 client 一直在发数据 可以发送成功
         * server一旦开启 就会接受 以前 client发送的数据
         */

    }
}
