package com.springmvc.service;

import com.springmvc.pojo.KnTag;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_tag;

public interface KnTagService extends BaseService<KnTag> {
    /**
     * 标签删除
     */
    int MercjatTagDelete(Integer id);

    /**
     * 获取标签列表 分页
     * @param pageNo
     * @param pageSize
     * @param title
     * @return
     */
    PageResultInfo queryListTag(Integer pageNo, Integer pageSize, String title);

    /**
     * 增加标签
     * @param knTag
     * @return
     */
    int MercjatTagIncrease(kn_tag knTag);
    /**
     * 编辑标签
     */
    int MercjatTagUpadete(kn_tag knTag);
    /**
     * @Author 苏俊杰
     * @Description //TODO 获取标签的回显 根据Id查询数据
     * @Date 14:41 2019/3/29
     * @Param
     * @return
     **/
    kn_tag selectByidTag(Integer id);
}
