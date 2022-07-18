package com.wallace.design_system.presentation.activity

import android.os.Bundle
import com.wallace.design_system.databinding.ActivityClassicLayoutBinding
import com.wallace.design_system.presentation.viewmodel.DesignSystemViewModel

class ClassicLayoutActivity : BaseActivity<DesignSystemViewModel>() {
    private lateinit var binding: ActivityClassicLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassicLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}