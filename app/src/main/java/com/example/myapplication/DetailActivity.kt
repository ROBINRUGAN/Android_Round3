package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R.id.textview
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.up_item.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val upName = intent.getStringExtra("up.name")
        val upImageId = intent.getIntExtra("up.imageId", 0)
        headImage.setImageResource(upImageId)
        name.text = upName
        button.setOnClickListener {
            if (button.text == "关注") {
                button.text = "取关"
                fans.text = (Integer.parseInt(fans.text.toString()) + 1).toString()
                Toast.makeText(this, "关注成功！", Toast.LENGTH_SHORT).show()
                upName?.let { it1 -> ups(it1, upImageId) }?.let { it2 -> MainActivity.addup(it2) }


            } else {
                button.text = "关注"
                fans.text = (Integer.parseInt(fans.text.toString()) - 1).toString()
                Toast.makeText(this, "取关成功！", Toast.LENGTH_SHORT).show()
                if (upName != null) {
                    MainActivity.delUpById(MainActivity.getIdByName(upName))
                }
            }
        }
    }

}



