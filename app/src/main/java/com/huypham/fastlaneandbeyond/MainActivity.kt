package com.huypham.fastlaneandbeyond

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.huypham.fastlaneandbeyond.databinding.ActivityMainBinding

/**
 * @author huypham on 1/6/21
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAsk.setOnClickListener {
            binding.imgBall.setImageResource(getDices()[(0..4).random()])
        }
    }

    private fun getDices(): Array<Int> = arrayOf(
        R.drawable.ball1,
        R.drawable.ball2,
        R.drawable.ball3,
        R.drawable.ball4,
        R.drawable.ball5
    )
}
