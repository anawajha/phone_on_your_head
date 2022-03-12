package com.anawajha.phoneonyourhead

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anawajha.phoneonyourhead.adapter.CategoryAdapter
import com.anawajha.phoneonyourhead.shared.categories

class Categories : AppCompatActivity(),CategoryAdapter.OnClick {
    lateinit var rv :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        rv = findViewById(R.id.rv_categories)

        rv.adapter = CategoryAdapter(this, categories,this)
        rv.layoutManager = GridLayoutManager(this,3)

    }

    override fun onClickItem(position: Int) {
        val i = Intent(this,Game::class.java)
        i.putStringArrayListExtra("a", categories[position].words)
        startActivity(i)
    }

    override fun onResume() {
        super.onResume()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}