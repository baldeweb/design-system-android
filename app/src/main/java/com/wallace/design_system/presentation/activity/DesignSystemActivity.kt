package com.wallace.design_system.presentation.activity

import android.os.Bundle
import com.wallace.design_system.databinding.ActivityDesignSystemBinding
import com.wallace.design_system.presentation.viewmodel.DesignSystemViewModel

class DesignSystemActivity : BaseActivity<DesignSystemViewModel>() {
    private lateinit var binding: ActivityDesignSystemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesignSystemBinding.inflate(layoutInflater)
        super.setContentView(binding.root)
    }
}