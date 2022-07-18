package com.wallace.design_system.presentation.activity

import android.content.Intent
import android.os.Bundle
import com.wallace.design_system.databinding.ActivityDesignSystemBinding
import com.wallace.design_system.presentation.viewmodel.DesignSystemViewModel

class DesignSystemActivity : BaseActivity<DesignSystemViewModel>() {
    private lateinit var binding: ActivityDesignSystemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesignSystemBinding.inflate(layoutInflater)
        super.setContentView(binding.root)
        initViewModels()
        initListeners()
    }

    private fun initViewModels() {
        viewModel.getDesignSystem()
    }

    private fun initListeners() {
        binding.btnClassicLayout.setOnClickListener {
            navigateTo("android.design_system.classic_layout.open")
        }

        binding.btnComposeLayout.setOnClickListener {
            navigateTo("android.design_system.compose_layout.open")
        }
    }

}