package com.imooc.passbook.passbook.controller;

import com.imooc.passbook.passbook.log.LogConstants;
import com.imooc.passbook.passbook.log.LogGenerator;
import com.imooc.passbook.passbook.service.IFeedbackService;
import com.imooc.passbook.passbook.service.IGainPassTemplateService;
import com.imooc.passbook.passbook.service.IInventoryService;
import com.imooc.passbook.passbook.service.IUserPassService;
import com.imooc.passbook.passbook.vo.Pass;
import com.imooc.passbook.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/* PassBook Rest Controller */
@Slf4j
@RestController
@RequestMapping("/passbook")
public class PassBookController {

    /* 用户优惠券服务 */
    private final IUserPassService userPassService;

    /* 优惠券库存服务 */
    private final IInventoryService iInventoryService;

    /* 领取优惠券服务 */
    private final IGainPassTemplateService iGainPassTemplateService;

    /* 反馈服务 */
    private final IFeedbackService iFeedbackService;

    /* HttpServletRequest */
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public PassBookController(IUserPassService userPassService,
                              IInventoryService iInventoryService,
                              IGainPassTemplateService iGainPassTemplateService,
                              IFeedbackService iFeedbackService,
                              HttpServletRequest httpServletRequest) {
        this.userPassService = userPassService;
        this.iInventoryService = iInventoryService;
        this.iGainPassTemplateService = iGainPassTemplateService;
        this.iFeedbackService = iFeedbackService;
        this.httpServletRequest = httpServletRequest;
    }

    /* 获取用户个人的优惠券信息 */
    @ResponseBody
    @GetMapping("/userpassinfo")
    Response userPassInfo(Long userId) throws Exception {
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.USER_PASS_INFO,
                null
        );

        return userPassService.getUserPassInfo(userId);
    }

    /* 获取用户使用过的优惠券信息 */
    @ResponseBody
    @GetMapping("/userusedpassinfo")
    Response userUsedPassInfo(Long userId) throws Exception {
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.USER_USED_PASS_INFO,
                null
        );

        return userPassService.getUserUsedPassInfo(userId);
    }

    /* 用户使用优惠券 */
    @ResponseBody
    @PostMapping
    Response userUsePass(Pass pass) throws Exception {
        LogGenerator.genLog(
                httpServletRequest,
                pass.getUserId(),
                LogConstants.ActionName.USER_USE_PASS,
                null
        );

        return userPassService.userUsePass(pass);
    }

    /* 获取库存信息 */
    @ResponseBody
    @GetMapping("/inventoryinfo")
    Response inventoryInfo(Long userId) throws Exception {
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.INVENTORY_INFO,
                null
        );

        return iInventoryService.getInventoryInfo(userId);
    }
}
