package com.stream.example.demo.port.adapter.event;

import com.stream.example.demo.application.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(OrderSink.class)
public class OrderListener {

    private static final Logger logger = LoggerFactory.getLogger(OrderListener.class);

    @StreamListener(target = OrderSink.INPUT, condition = "headers['payment_mode']=='cash'")
    public void listenForCashOrder(Order order) {
        logger.info(" received new CASH order {} ", order.toString());
    }

    @StreamListener(target = OrderSink.INPUT, condition = "headers['payment_mode']=='credit'")
    public void listenForCreditOrder(Order order) {
        logger.info(" received new CREDIT order {} ", order.toString());
    }

    @StreamListener(target = OrderSink.INPUT, condition = "headers['payment_mode']=='cheque'")
    public void listenForChequeOrder(Order order) {
        logger.info( "received new CHEQUE order {} ", order.toString());
    }
}
