package cpm.flowerpot.mailbox;

import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * MailTest
 *
 * @author Mrhan
 * @date 2021/4/7 23:03
 */
public class MailTest {
    public static void main(String[] args) {
        MailSender sender = new JavaMailSenderImpl();

    }
}
