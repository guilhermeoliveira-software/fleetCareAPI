package business.service;

import business.exception.EmailException;
import infra.entity.OrdemServico;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Value("${envio.email.remetente}")
    public String remetente;

    @Value("${envio.email.nomeRemetente}")
    public String nomeRemetente;

    public void enviarEmailAndamento(OrdemServico ordem, String emailDestino) {
        enviar(ordem, emailDestino, "Ordem de Serviço em Andamento", "ordem-andamento");
    }

    public void enviarEmailConcluida(OrdemServico ordem, String emailDestino) {
        enviar(ordem, emailDestino, "Ordem de Serviço Concluída", "ordem-concluida");
    }

    public void enviarEmailCancelada(OrdemServico ordem, String emailDestino) {
        enviar(ordem, emailDestino, "Ordem de Serviço Cancelada", "ordem-cancelada");
    }

    private void enviar(OrdemServico ordem, String emailDestino, String assunto, String template) {
        try {
            MimeMessage mensagem = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                    mensagem, true, StandardCharsets.UTF_8.name());

            helper.setFrom(new InternetAddress(remetente, nomeRemetente));
            helper.setTo(InternetAddress.parse(emailDestino));
            helper.setSubject(assunto + " - " + ordem.getVeiculo().getModelo());

            Context context = new Context();
            context.setVariable("ordemId", ordem.getId());
            context.setVariable("nomeVeiculo", ordem.getVeiculo().getModelo());
            context.setVariable("descricao", ordem.getDescricaoProblema());
            context.setVariable("status", ordem.getStatus().name());

            String html = templateEngine.process(template, context);
            helper.setText(html, true);
            mailSender.send(mensagem);

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new EmailException("Erro ao enviar email de notificação", e.getCause());
        }
    }
}
