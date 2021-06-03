package egs.android.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import egs.android.base.navigator.Navigator
import egs.android.base.navigator.impl.NavigatorImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindAuthNavigator(impl: NavigatorImpl): Navigator
}