package spring.activeMQ.vo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Title: SendMailMessageVo
 * @Description:
 * @author: xian jie
 * @date: 2015/11/17 11:25
 * 杭州尚尚签网络科技有限公司
 * @version: 2.0
 */
public class SendMailMessageVo implements Serializable {

    private static final long serialVersionUID = 3251793757880614316L;

    // 开发者编号
    private String devId;

    // 用户编号
    private String userId;

    // 收件人
    private String to[];

    // 抄送人
    private String cc[];

    // 标题
    private String subject;

    // body
    private String text;

    // 附件文件名
    private String fileName;

    // 附件byte数据
    private byte[] file;

    public SendMailMessageVo() {}

    public SendMailMessageVo(String devId, String userId, String[] to, String subject, String text) {
        this.devId = devId;
        this.userId = userId;
        this.to = to;
        this.subject = subject;
        this.text = text;

    }

    public SendMailMessageVo(String devId, String userId, String[] to, String[] cc, String subject, String text) {
        this.devId = devId;
        this.userId = userId;
        this.to = to;
        this.cc = cc;
        this.subject = subject;
        this.text = text;
    }

    public SendMailMessageVo(String devId, String userId, String[] to, String[] cc, String subject, String text, String fileName, byte[] file) {
        this.devId = devId;
        this.userId = userId;
        this.to = to;
        this.cc = cc;
        this.subject = subject;
        this.text = text;
        this.fileName = fileName;
        this.file = file;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "SendMailMessageVo{" +
                "devId='" + devId + '\'' +
                ", userId='" + userId + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
