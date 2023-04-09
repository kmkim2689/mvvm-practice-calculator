package com.practice.calculator

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.practice.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CalculatorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.btn.setOnClickListener {
            viewModel.calculate(binding.num1Edittext.text.toString(), binding.num2Edittext.text.toString())
        }
        // 덧셈 버튼 클릭 시 뷰모델에 덧셈 연산 요청을 보내도록 합니다.
        // 뷰모델에서 결과값이 변경될 때마다 자동으로 UI가 업데이트되도록 바인딩해줍니다.
    }
}