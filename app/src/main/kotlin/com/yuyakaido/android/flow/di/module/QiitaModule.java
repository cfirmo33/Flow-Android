package com.yuyakaido.android.flow.di.module;

import com.yuyakaido.android.flow.infra.api.client.QiitaApi;
import com.yuyakaido.android.flow.infra.api.client.QiitaClient;
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator;
import com.yuyakaido.android.flow.infra.constant.InfraConst;
import com.yuyakaido.android.flow.infra.repository.QiitaRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yuyakaido on 7/30/16.
 */
@Module
public class QiitaModule {

    @Provides
    public QiitaRepository provideQiitaRepository(QiitaClient client) {
        return new QiitaRepository(client);
    }

    @Provides
    public QiitaClient provideQiitaClient(QiitaApi api) {
        return new QiitaClient(api);
    }

    @Provides
    public QiitaApi provideQiitaApi() {
        return ApiClientGenerator.Companion.generate(
                QiitaApi.class, InfraConst.Companion.getQIITA_BASE_URL());
    }

}
