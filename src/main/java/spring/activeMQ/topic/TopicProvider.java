package spring.activeMQ.topic;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import spring.activeMQ.vo.SendMailMessageVo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

/**
 * @Title: TopicProvider
 * @Description:
 * @author: xian jie
 * @date: 2016/1/4 9:51
 * 杭州尚尚签网络科技有限公司
 * @version: 2.0
 */
public class TopicProvider {

    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    // 接收消息
    public void publish(final Object message) {
        if (message instanceof String) {
            //使用JMSTemplate可以很简单的实现发送消息
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage((String) message);
                }
            });
            System.out.println("--- 发送消息内容为: " + message);
        } else if (message instanceof SendMailMessageVo) {
            //使用JMSTemplate可以很简单的实现发送消息
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createObjectMessage((Serializable) message);
                }
            });
            System.out.println("--- 发送消息内容为: " + message.toString());
        }
    }
}
