package alerant.zombie.demo.controller.mapper;

import alerant.zombie.demo.controller.dto.OrderCreateDto;
import alerant.zombie.demo.controller.dto.OrderDto;
import alerant.zombie.demo.controller.dto.RiskAssessmentDto;
import alerant.zombie.demo.dao.Order;
import alerant.zombie.demo.dao.RiskAssessment;
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

    public OrderDto toDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId().toString());
        dto.setSender(order.getSender());
        dto.setRecipient(order.getRecipient());
        dto.setDescription(order.getDescription());
        dto.setDatetime(order.getDatetime().toString());
        dto.setStatus(order.getStatus());
        return dto;
    }

    public RiskAssessmentDto toDto(RiskAssessment risk) {
        RiskAssessmentDto dto = new RiskAssessmentDto();
        dto.setRisk_level(risk.getRiskLevel());
        dto.setExplanation(risk.getExplanation());
        return dto;
    }
}

