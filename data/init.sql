-- Zombie table insert
INSERT INTO public.zombie (id, bite_count, energy_level, last_delivery_time, name, speed)
VALUES
(gen_random_uuid(), 10, 75, '2024-05-15 10:30:00', 'Zed', 3.5),
(gen_random_uuid(), 23, 55, '2024-05-14 14:20:00', 'Ghoul', 4.1);

-- Replace these UUIDs with actual UUIDs from the zombie insert above
INSERT INTO public.orders (id, datetime, description, recipient, sender, status, assigned_zombie_id)
VALUES
(gen_random_uuid(), '2024-05-15 12:00:00', 'Urgent medical supply', 'Alice', 'Bob', 'delivered', (SELECT id FROM public.zombie WHERE name = 'Zed')),
(gen_random_uuid(), '2024-05-14 16:00:00', 'Food delivery', 'Charlie', 'Dave', 'pending', (SELECT id FROM public.zombie WHERE name = 'Ghoul'));

-- Replace order_id and zombie_id with actual UUIDs from above
INSERT INTO public.risk_assessment (id, explanation, risk_level, order_id, zombie_id)
VALUES
(gen_random_uuid(), 'Zombie is fast, but energy low.', 'Medium', (SELECT id FROM public.orders WHERE recipient = 'Alice'), (SELECT id FROM public.zombie WHERE name = 'Zed')),
(gen_random_uuid(), 'High bite count, potential danger.', 'High', (SELECT id FROM public.orders WHERE recipient = 'Charlie'), (SELECT id FROM public.zombie WHERE name = 'Ghoul'));

-- Replace order_id with actual UUIDs from above
INSERT INTO public.event_log (id, details, event_type, timestamp, order_id)
VALUES
(gen_random_uuid(), 'Package delivered successfully.', 'DELIVERY_SUCCESS', '2024-05-15 12:45:00', (SELECT id FROM public.orders WHERE recipient = 'Alice')),
(gen_random_uuid(), 'Delivery delayed due to slow zombie.', 'DELIVERY_DELAY', '2024-05-14 17:30:00', (SELECT id FROM public.orders WHERE recipient = 'Charlie'));

