class JsonObject {
    private val map = mutableMapOf<String, Any>()

    fun appendData(key: String, value: Any) {
        map[key] = value
    }

    override fun toString(): String {
        val properties = map.entries.joinToString(",\n\t") { (key, value) ->
            "\"$key\": ${"\"$value\""}"
        }
        return "{\n\t$properties\n}"
    }
}

fun json(init: JsonObject.() -> Unit): JsonObject {
    return JsonObject().apply(init)
}