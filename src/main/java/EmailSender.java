import org.apache.log4j.Logger;
import pom.AbstractPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EmailSender {
    final static Logger LOG = Logger.getLogger(AbstractPage.class);

        public static void sendMail(Object mailBody) {
            Properties props = new Properties();
            props.put("mail.smtp.host", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("olenayurkiv2017@gmail.com", "0633787Mm");
                }
            });
            try {
                MimeMessage msg = new MimeMessage(session);
                String to = "olenayurkiv2017@gmail.com";
                InternetAddress[] address = InternetAddress.parse(to, true);
                msg.setRecipients(Message.RecipientType.TO, address);
                String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
                msg.setSubject("Best Indexes Mail Report : " + timeStamp);
                msg.setSentDate(new Date());
                msg.setText(mailBody.toString());
                msg.setHeader("XPriority", "1");

                //add attachment
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                Multipart multipart = new MimeMultipart();
                messageBodyPart = new MimeBodyPart();
                String file = "src/main/resources/bestindexes.xml";
                String fileName = "best_performing_indexes";
                DataSource source = new FileDataSource(file);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(fileName);
                multipart.addBodyPart(messageBodyPart);

                msg.setContent(multipart);
                Transport.send(msg);
                System.out.println("Mail has been sent successfully");
            } catch (MessagingException mex) {
                System.out.println("Unable to send an email" + mex);
            }
        }
    }

