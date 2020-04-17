package com.imooc.passbook.passbook.dao;

import com.imooc.passbook.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* Merchants Dao 接口 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /* 通过 id 获取商户对象 */
    Merchants findById();

    /* 通过 name 获取商户对象 */
    Merchants findByName();

    /* 通过 ids 获取商户对象  */
    List<Merchants> findByIdIn(List<Integer> ids);
}
