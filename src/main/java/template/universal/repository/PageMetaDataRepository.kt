package template.universal.repository

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import template.universal.model.PageMetaData

@Mapper
interface PageMetaDataRepository {

    @Select("select * from page_meta_data where page_id = #{pageId} limit 1")
    fun getPageMetaData(pageId: String): PageMetaData?
}