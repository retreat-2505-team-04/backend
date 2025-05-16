package alerant.zombie.demo.controller;

import alerant.zombie.demo.controller.dto.OrderCreateDto;
import alerant.zombie.demo.controller.dto.OrderDto;
import alerant.zombie.demo.controller.dto.RiskAssessmentDto;
import alerant.zombie.demo.controller.dto.StatusUpdateDto;
import alerant.zombie.demo.controller.dto.ZombieAssignmentDto;
import alerant.zombie.demo.controller.mapper.OrderStatusMapper;
import alerant.zombie.demo.dao.Order;
import alerant.zombie.demo.dao.RiskAssessment;
import alerant.zombie.demo.repository.EventLogRepository;
import alerant.zombie.demo.repository.OrderRepository;
import alerant.zombie.demo.repository.RiskAssessmentRepository;
import alerant.zombie.demo.repository.ZombieRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final ZombieRepository zombieRepository;
    private final RiskAssessmentRepository riskAssessmentRepository;
    private final EventLogRepository eventLogRepository;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid OrderCreateDto orderCreateDto) {

        OrderStatusMapper orderStatusMapper = new OrderStatusMapper();

        orderRepository.save(orderStatusMapper.toEntity(orderCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable String orderId) {
        OrderStatusMapper orderStatusMapper = new OrderStatusMapper();
        return orderRepository.findById(UUID.fromString(orderId))
                .map(order -> ResponseEntity.ok(orderStatusMapper.toDto(order)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable String orderId, @RequestBody StatusUpdateDto statusUpdateDto) {
        boolean updated = orderRepository.updateStatus(orderId, statusUpdateDto.getStatus(), statusUpdateDto.getDescription());
        if (updated) {
            eventLogRepository.log("Státusz frissítve: " + orderId + " → " + statusUpdateDto.getStatus());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{orderId}/assign-zombie")
    public ResponseEntity<ZombieAssignmentDto> assignZombie(@PathVariable String orderId) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isEmpty()) return ResponseEntity.notFound().build();

        ZombieAssignment assignment = zombieRepository.assignBestZombie(orderId);
        eventLogRepository.log("Zombi hozzárendelve: " + assignment.getZombieId() + " → " + orderId);
        return ResponseEntity.ok(ZombieAssignmentDto.from(assignment));
    }

    @GetMapping("/{orderId}/risk")
    public ResponseEntity<RiskAssessmentDto> getRisk(@PathVariable String orderId) {
        OrderStatusMapper orderStatusMapper = new OrderStatusMapper();
        Optional<RiskAssessment> risk = riskAssessmentRepository.findById(UUID.fromString(orderId));
        return risk.map(r -> ResponseEntity.ok(orderStatusMapper.toDto(r)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}

