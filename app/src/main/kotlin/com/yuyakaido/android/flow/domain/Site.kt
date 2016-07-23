package com.yuyakaido.android.flow.domain

import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
enum class Site {
    Menthas {
        override fun articles(category: Category): Single<List<Article>> {
            return MenthasRepository.getArticles(category)
        }
    }, Qiita {
        override fun articles(category: Category): Single<List<Article>> {
            return QiitaRepository.getArticles(category)
        }
    };

    abstract fun articles(category: Category): Single<List<Article>>
}