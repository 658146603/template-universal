package template.universal.repository

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import template.universal.model.PageMetaData

@Mapper
interface PageMetaDataRepository {

    @Select("select * from page_meta_data where page_id = #{pageId} limit 1")
    fun getPageMetaData(pageId: String): PageMetaData?

    @Insert("insert into page_meta_data (page_id, page_verify) values (#{pageId}, #{pageVerify})")
    fun addPageMetaData(pageId: String, pageVerify: Boolean): Int
}