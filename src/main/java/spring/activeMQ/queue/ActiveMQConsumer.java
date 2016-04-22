package spring.activeMQ.queue;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.core.JmsTemplate;
import spring.activeMQ.vo.SendMailMessageVo;

import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @Title: ActiveMQConsumer
 * @Description: ActiveMQ Server
 * @author: xian jie
 * @date: 2015/12/30 17:25
 * 杭州尚尚签网络科技有限公司
 * @version: 2.0
 */
public class ActiveMQConsumer {

    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * 消息消费者 Queue点对点方式
     */
    public void receive() {
        while (true) {
            try {
                Message message = jmsTemplate.receive();

                if (message instanceof TextMessage) {
                    //使用JMSTemplate接收消息
                    final TextMessage textMessage = (TextMessage) message;
                    if (null != message) {
                        System.out.println("--- 收到消息内容为: " + textMessage.getText());
                    } else {
                        break;
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
}
