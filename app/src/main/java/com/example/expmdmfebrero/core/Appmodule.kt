package com.example.expmdmfebrero.core

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.example.expmdmfebrero")
class Appmodule {
    @Single
    fun provideString(): String {
        return "Hello Koin"
    }
}