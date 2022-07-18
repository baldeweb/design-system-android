package com.wallace.design_system.presentation.activity

import android.os.Bundle
import com.wallace.design_system.databinding.ActivityComposeLayoutBinding
import com.wallace.design_system.presentation.viewmodel.DesignSystemViewModel

class ComposeLayoutActivity : BaseActivity<DesignSystemViewModel>() {
    private lateinit var binding: ActivityComposeLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComposeLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}