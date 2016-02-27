package com.lesbonne.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface for the Order Rest Service
 * @author jassica
 * @version 1
 *
 */
public interface OrderRestController {
	public ResponseEntity<Order> getOrderById(@PathVariable String ordertId);

	public ResponseEntity<Order> updateOrder(@RequestBody final Order order);

	public ResponseEntity<Order> addOrder(@RequestBody Order order);

	public ResponseEntity<Boolean> deleteOrder(@PathVariable Order order);
}
