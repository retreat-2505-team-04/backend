package alerant.zombie.demo.controller;

import alerant.zombie.demo.controller.dto.OrderCreateDto;
import alerant.zombie.demo.controller.dto.OrderDto;
import alerant.zombie.demo.controller.dto.RiskAssessmentDto;
import alerant.zombie.demo.controller.dto.StatusUpdateDto;
import alerant.zombie.demo.controller.dto.ZombieAssignmentDto;
import jakarta.validation.Valid;
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
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid OrderCreateDto orderCreateDto) {
        // Példa dummy implementációval
        OrderDto createdOrder = new OrderDto(UUID.randomUUID().toString(), orderCreateDto.getSender(),
                orderCreateDto.getRecipient(), orderCreateDto.getDescription(), orderCreateDto.getDatetime(), "Felvéve");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable String orderId) {
        // Dummy válasz
        OrderDto order = new OrderDto(orderId, "Teszt Küldő", "Teszt Címzett", "Teszt leírás",
                OffsetDateTime.now().toString(), "Úton");
        return ResponseEntity.ok(order);
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable String orderId, @RequestBody StatusUpdateDto statusUpdateDto) {
        // Logika itt
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{orderId}/assign-zombie")
    public ResponseEntity<ZombieAssignmentDto> assignZombie(@PathVariable String orderId) {
        // Dummy adat
        ZombieAssignmentDto assignment = new ZombieAssignmentDto("zombie123", "Zombi Béla", 92.5);
        return ResponseEntity.ok(assignment);
    }

    @GetMapping("/{orderId}/risk")
    public ResponseEntity<RiskAssessmentDto> getRisk(@PathVariable String orderId) {
        // Dummy adat
        RiskAssessmentDto risk = new RiskAssessmentDto("Közepes", "Zombi aktivitás észlelve a környéken");
        return ResponseEntity.ok(risk);
    }
}

