package spring.activeMQ.topic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.activeMQ.vo.SendMailMessageVo;

import java.util.UUID;

/**
 * @Title: TopicProviderTest
 * @Description:
 * @author: xian jie
 * @date: 2016/1/4 10:34
 * 杭州尚尚签网络科技有限公司
 * @version: 2.0
 */
public class TopicProviderTest {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-topic-provider.xml");

        TopicProvider topicProvider = (TopicProvider) applicationContext.getBean("topicProvider");

        for (int i = 1; i <= 10; i++) {
            topicProvider.publish("topic第" + i + "条消息");
        }

        Thread.sleep(1000 * 5);

        for (int i = 1; i <= 10; i++) {
            SendMailMessageVo sendMailMessageVo = new SendMailMessageVo();
            sendMailMessageVo.setDevId(UUID.randomUUID().toString().replace("-", ""));
            sendMailMessageVo.setText("topicMessage" + i);
            sendMailMessageVo.setSubject("topicSubject" + i);
            sendMailMessageVo.setUserId(UUID.randomUUID().toString().replace("-", ""));
            topicProvider.publish(sendMailMessageVo);
        }

        System.out.println("provider send end");
    }
}
