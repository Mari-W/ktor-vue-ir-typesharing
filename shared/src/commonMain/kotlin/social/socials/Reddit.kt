package social.socials

import social.Social
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@ExperimentalJsExport
@JsExport
class Reddit(username: String) : Social("Reddit", "https://reddit.com/u/$username")
