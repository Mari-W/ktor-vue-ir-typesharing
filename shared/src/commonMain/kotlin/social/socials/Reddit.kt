package social.socials

import social.Social
import kotlin.js.JsExport

@JsExport
class Reddit(username: String) : Social("Reddit", "https://reddit.com/u/$username")
