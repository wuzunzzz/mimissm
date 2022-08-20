package com.wzz.service.impl;

import com.wzz.mapper.ProductTypeMapper;
import com.wzz.pojo.ProductType;
import com.wzz.pojo.ProductTypeExample;
import com.wzz.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {

    //在业务逻辑层一定会有数据访问层的对象
    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
