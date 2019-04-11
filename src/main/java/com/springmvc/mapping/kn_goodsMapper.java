package com.springmvc.mapping;

import com.springmvc.pojo.DTO.GoodsAttributeDto;
import com.springmvc.pojo.GoodsDetail;
import com.springmvc.pojo.kn_goods;
import com.springmvc.pojo.kn_goodsSupper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 产品类
 */
public interface kn_goodsMapper extends Mapper<kn_goods> {

    /**
     * Description：
     * 查询商品详情接口
     * 通过排序级别排序
     *
     * @param , pageSize, id]
     * @return java.util.List<com.springmvc.pojo.kn_goods>
     * @author boyang
     * @date 2019/2/27 14:27
     */
    List<kn_goods> getGoodsList();

    /**
     * Description：得到商家产品列表
     *
     * @param , response, pageNo：当前页, pageSize：页容量,title:产品名称，Index1排序方式，propertyId产品属性，statusId审核状态
     * @return com.springmvc.pojo.PageResultInfo
     * @author boyang
     * @date 11:21
     */
    List<GoodsAttributeDto> queryGoodsList(GoodsAttributeDto kn_goods);
    /**
     * Description：通过id得到商品详情id
     * @author boyang
     * @date 2019/3/8 17:46
     * @param
     * @return
     */
    int getDetailId(Integer id);

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
    List<kn_goods> queryGoodes(@Param("title") String name);


    /**
     * 根据id查询商家信息
     * @param id
     * @return
     */
    int queryMerchantId(Integer id);

    /**
     * 根据id删除商家产品
     */
    int delectMerchant(Integer id);


    /**
     * Description：得到超市产品列表
     *
     * @param , response, pageNo：当前页, pageSize：页容量,title:产品名称，Index1排序方式，propertyId产品属性，statusId审核状态
     * @return com.springmvc.pojo.PageResultInfo
     * @author boyang
     * @date 11:21
     */
    List<kn_goodsSupper> queryGoods(kn_goodsSupper kn_goods);


    /**
     * 插入超市表 不用插入详情表的语句
     */
    int insertGoodsSk(kn_goods kn_goods);

    /***
     * 插入详情表，获得插入id
     */
    int insertGoodsDetailSK(GoodsDetail goodsDetail);
    /**
     * 编辑超市表 不用编辑详情表
     */
    int updateGoodsSk(kn_goods kn_goods);
    /**
     * 编辑超详情,获得编辑id
     */
    int updateGoodsDetailSK(GoodsDetail goodsDetail);

    //删除超市表
    int deleteGoodsSk(kn_goods kn_goods);
    //删除详情表，获得删除id
    int deleteGoodsDetailSK(GoodsDetail goodsDetail);
    
    //超市回显根据id查询对应的产品
    kn_goods selectGoodsSK(int id);

    /**
     * Description： 更新产品胡pvuv
     * @author boyang
     * @date 2019/4/3 9:55
     * @param
     * @return
     */
    Integer updateGoodspvuv(@Param(value = "list")List<kn_goods> list);
/**
 * Description：单个更新产品的pvuv
 * @author boyang
 * @date 2019/4/9 22:48
 * @param
 * @return
 */
Integer updateOnepvuv(kn_goods kn_goods);

    /**
     * @Author 苏俊杰
     * @Description //TODO 根据id查询详情表的数据
     * @Date 14:44 2019/4/3
     * @Param
     * @return
     **/
    GoodsDetail selectGoodsOne(int id);

}
