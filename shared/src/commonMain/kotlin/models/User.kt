package models

import kotlin.js.JsExport

@JsExport
data class User(val first: String, val last: String, val age: Int, val weight: Float)
