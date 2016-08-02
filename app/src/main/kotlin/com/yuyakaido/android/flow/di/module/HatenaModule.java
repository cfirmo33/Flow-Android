package com.yuyakaido.android.flow.di.module;

import com.yuyakaido.android.flow.infra.api.client.HatenaApi;
import com.yuyakaido.android.flow.infra.api.client.HatenaClient;
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator;
import com.yuyakaido.android.flow.infra.constant.InfraConst;
import com.yuyakaido.android.flow.infra.repository.HatenaRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yuyakaido on 8/2/16.
 */
@Module
public class HatenaModule {

    @Provides
    public HatenaRepository provideHatenaRepository(HatenaClient client) {
        return new HatenaRepository(client);
    }

    @Provides
    public HatenaClient provideHatenaClient(HatenaApi api) {
        return new HatenaClient(api);
    }

    @Provides
    public HatenaApi provideHatenaApi() {
        return ApiClientGenerator.Companion.createXmlClient(
                HatenaApi.class, InfraConst.Companion.getHATENA_BASE_URL());
    }

}
