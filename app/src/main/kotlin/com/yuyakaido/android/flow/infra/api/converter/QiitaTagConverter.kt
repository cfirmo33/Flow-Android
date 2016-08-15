package com.yuyakaido.android.flow.infra.api.converter

import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.infra.api.response.QiitaTagResponse

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaTagConverter {

    companion object {

        fun convert(responses: List<QiitaTagResponse>): List<QiitaTag> {
            return responses.map { QiitaTag(it.id, it.iconUrl) }.toList()
        }

    }

}