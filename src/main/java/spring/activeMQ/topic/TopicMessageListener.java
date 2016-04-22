package spring.activeMQ.topic;

import org.apache.activemq.command.ActiveMQObjectMessage;
import spring.activeMQ.vo.SendMailMessageVo;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Title: TopicMessageListener
 * @Description:
 * @author: xian jie
 * @date: 2016/1/4 10:30
 * 杭州尚尚签网络科技有限公司
 * @version: 2.0
 */
public class TopicMessageListener implements MessageListener {

    // 接收消息
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                //使用JMSTemplate接收消息
                final TextMessage textMessage = (TextMessage) message;
                if (null != message) {
                    System.out.println("--- 收到消息内容为: " + textMessage.getText());
                }
            } else if(message instanceof ActiveMQObjectMessage) {
                ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) message;
                SendMailMessageVo sendMailMessageVo = (SendMailMessageVo) activeMQObjectMessage.getObject();
                System.out.println("--- 收到消息内容为: " + sendMailMessageVo.toString());
            }

            // 如果失败从新打入到 ActiveMQ 里面
                /*if(false) {
                    jmsTemplate.send(new MessageCreator() {
                        public Message createMessage(Session session) throws JMSException {
                            return session.createTextMessage(message.getText());
                        }
                    });
                }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
