package com.imooc.passbook.passbook.service;

import com.imooc.passbook.passbook.vo.PassTemplate;

/* Pass Hbase 服务 */
public interface IHBasePassService {

    /* 将 PassTemplate 写入 HBase */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);
}
