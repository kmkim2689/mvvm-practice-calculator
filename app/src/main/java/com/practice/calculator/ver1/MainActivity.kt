package com.practice.calculator.ver1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.practice.calculator.R
import com.practice.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 액티비티에서 사용할 뷰모델을 정의한다.
    private lateinit var viewModel: CalculatorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // databinding을 이용하기 위하여, 다음과 같이 binding 객체를 정의한다.
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        // databinding을 사용할 수 있도록, viewmodel을 선언한다.
        // 이 때, ViewModelProvider를 이용한다(말 그대로 액티비티/프래그먼트 클래스에서 뷰모델을 공급받기 위하여).
        // 현재 액티비티 혹은 프래그먼트에 가져올 Viewmodel 클래스를 명시한다. getter를 이용한다.
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        // 앞서 가져온 뷰 모델을 binding 객체의 viewModel 속성에 할당함으로써,
        // viewModel과 데이터 바인딩 라이브러리가 상호작용할 수 있게 된다.
        // 즉 데이터의 변화에 따라 자동적으로 값이 바뀌게 된다.
        binding.viewModel = viewModel
        // 옵저버 패턴을 구성하는 과정 => viewmodel의 라이프사이클 변경 사항을 라이브러리가 감지할 수 있게 된다.
        // lifecycleOwner를 현재 클래스로 설정.
        // 이렇게 함으로써, ViewModel과 데이터 바인딩 라이브러리 간의 옵저버 패턴을 구성한다.
        binding.lifecycleOwner = this

        binding.btn.setOnClickListener {
            // 버튼을 누르면, viewmodel 안의 라이브 데이터인 result의 값이 변경된다.
            // 그렇게 되면, 옵저버(뷰)가 result의 변화를 감지하여, 결과 화면에 반영해주게 된다.(xml 파일 참고)
            viewModel.calculate(binding.num1Edittext.text.toString(), binding.num2Edittext.text.toString())
        }
        // 덧셈 버튼 클릭 시 뷰모델에 덧셈 연산 요청을 보내도록 합니다.
        // 뷰모델에서 결과값이 변경될 때마다 자동으로 UI가 업데이트되도록 바인딩해줍니다.
    }
}