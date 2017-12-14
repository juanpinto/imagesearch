package com.perazzo.imagesearch.di.component

import com.perazzo.imagesearch.di.scope.ActivityScope
import com.perazzo.imagesearch.images.ImagesActivity
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class))
interface ActivityComponent: AppComponent {

    fun inject(imagesActivity: ImagesActivity)
}