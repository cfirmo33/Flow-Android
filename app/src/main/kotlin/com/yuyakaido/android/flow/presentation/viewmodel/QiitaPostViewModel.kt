package com.yuyakaido.android.flow.presentation.viewmodel

import com.yuyakaido.android.flow.domain.usecase.GetQiitaSubscriptionUseCase
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaPostViewModel @Inject constructor(
        getQiitaSubscriptionUseCase: GetQiitaSubscriptionUseCase) : ViewModel {

    val qiitaSubscriptions = getQiitaSubscriptionUseCase.getQiitaSubscriptions()

}