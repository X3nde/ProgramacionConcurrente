package com.progcon_feedback1;
package com.progcon_feedback1.repository;
import com.progcon_feedback1.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class OrderIntergrationTests {


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
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
