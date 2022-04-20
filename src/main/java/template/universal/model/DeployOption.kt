package template.universal.model

data class DeployOption(
    val id: String,
    val group: String,
    val name: String,
    val description: String,
    val price: Int,
) {
    companion object {
        val DEPLOY_TYPE = listOf(
            DeployOption("DEPLOY_TYPE_STATIC", "DEPLOY_TYPE", "静态部署", "适合无需交互的网站", 0),
            DeployOption("DEPLOY_TYPE_DYNAMIC", "DEPLOY_TYPE", "动态部署", "适合有数据提交的网站", 499),
        )

        val USER_VERIFY = listOf(
            DeployOption("USER_VERIFY_NONE", "USER_VERIFY", "无需验证", "无需验证用户身份", 0),
            DeployOption("USER_VERIFY_EMAIL", "USER_VERIFY", "邮箱验证", "用户访问前验证邮箱是否真实", 500),
            DeployOption("USER_VERIFY_TEL", "USER_VERIFY", "手机验证", "用户访问前验证手机号码是否真实", 1000),
        )

        val DEPLOY_ADDITION = listOf(
            DeployOption("DEPLOY_ADDITION_EXPORT_DATA", "DEPLOY_ADDITION", "数据导出服务(Beta)", "可以将表单数据进行解析并按表格导出", 1),
            DeployOption("DEPLOY_ADDITION_ACCESS_STATS", "DEPLOY_ADDITION", "访问统计服务(Beta)", "统计网站用户访问状况", 1),
            DeployOption("DEPLOY_ADDITION_LARGE_DATA", "DEPLOY_ADDITION", "大容量数据服务", "可存储数据存储量增加10000条(初始1000条)", 1000),
        )

        val DEPLOY_OPTION_GROUP = mapOf(
            "DEPLOY_TYPE" to DEPLOY_TYPE,
            "USER_VERIFY" to USER_VERIFY,
            "DEPLOY_ADDITION" to DEPLOY_ADDITION,
        )
    }
}