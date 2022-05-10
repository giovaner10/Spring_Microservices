package com.microservices.hrpayroll.service;

import com.microservices.hrpayroll.entities.Payment;
import com.microservices.hrpayroll.entities.Worker;
import com.microservices.hrpayroll.feignclients.WorkerFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    /*@Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workId, int days){

        /*Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workId));

        Worker worker = restTemplate.getForObject(workerHost + "/{id}", Worker.class, uriVariables );
        return new Payment(worker.getName(), worker.getDailyIncome(), days);*/
        Worker worker = workerFeignClient.findById(workId + 1l).getBody();
        return new Payment("Nome encontrado: "+worker.getName(), worker.getDailyIncome(), days);

    }
}
