package com.microservices.hrpayroll.resources;


import com.microservices.hrpayroll.entities.Payment;
import com.microservices.hrpayroll.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@AllArgsConstructor
public class PaymentResource {

    private PaymentService paymentService;

    @GetMapping(value = "/{workId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workId, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(workId, days);
        return ResponseEntity.ok(payment);
    }


}
