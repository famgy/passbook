package com.imooc.passbook.passbook.utils;

import com.imooc.passbook.passbook.vo.Feedback;
import com.imooc.passbook.passbook.vo.GainPassTemplateRequest;
import com.imooc.passbook.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/* RowKey 生成器工具类 */
@Slf4j
public class RowKeyGenUtil {

    /* 根据提供的 PassTemplate 对象生成 RowKey */
    public static String genPassTemplateRowKey(PassTemplate passTemplate) {

        /* 唯一值 */
        String passInfo = passTemplate.getId() + "_" + passTemplate.getTitle();

        String rowKey = DigestUtils.md5Hex(passInfo);
        log.info("GenPassTemplateRowKey: {}, {}", passInfo, rowKey);

        return rowKey;
    }

    /**
     * <h2>根据提供的领取优惠券请求生成 RowKey, 只可以在领取优惠券的时候使用</h2>
     * Pass RowKey = reversed(userId) + inverse(timestamp) + PassTemplate RowKey
     * @param request {@link GainPassTemplateRequest}
     * @return String RowKey
     * */
    public static String genPassRowKey(GainPassTemplateRequest request) {
        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString()
                + (Long.MAX_VALUE - System.currentTimeMillis())
                + genPassTemplateRowKey(request.getPassTemplate());
    }

    /* 根据 Feedback 对象生成 RowKey */
    public static String genFeedbackRowKey(Feedback feedback) {

        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString() +
                (Long.MAX_VALUE - System.currentTimeMillis());
    }
}
