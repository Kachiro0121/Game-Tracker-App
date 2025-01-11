package com.kachiro.core_api.di

import com.kachiro.core_api.network.NetworkProvider

interface ApplicationComponentProvider: NetworkProvider, AppProvider, MediatorProvider, NavigateProvide