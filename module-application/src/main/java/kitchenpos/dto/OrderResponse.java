package kitchenpos.dto;


import kitchenpos.domain.Order;
import kitchenpos.domain.OrderLineItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderResponse {

    private Long id;
    private Long orderTableId;
    private String orderStatus;
    private LocalDateTime orderedTime;
    private List<OrderLineItemResponse> orderLineItems;

    public OrderResponse() {
    }

    public OrderResponse(final Long id, final Long orderTableId, final String orderStatus,
                         final LocalDateTime orderedTime, final List<OrderLineItemResponse> orderLineItems) {
        this.id = id;
        this.orderTableId = orderTableId;
        this.orderStatus = orderStatus;
        this.orderedTime = orderedTime;
        this.orderLineItems = orderLineItems;
    }

    public static OrderResponse of(final Order order) {
        Long orderId = order.getId();
        return new OrderResponse(orderId,
                order.getOrderTable()
                        .getId(),
                order.getOrderStatus().name(),
                order.getOrderedTime(),
                OrderLineItemResponse.ofList(order.getOrderLineItems(), orderId));
    }

    public static List<OrderResponse> ofList(final List<Order> orders) {
        return orders.stream()
                .map(OrderResponse::of)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public Long getOrderTableId() {
        return orderTableId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }

    public List<OrderLineItemResponse> getOrderLineItems() {
        return orderLineItems;
    }

    public static class OrderLineItemResponse {

        private Long seq;
        private Long orderId;
        private Long menuId;
        private long quantity;

        public OrderLineItemResponse() {
        }

        private OrderLineItemResponse(final Long seq, final Long orderId, final Long menuId, final long quantity) {
            this.seq = seq;
            this.orderId = orderId;
            this.menuId = menuId;
            this.quantity = quantity;
        }

        public static OrderLineItemResponse of(final OrderLineItem orderLineItem, final Long orderId) {
            return new OrderLineItemResponse(orderLineItem.getId(),
                    orderId,
                    orderLineItem.getMenu()
                            .getId(),
                    orderLineItem.getQuantity());
        }

        public static List<OrderLineItemResponse> ofList(final List<OrderLineItem> orderLineItems, final Long orderId) {
            return orderLineItems.stream()
                    .map(orderLineItem -> of(orderLineItem, orderId))
                    .collect(Collectors.toList());
        }

        public Long getSeq() {
            return seq;
        }

        public Long getOrderId() {
            return orderId;
        }

        public Long getMenuId() {
            return menuId;
        }

        public long getQuantity() {
            return quantity;
        }
    }
}