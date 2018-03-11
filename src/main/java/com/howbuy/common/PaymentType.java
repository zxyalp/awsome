package com.howbuy.common;

/**
 * 支付方式枚举类
 *
 * @author yang.zhou
 * @date 2017/12/21
 */
public enum PaymentType {

    /**
     * 默认支付方式
     */
    DEFAULT_PAY("默认支付", 0),

    /**
     * 使用储蓄罐支付
     */
    CXG_PAY("储蓄罐支付", 1),

    /**
     * 使用银行转账划款
     */
    BANK_LINE_PAY("银行转账划款", 2),

    /**
     * 使用银行卡代扣
     */
    BANK_CARD_PAY("银行卡代扣", 3);

    String name;
    int value;

    PaymentType(String name, int value) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
