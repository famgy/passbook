package com.imooc.passbook.dao;

import com.imooc.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /* 根据 id 获取商户对象 */
    Merchants findById(Integer id);

    /* 根据 name 获取商户对象 */
    Merchants findByName(String name);
}
