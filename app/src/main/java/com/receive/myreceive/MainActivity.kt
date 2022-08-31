package com.receive.myreceive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.receive.myreceive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 動的にToolbarの名称を変更する
        //  本P465以外に、以下も参考
        // https://qiita.com/m-coder/items/b50f716f0443fd4948f5
        // 🔶0: nav_main の 各 Fragment　のlabel にToolBarで表示させたい画面名称を設定しておく
        // 🔶1: MainActivityにセットした、NavHost の id から navController を取得する
                        // ⚠ 以下で呼び出すと、onCreate段階でFragmentManagerが初期化状態でエラーが発生する
                            //val navController: NavController = findNavController(R.id.fragmentContainerView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        // 🔶2: navGraphを取得
        val appBarConfig = AppBarConfiguration(navController.graph)
        // 🔶3: toolbar と NavHostFragment を紐づける
        binding.toolbar.setupWithNavController(navController, appBarConfig)
    }
}