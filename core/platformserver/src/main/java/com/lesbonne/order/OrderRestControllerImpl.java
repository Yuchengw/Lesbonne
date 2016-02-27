package com.lesbonne.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lesbonne.postcomment.PostComment;

/**
 * Rest controller implementation for Order
 * 
 * @author jassica
 * @version 1
 */
@Controller
public class OrderRestControllerImpl implements OrderRestController {
    private static final Logger logger = LoggerFactory
            .getLogger(OrderRestControllerImpl.class);
    
    @Autowired
    private OrderService orderService;
    
    @Override
    @RequestMapping(
            method = RequestMethod.GET,
            value = OrderRestURIConstants.GET_ORDER_BY_ID,
            produces = "application/json")
    public @ResponseBody ResponseEntity<Order> getOrderById(
            @PathVariable String orderId) {
        Order comment = null;
        try {
            comment = orderService.getOrderById(orderId);
        } catch (Exception e) {
            return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Order>(comment, HttpStatus.OK);
    }
    
    @Override
    @RequestMapping(
            method = RequestMethod.PUT,
            value = OrderRestURIConstants.UPDATE_ORDER,
            produces = "application/json")
    public @ResponseBody ResponseEntity<Order> updateOrder(
            @RequestBody Order order) {
        Order updatedOrder = null;
        try {
            // TODO: Add validation on the basic required field
            if (order == null) {
                return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
            }
            updatedOrder = orderService.updateOrder(updatedOrder);
        } catch (Exception e) {
            return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Order>(updatedOrder, HttpStatus.OK);
    }
    
    @Override
    @RequestMapping(
            method = RequestMethod.POST,
            value = OrderRestURIConstants.CREATE_ORDER,
            produces = "application/json")
    public @ResponseBody ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order result = null;
        try {
            if (order == null) {
                return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
            }
            // The order parent post can either be askingpost or
            // providerpost, but cannot set both or set none
            if ((order.getAskingPost() == null && order.getSharingPost() == null)
                    || (order.getAskingPost() != null && order.getSharingPost() != null)) {
                return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
            }
            result = orderService.persistOrder(order);
        } catch (Exception e) {
            return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Order>(result, HttpStatus.OK);
    }
    
    @Override
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = OrderRestURIConstants.DELETE_ORDER)
    public ResponseEntity<Boolean> deleteOrder(@RequestBody Order order) {
        try {
            orderService.deleteOrder(order);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
