package com.yuyakaido.android.flow.infra.api.response

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Created by yuyakaido on 8/2/16.
 */
@Root(name = "rdf:RDF", strict = false)
class HatenaArticleListResponse {

    @set:ElementList(name = "items", inline = true)
    @get:ElementList(name = "items", inline = true)
    var items: List<HatenaArticleResponse>? = null

}