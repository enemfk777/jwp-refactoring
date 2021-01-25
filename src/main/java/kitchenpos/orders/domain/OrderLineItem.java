package kitchenpos.orders.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kitchenpos.menu.domain.Menu;

@Entity
public class OrderLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Orders order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id")
	private Menu menu;

	private long quantity;

	public OrderLineItem() {
	}

	public OrderLineItem(Orders order, Menu menu, long quantity) {
		this.order = order;
		this.menu = menu;
		this.quantity = quantity;
	}

	public OrderLineItem(Menu menu, long quantity) {
		this.menu = menu;
		this.quantity = quantity;
	}


	public Long getSeq() {
		return seq;
	}

	public Orders getOrder() {
		return order;
	}

	public Menu getMenu() {
		return menu;
	}

	public long getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "OrderLineItem{" +
			"seq=" + seq +
			", order=" + order +
			", menu=" + menu +
			", quantity=" + quantity +
			'}';
	}
}