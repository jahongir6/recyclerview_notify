package com.example.rvnotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rvnotify.adapter.RvAdapter
import com.example.rvnotify.databinding.ActivityMainBinding
import com.example.rvnotify.model.User

class MainActivity : AppCompatActivity(),RvAdapter.RvClick{
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvAdapter = RvAdapter(rvClick = this)
        binding.rv.adapter = rvAdapter

        binding.apply {
            btnSave.setOnClickListener {
                var user = User(edtName.text.toString(),edtNumber.text.toString().toInt())
                rvAdapter.list.add(user)
               // rvAdapter.notifyDataSetChanged()//resyclerviewni polniy yangiledi
            rvAdapter.notifyItemInserted(rvAdapter.list.size-1)//bu faqat oxiridagi yangilanadi
            }
        }
    }

    override fun onClick(user: User, position: Int) {
        rvAdapter.list.remove(user)
        rvAdapter.notifyItemRemoved(position)
    }
}