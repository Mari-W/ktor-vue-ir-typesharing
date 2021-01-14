package social.socials

import social.Social

@ExperimentalJsExport
@JsExport
class Reddit(username: String) : Social("Reddit", "https://reddit.com/u/$username")
