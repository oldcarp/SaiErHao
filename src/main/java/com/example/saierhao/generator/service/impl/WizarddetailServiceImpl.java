package com.example.saierhao.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.saierhao.generator.domain.Wizarddetail;
import com.example.saierhao.generator.mapper.WizarddetailMapper;
import com.example.saierhao.generator.service.WizarddetailService;
import org.springframework.stereotype.Service;

/**
 * @author OldCarp
 * @description 针对表【wizarddetail】的数据库操作Service实现
 * @createDate 2024-07-02 14:03:33
 */
@Service
public class WizarddetailServiceImpl extends ServiceImpl<WizarddetailMapper, Wizarddetail>
        implements WizarddetailService {
    @Override
    public WizarddetailMapper getBaseMapper() {
        return super.getBaseMapper();
    }
}




