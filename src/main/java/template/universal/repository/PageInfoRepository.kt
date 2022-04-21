package template.universal.repository

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import template.universal.model.PageInfo

@Mapper
interface PageInfoRepository {
    @Select("select * from page_info where page_id = #{pageId} limit 1")
    fun getPageInfo(pageId: String): PageInfo?

    @Insert("insert into page_info (page_id, title, elements, deploy_type, user_verify, deploy_addition) values (#{pageId}, #{title}, #{elements}, #{deployType}, #{userVerify}, #{deployAddition})")
    fun deployPage(pageInfo: PageInfo): Int
}