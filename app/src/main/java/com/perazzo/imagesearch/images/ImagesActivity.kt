package com.perazzo.imagesearch.images

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.perazzo.imagesearch.ImageSearchApplication
import com.perazzo.imagesearch.R
import com.perazzo.imagesearch.data.controller.ImagesController
import com.perazzo.imagesearch.data.models.Image
import com.perazzo.imagesearch.databinding.ActivityImagesBinding
import com.perazzo.imagesearch.di.component.ActivityComponent
import com.perazzo.imagesearch.di.component.DaggerActivityComponent
import javax.inject.Inject

class ImagesActivity : AppCompatActivity() {

    @Inject
    lateinit var imagesController: ImagesController

    private lateinit var binding: ActivityImagesBinding

    private lateinit var imagesAdapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComponent().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_images)
        setToolbar()
        setRecyclerView()
        binding.viewModel = ImagesViewModel()
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false);
        supportActionBar?.setDisplayShowHomeEnabled(false);

    }

    private fun setRecyclerView() {
        imagesAdapter = ImagesAdapter()
        imagesAdapter.setHasStableIds(true)
        binding.recyclerViewImages.itemAnimator = DefaultItemAnimator()
        val layoutManager = GridLayoutManager(this, 3)
        binding.recyclerViewImages.layoutManager = layoutManager
        binding.recyclerViewImages.adapter = imagesAdapter
    }


    private fun getComponent(): ActivityComponent {
        return DaggerActivityComponent.builder()
                .appComponent(ImageSearchApplication.get().appComponent)
                .build()
    }
}
