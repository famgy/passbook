package com.imooc.passbook.passbook.constant;

public enum FeedbackType {

    PASS(1, "针对优惠券的评论"),
    APP(2, "针对卡包 APP 的评论");

    /* 评论类型编码 */
    private Integer code;

    /* 评论类型描述 */
    private String desc;

    FeedbackType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
