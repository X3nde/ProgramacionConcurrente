package com.progcon_feedback1;

import com.progcon_feedback1.model.Order;
import com.progcon_feedback1.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class OrderIntegrationTests {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testCreateAndRetrieveOrder() {
        Order order = new Order();
        order.setDescription("Integration Test Order");
        order.setAmount(250.0);

        Order savedOrder = orderRepository.save(order);
        assertThat(savedOrder.getId()).isNotNull();

        Order retrievedOrder = orderRepository.findById(savedOrder.getId()).orElse(null);
        assertThat(retrievedOrder).isNotNull();
        assertThat(retrievedOrder.getDescription()).isEqualTo("Integration Test Order");
    }
}
