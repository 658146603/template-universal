package template.universal.model

data class User(var uid: String, var name: String, var email: String, var password: String) {
    constructor() : this("", "", "", "")
}
