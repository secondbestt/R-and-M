package com.reddit.rickandmortyapp.noncompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reddit.rickandmortyapp.R
import com.reddit.rickandmortyapp.Utils.ApiUtills
import com.reddit.rickandmortyapp.model.CharactersCevap
import com.reddit.rickandmortyapp.model.Result
import kotlinx.android.synthetic.main.activity_main_non_compose.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NonComposeActivity : AppCompatActivity() {
    private var recyclerViewAdapter : RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_non_compose)


       val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        reycylerView.layoutManager = layoutManager
        downloadList()


    }


    fun downloadList(){
        val daoI = ApiUtills.getDaoInterface()
        daoI.downloadFromAPI().enqueue(object : Callback<CharactersCevap> {
            override fun onResponse(call: Call<CharactersCevap>, response: Response<CharactersCevap>) {
                if (response.isSuccessful){
                    val cryptoModels = response.body()!!.results
                    cryptoModels?.let {
                        recyclerViewAdapter = RecyclerViewAdapter(it as ArrayList<Result>)
                        reycylerView.adapter = recyclerViewAdapter
                    }
                }
            }
            override fun onFailure(call: Call<CharactersCevap>, t: Throwable) {
                Log.e(".",".")
            }
        })
    }
}

