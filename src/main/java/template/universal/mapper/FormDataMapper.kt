package template.universal.mapper

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import template.universal.model.FormData


@Mapper
interface FormDataMapper {
    @Select("select * from form_data")
    fun getAllFormData(): List<FormData>

    @Insert("insert into form_data (submit_id, submit_ip_address, submit_time, submit_content) values (#{submitId}, #{submitIpAddress}, #{submitTime}, #{submitContent})")
    fun insertFormData(formData: FormData)
}