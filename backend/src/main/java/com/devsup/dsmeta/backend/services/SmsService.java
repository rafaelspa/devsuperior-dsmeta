package com.devsup.dsmeta.backend.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsup.dsmeta.backend.entities.Sale;
import com.devsup.dsmeta.backend.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	
	@Autowired
	private SaleRepository saleRepository;

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	public void sendSms(Long saleId) {

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Optional<Sale> sale = saleRepository.findById(saleId);
		String date = sale.get().getDate().getMonthValue() + "/" + sale.get().getDate().getYear();

		String msg = "Vendedor " +
				sale.get().getSellerName() +
				" foi destaque em " +
				date +
				" com um total de R$ " +
				String.format("%.2f", sale.get().getAmount());
		
		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}
