package com.devsup.dsmeta.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsup.dsmeta.backend.entities.Sale;
import com.devsup.dsmeta.backend.repositories.SaleRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findSales(){
		return saleRepository.findAll();
	};
}
