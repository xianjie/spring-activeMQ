package spring.activeMQ.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import spring.activeMQ.vo.SendMailMessageVo;

import java.io.Serializable;

/**
 * @Title: ActiveMQProducer
 * @Description: ActiveMQ Client
 * @author: xian jie
 * @date: 2015/12/30 17:29
 * 杭州尚尚签网络科技有限公司
 * @version: 2.0
 */
public class ActiveMQProducer {

    //Spring的模板，封装了很多功能
    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * 消息生产者 Queue点对点方式
     * @param message
     */
    public void send(final Object message) {
        if(message instanceof String) {
            //使用JMSTemplate可以很简单的实现发送消息
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage((String) message);
                }
            });
            System.out.println("--- 发送消息内容为: " + message);
        } else if(message instanceof SendMailMessageVo) {
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
