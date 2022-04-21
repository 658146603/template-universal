package template.universal.model

class RemoteAction(val server: String, val action: String) {
    companion object {
        const val ACTION_DEPLOY = "DEPLOY"
    }

    val isDeploy: Boolean
        get() = action == ACTION_DEPLOY
}