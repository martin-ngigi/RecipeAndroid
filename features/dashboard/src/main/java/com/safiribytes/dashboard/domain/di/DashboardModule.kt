package com.safiribytes.dashboard.domain.di
import com.safiribytes.core.utils.HttpUtil
import com.safiribytes.dashboard.data.datasource.remote.HomeDatasource
import com.safiribytes.dashboard.data.repository.HomeRepositoryImpl
import com.safiribytes.dashboard.domain.repositories.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DashboardModule {

    @Provides
    @Singleton
    fun provideDataSource(
        httpUtil: HttpUtil
    ): HomeDatasource{
        return HomeDatasource(httpUtil = httpUtil)
    }

    @Provides
    @Singleton
    fun provideRepository(homeDatasource: HomeDatasource): HomeRepository{
        return HomeRepositoryImpl(
            homeDatasource = homeDatasource
        )
    }


}