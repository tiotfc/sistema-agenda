package br.com.sada.sistema.agenda.services.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.sada.sistema.auditoria.model.dto.LogAuditoriaDto;

@Service
public class KafkaProducerService {

	KafkaTemplate<String, Object> kafkaTemplate;

	public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void enviaLogAuditoria(LogAuditoriaDto logAudit) 	{
		this.kafkaTemplate.send("AUDIT_LOG_TOPIC3", logAudit);
	}
	
}
