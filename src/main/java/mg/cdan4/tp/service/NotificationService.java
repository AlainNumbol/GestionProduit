package mg.cdan4.tp.service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

public class NotificationService {
    @Autowired
    private JavaMailSender javaMailSender = getJavaMailSender();

    public NotificationService() {

    }

    public boolean sendMailTo(String adresseMail, String subject, String text) {
        try {
            var message = new SimpleMailMessage();

            message.setFrom("alainnimbol@gmail.com");
            message.setTo(adresseMail);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * à voir plus tard
     *
     * @return
     */
    public boolean getNotification() {

        return false;
    }

    private JavaMailSender getJavaMailSender() {
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("email.oio.ids@gmail.com");
        mailSender.setPassword("rnxzetxaxjkyesoi");

        var props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public void sendMailWithAttachement(String toEmail ,
                                        String body,
                                        String subject,
                                        String attachement ) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("email.oio.ids@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem = new FileSystemResource(new File(attachement));
        mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

        javaMailSender.send(mimeMessage);
    }
}
