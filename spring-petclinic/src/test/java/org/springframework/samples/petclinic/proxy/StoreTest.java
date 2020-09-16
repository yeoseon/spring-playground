package org.springframework.samples.petclinic.proxy;

import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    public void testPay() {
        Payment cashPerf = new CashPerf();
        Store store = new Store(cashPerf);
        store.buySomething(100);
    }
}
