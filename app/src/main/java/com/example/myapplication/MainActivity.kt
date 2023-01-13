package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var adapter: upsAdapter? = null
        val upList = ArrayList<ups>()
        fun delUpById(it: Int) {
            upList.removeAt(it)
            adapter?.notifyDataSetChanged()
        }


        fun getIdByName(name: String): Int {
            var ans: Int = 0
            for ((index, value) in upList.withIndex()) {
                if (value.name == name)
                    ans = index
            }
            return ans
        }

        fun addup(ups: ups) {
            var flag = 0
            for (up in upList) {
                if (up.name == ups.name) {
                    flag = 1
                }
            }
            if (flag == 0) upList.add(ups)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUps()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview.layoutManager = layoutManager
        adapter = upsAdapter(upList, textview, imageview)
        recyclerview.adapter = adapter

    }

    private fun initUps() {
        upList.add(ups("MEWW", R.drawable._20221217204647))
        upList.add(ups("林木心", R.drawable._20230113155117))
        upList.add(ups("超超", R.drawable._20230113161550))
        upList.add(ups("小黄老师", R.drawable.qq20230113161811))
        upList.add(ups("二火", R.drawable.qq20230113161905))
        upList.add(ups("墨子", R.drawable.qq20230113161948))
    }
}