package com.example.mvp.di.scope

import kotlin.annotation.Retention
import kotlin.annotation.AnnotationRetention

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope
