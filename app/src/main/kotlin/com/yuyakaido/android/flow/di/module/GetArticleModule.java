package com.yuyakaido.android.flow.di.module;

import com.yuyakaido.android.flow.domain.usecase.GetArticleUseCase;
import com.yuyakaido.android.flow.infra.repository.HatenaRepository;
import com.yuyakaido.android.flow.infra.repository.MenthasRepository;
import com.yuyakaido.android.flow.infra.repository.QiitaRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yuyakaido on 8/3/16.
 */
@Module
public class GetArticleModule {

    @Provides
    public GetArticleUseCase provideGetArticlesUseCase(
            MenthasRepository menthasRepository,
            QiitaRepository qiitaRepository,
            HatenaRepository hatenaRepository) {
        return new GetArticleUseCase(menthasRepository, qiitaRepository, hatenaRepository);
    }

}
