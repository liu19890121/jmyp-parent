package com.czxy.jmyp.dao;

import com.czxy.jmyp.pojo.SkuComment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SkuCommentMapper extends Mapper<SkuComment> {

    @Select("select count(*) from tb_sku_comment where sku_id = #{skuId}")
    Integer findNumBySkuId( @Param("skuId") Integer skuId);

    @Select("select avg(star) from tb_sku_comment where sku_id = #{skuId}")
    Integer findAvgStarBySkuId(Integer skuId);

    @Select("select count(*) from tb_sku_comment where spu_id = #{spuid} and ratio = #{ratio}")
    Integer findCommentCountByRatio(@Param("spuid")Integer spuId,@Param("ratio")Integer ratio);

    @Select("select count(*) from tb_sku_comment where spu_id = #{spuId}")
    Integer findTotalCommentBySpuid(Integer spuId);


    /**
     * 获取评论数
     * @param spuId
     * @return
     */
    @Select("select count(*) from tb_sku_comment where spu_id = #{spuId}")
    Integer findNumBySpuId(Integer spuId);

    @Select("select * from tb_sku_comment where spu_id = #{spuId}")
    List<SkuComment> findCommentsBySpuId(Integer spuId);
}