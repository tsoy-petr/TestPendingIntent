package com.example.testpendingintent.di

import com.example.testpendingintent.Repository
import org.koin.dsl.module

val repoModule = module {
    single {Repository()}
}