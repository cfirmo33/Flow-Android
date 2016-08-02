package com.yuyakaido.android.flow.infra.api.response

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by yuyakaido on 8/3/16.
 */
@Root(name = "item", strict = false)
class HatenaArticleResponse {

    @set:Element(name = "title")
    @get:Element(name = "title")
    lateinit var title: String

    @set:Element(name = "link")
    @get:Element(name = "link")
    lateinit var link: String

}