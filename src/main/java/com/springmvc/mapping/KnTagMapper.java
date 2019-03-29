package com.springmvc.mapping;

import com.springmvc.pojo.KnTag;
import com.springmvc.pojo.kn_tag;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface KnTagMapper extends Mapper<KnTag> {

    /**
     * Description：通过名称模糊查收，标签展示
     * @author boyang
     * @date  19:43
     * @param
     * @return
     */
    /**
     * 模糊查询标签列表，标签展示
     * @param title
     * @return
     */
    List<kn_tag> queryListTag(@Param("title") String title);

    /***
     * 增加标签
     * @param knTag
     * @return
     */
    int MercjatTagIncrease(kn_tag knTag);
    /***
     * 编辑标签
     */
    int MercjatTagUpadete(kn_tag knTag);

    /***
     * 删除
     * @param id
     * @return
     */
    int MercjatTagDelete(Integer id);
    /**
     * @Author 苏俊杰
     * @Description //TODO 获取标签的回显 根据Id查询数据
     * @Date 14:41 2019/3/29
     * @Param
     * @return
     **/
    kn_tag selectByidTag(Integer id);
}