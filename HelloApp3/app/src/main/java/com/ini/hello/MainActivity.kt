package com.ini.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ini.hello.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // lateinit var: 지금은 변수 선언만 하고 생성은 잠시 후에 실행하겠다다
   private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 선언된 mainBinding을 activity_main.xml 파일을 열어서
        // inflate(확장)하여 mainBinding 객체(변수)로 초기화하기
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        // mainBinding(??? 확실하지 않음)의 전체를 가져와서 첫 화면에 보여라....???
        setContentView(mainBinding.root)

        val navController = findNavController(R.id.fragmentContainer)
        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.bottom_nav_home, R.id.bottom_nav_book
            )
        )
        setupActionBarWithNavController(navController, appBarConfig)
        mainBinding.bottomNav.setupWithNavController(navController)

    }
}