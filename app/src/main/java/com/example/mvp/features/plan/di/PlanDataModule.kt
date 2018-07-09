package com.example.mvp.features.plan.di

import com.example.mvp.features.plan.net.PlanAPIService
import com.example.mvp.features.plan.plans.data.repository.PlanRepository
import com.example.mvp.features.plan.plans.domain.GetPlanDetailsUseCase
import com.example.mvp.features.plan.plans.domain.GetPlansUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Iliya Gogolev on 12/20/17.
 */

@Module
class PlanDataModule {

    @Provides
    fun provideGetPlansUseCase(repository: PlanRepository): GetPlansUseCase = GetPlansUseCase(repository)

    @Provides
    fun provideGetPlanDetailsUseCase(repository: PlanRepository): GetPlanDetailsUseCase = GetPlanDetailsUseCase(repository)

    @Provides
    fun providePlanRepository(apiService: PlanAPIService): PlanRepository = PlanRepository(apiService)

    @Provides
    fun providePlanAPIService(retrofit: Retrofit): PlanAPIService {
        return retrofit.create(PlanAPIService::class.java)
    }
}