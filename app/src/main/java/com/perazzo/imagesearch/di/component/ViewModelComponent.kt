package com.perazzo.imagesearch.di.component

import com.perazzo.imagesearch.di.scope.ActivityScope
import com.perazzo.imagesearch.images.ImageItemViewModel
import com.perazzo.imagesearch.images.ImagesViewModel
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class))
interface ViewModelComponent: AppComponent {

    fun inject(imagesViewModel: ImagesViewModel)

    fun inject(imageItemViewModel: ImageItemViewModel)


}