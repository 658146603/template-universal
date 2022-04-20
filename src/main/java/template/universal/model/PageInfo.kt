package template.universal.model

data class PageInfo(val title: String, val elements: String, val features: String) {
    constructor(): this("", "", "")
}