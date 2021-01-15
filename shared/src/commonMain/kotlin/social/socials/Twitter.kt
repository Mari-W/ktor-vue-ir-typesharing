package social.socials

import social.Social
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@ExperimentalJsExport
@JsExport
class Twitter(username: String) : Social("Twitter", "https://twitter.com/$username")
