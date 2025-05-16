package alerant.zombie.demo.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(OrderController.class)
@ActiveProfiles("h2")
@Disabled
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetOrders() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/orders"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void testCreateOrder() throws Exception {
        String orderJson = "{\"productId\":1,\"quantity\":2}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/orders")
                        .content(orderJson)
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void testGetOrderById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/orders/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void testDeleteOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/orders/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}