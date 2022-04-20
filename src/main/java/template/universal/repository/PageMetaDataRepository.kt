package template.universal.repository

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import template.universal.model.PageInfo

@Mapper
interface PageMetaDataRepository {
    @Select("select * from page_info where page_id = #{pageId} limit 1")
    fun getPageInfo(pageId: String): PageInfo?
}