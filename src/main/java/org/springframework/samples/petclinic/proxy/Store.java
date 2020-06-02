package org.springframework.samples.petclinic.proxy;

public class Store {
    Payment payment;

    public Store(Payment payment) {     // DI
        this.payment = payment;
    }

    public void buySomething() {
        payment.pay(100);
    }
}
