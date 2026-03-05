package com.food;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private NotificationService notificationService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    public OrderService(@Qualifier("smsNotification") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        restaurantService.prepareOrder();
        notificationService.sendNotification("Your order placed successfully");
    }
}
