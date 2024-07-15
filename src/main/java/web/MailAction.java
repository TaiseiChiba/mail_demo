package web;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.UserAccount;

public class MailAction implements ActionIF {

    @Override
    public String execute(HttpServletRequest request) {

        final HttpSession httpSession = request.getSession(false);
        final UserAccount user = (UserAccount) httpSession.getAttribute("user");

        final String to = user.getEmail();
        final String subject = "テスト件名";
        final String body = "テスト内容";

        // SMTPサーバーの設定
        final Properties props = new Properties();
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port", "1025");

        final Session session = Session.getInstance(props, null);

        try {
            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("testFrom@example.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (final MessagingException e) {
            throw new RuntimeException(e);
        }

        return "top.jsp";
    }

}
