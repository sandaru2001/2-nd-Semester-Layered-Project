package lk.ijse.Fusion.lk.ijse.Fusion.entity;

public class OrderDetailEntity {
    private String  OrderId;
    private String ItemCode;
    private String qty;
    private String unitPrice;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(String orderId, String itemCode, String qty, String unitPrice) {
        OrderId = orderId;
        ItemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "OrderId='" + OrderId + '\'' +
                ", ItemCode='" + ItemCode + '\'' +
                ", qty='" + qty + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}
