package com.ruoyi.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.shop.domain.ProductSpecOption;
import com.ruoyi.shop.service.IProductSpecOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ProductSkuMapper;
import com.ruoyi.shop.domain.ProductSku;
import com.ruoyi.shop.service.IProductSkuService;

/**
 * 商品规格信息Service业务层处理
 *
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class ProductSkuServiceImpl implements IProductSkuService {
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private IProductSpecOptionService productSpecOptionService;


    /**
     * 查询商品规格信息
     *
     * @param id 商品规格信息主键
     * @return 商品规格信息
     */
    @Override
    public ProductSku selectProductSkuById(Long id) {

        return productSkuMapper.selectProductSkuById(id);
    }


    /**
     * 查询商品规格信息列表
     *
     * @param productSku 商品规格信息
     * @return 商品规格信息
     */
    @Override
    public List<ProductSku> selectProductSkuList(ProductSku productSku) {
        List<ProductSku> productSkus = productSkuMapper.selectProductSkuList(productSku);

        for (ProductSku sku:productSkus){
            String specOptionIds = sku.getSpecOptionIds();
            sku.setSpecs(getSpecsByIds(specOptionIds,sku.getGoodsId()));
        }


        return productSkus;
    }

    public List<String>   getSpecsByIds(String  specs, Long goodsId) {

        List<String> mList=new ArrayList<>();
        String[] split = specs.split(",");

        for (int i = 0; i < split.length; i++) {
            Long specId = Long.parseLong(split[i]);
           ProductSpecOption productSpecOption = productSpecOptionService.selectProductSpecOptionById(specId);

           mList.add(productSpecOption.getName());
        }


        return mList;
    }




    /**
     * 新增商品规格信息
     *
     * @param productSku 商品规格信息
     * @return 结果
     */
    @Override
    public int insertProductSku(ProductSku productSku) {
        productSku.setCreateTime(DateUtils.getNowDate());
        return productSkuMapper.insertProductSku(productSku);
    }

    /**
     * 修改商品规格信息
     *
     * @param productSku 商品规格信息
     * @return 结果
     */
    @Override
    public int updateProductSku(ProductSku productSku) {
        productSku.setUpdateTime(DateUtils.getNowDate());
        return productSkuMapper.updateProductSku(productSku);
    }

    /**
     * 批量删除商品规格信息
     *
     * @param ids 需要删除的商品规格信息主键
     * @return 结果
     */
    @Override
    public int deleteProductSkuByIds(String[] ids) {
        return productSkuMapper.deleteProductSkuByIds(ids);
    }

    /**
     * 删除商品规格信息信息
     *
     * @param id 商品规格信息主键
     * @return 结果
     */
    @Override
    public int deleteProductSkuById(String id) {
        return productSkuMapper.deleteProductSkuById(id);
    }

    @Override
    public ProductSku selectProductSkuByGoodsId(Long goodsId) {
        ProductSku query = new ProductSku();
        query.setGoodsId(goodsId);
        List<ProductSku> productSkus = productSkuMapper.selectProductSkuList(query);
        if (productSkus.isEmpty())
            return null;
        return productSkus.get(0);
    }

    @Override
    public int updateSaleCount(Long id) {
        return  productSkuMapper.updateSkuSaleCount(id);
    }

    @Override
    public int deleteProductSkuByGoodsId(Long goodsId) {
        return productSkuMapper.deleteProductSkuByGoodsId(goodsId);
    }
}
