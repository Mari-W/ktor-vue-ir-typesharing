package social.socials

import social.Social

@ExperimentalJsExport
@JsExport
class Twitter(username: String) : Social("Twitter", "https://twitter.com/$username")
