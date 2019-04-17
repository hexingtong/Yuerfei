package com.springmvc.service;

import com.springmvc.pojo.GoodsDetail;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.VO.GoodsSupermarketDvo;
import com.springmvc.pojo.kn_goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description：
 * @author boyang
 * @date 2019/2/27 15:01
 * @param
 * @return
 */
public interface kn_goodsservice extends BaseService<kn_goods> {


    /**
     * Description：
     * 查询商品详情接口
     * 不包括广位
     *
     * @param , pageSize, id]
     * @return java.util.List<com.springmvc.pojo.kn_goods>
     * @author boyang
     * @date 2019/2/27 14:27
     */
    List<kn_goods> getGoodsList();
    /**
     * Description：
     * 查询商品详情接口
     *
     *
     * @param , pageSize, id]
     * @return java.util.List<com.springmvc.pojo.kn_goods>
     * @author boyang
     * @date 2019/2/27 14:27
     */
    List<kn_goods> getGoodsList2();
    /**
     * Description：得到商家产品列表
     *
     * @param , response, pageNo：当前页, pageSize：页容量,title:产品名称，Index1排序方式，propertyId产品属性，statusId审核状态
     * @return com.springmvc.pojo.PageResultInfo
     * @author boyang
     * @date 11:21
     */
    PageResultInfo queryGoodsList(Integer pageNo, Integer pageSize, String title, Integer Index1, Integer propertyId, Integer statusId);
    /**
     * Description：通过id得到商品详情id
     * @author boyang
     * @date 2019/3/8 17:46
     * @param
     * @return
     */
    Integer getDetailId(Integer id);
    /**
     * Description：模糊查找含有精选的商品
     * @author boyang
     * @date 2019/3/12 12:31
     * @param
     * @return
     */
    List<kn_goods> queryByTagid();
    /**
     * Description：一对多模糊查找
     * @author boyang
     * @date 2019/3/12 19:42
     * @param
     * @return
     */
    List<kn_goods> queryGoodes(String title);

    /**
     * Description：得到超市产品列表
     *
     */
    PageResultInfo queryGoods(Integer pageNo, Integer pageSize, String title, Integer Index1, Integer propertyId, Integer status);

    /**
     * 增加超市列表
     */
    int insertSupermarket(GoodsSupermarketDvo goodsSupermarketDvo);

    /**
     * 编辑超市列表
     */
    int updateSupermarket(GoodsSupermarketDvo goodsSupermarketDvo);
    /**
     * 删除超市列表
     */
    int deleteSupermarket(GoodsSupermarketDvo goodsSupermarketDvo);
    /**
     * 根据id查询超市名称
     */
    kn_goods selectGoodsSK(int id);
    /**
     * Description：更新goods胡pv uv
     * @author boyang
     * @date 2019/3/25 17:34
     * @param
     * @return com.springmvc.pojo.kn_goods
     */
      int  upgoodsPvUv();

    /**
     * Description：得到pagegoodslist
     * @author boyang
     * @date 2019/4/2 11:36
     * @param
     * @return
     */
        PageResultInfo pagegoodslist(Integer pageNo, Integer pageSize);

        /**
         * @Author 苏俊杰
         * @Description //TODO 根据goods Id 得到详情表数据
         * @Date 14:49 2019/4/3
         * @Param
         * @return
         **/
        GoodsDetail selectGoodsOne(int id);


    /**
     * Description： 更新产品胡pvuv
     * @author boyang
     * @date 2019/4/3 9:55
     * @param
     * @return
     */
    Integer updateGoodspvuv();
}
