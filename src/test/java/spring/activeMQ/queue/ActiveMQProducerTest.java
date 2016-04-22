package spring.activeMQ.queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.activeMQ.queue.ActiveMQProducer;
import spring.activeMQ.vo.SendMailMessageVo;

import java.util.UUID;

/**
 * @Title: ActiveMQProducerTest
 * @Description:
 * @author: xian jie
 * @date: 2015/12/30 17:35
 * 杭州尚尚签网络科技有限公司
 * @version: 2.0
 */
public class ActiveMQProducerTest {

    /**
     * 消息生产者
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-queue-producer.xml");

        ActiveMQProducer activeMQProducer = (ActiveMQProducer) applicationContext.getBean("activeMQProducer");

        for (int i = 1; i <= 10; i++) {
            activeMQProducer.send("第" + i + "条消息");
        }

        Thread.sleep(1000 * 5);

        for (int i = 1; i <= 10; i++) {
            SendMailMessageVo sendMailMessageVo = new SendMailMessageVo();
            sendMailMessageVo.setDevId(UUID.randomUUID().toString().replace("-", ""));
            sendMailMessageVo.setText("message" + i);
            sendMailMessageVo.setSubject("subject" + i);
            sendMailMessageVo.setUserId(UUID.randomUUID().toString().replace("-", ""));
            activeMQProducer.send(sendMailMessageVo);
        }
    }
}
