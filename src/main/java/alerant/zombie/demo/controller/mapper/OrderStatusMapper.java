package alerant.zombie.demo.controller.mapper;

import alerant.zombie.demo.controller.dto.OrderCreateDto;
import alerant.zombie.demo.dao.Order;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
public class OrderStatusMapper {

    public Order toEntity(OrderCreateDto dto) {
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setSender(dto.getSender());
        order.setRecipient(dto.getRecipient());
        order.setDescription(dto.getDescription());
        order.setDatetime(OffsetDateTime.parse(dto.getDatetime()).toLocalDateTime());
        order.setStatus(OrderStatus.FELVÉVE.name());
        return order;
    }
}

