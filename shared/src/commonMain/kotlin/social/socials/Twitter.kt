package social.socials

import social.Social
import kotlin.js.JsExport

@JsExport
class Twitter(username: String) : Social("Twitter", "https://twitter.com/$username")
