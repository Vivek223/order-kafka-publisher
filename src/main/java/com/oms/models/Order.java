package com.oms.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDERS")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int orderId;

    private String ipid;
    private String comment;

    public Order() {
    }

    public Order(String ipid, String comment) {
        this.ipid = ipid;
        this.comment = comment;
    }

    public Order(int orderId, String ipid, String comment) {
        this.orderId = orderId;
        this.ipid = ipid;
        this.comment = comment;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getIpid() {
        return ipid;
    }

    public String getComment() {
        return comment;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setIpid(String ipid) {
        this.ipid = ipid;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
