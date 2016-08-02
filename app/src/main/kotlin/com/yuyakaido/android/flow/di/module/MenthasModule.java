package com.yuyakaido.android.flow.di.module;

import com.yuyakaido.android.flow.infra.api.client.MenthasApi;
import com.yuyakaido.android.flow.infra.api.client.MenthasClient;
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator;
import com.yuyakaido.android.flow.infra.constant.InfraConst;
import com.yuyakaido.android.flow.infra.repository.MenthasRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yuyakaido on 7/30/16.
 */
@Module
public class MenthasModule {

    @Provides
    public MenthasRepository provideMenthasRepository(MenthasClient client) {
        return new MenthasRepository(client);
    }

    @Provides
    public MenthasClient provideMenthasClient(MenthasApi api) {
        return new MenthasClient(api);
    }

    @Provides
    public MenthasApi provideMenthasApi() {
        return ApiClientGenerator.Companion.createJsonClient(
                MenthasApi.class, InfraConst.Companion.getMENTHAS_BASE_URL());
    }

}
