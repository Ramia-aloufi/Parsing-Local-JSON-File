package com.example.parsinglocaljsonfile

import android.content.Context
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var rv:RecyclerView
    lateinit var al:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)
        al = arrayListOf()
        var file =  applicationContext.assets.open("data.json").bufferedReader().use { it.readText() }

        getimg(file)
        rv.adapter = MyAdapter(al,this)
        rv.layoutManager = LinearLayoutManager(this)

    }
//    fun AssetManager.readFile(fileName: String) = open(fileName)
//        .bufferedReader()
//        .use { it.readText() }

    fun getimg(file:String) {
        var items = JSONArray(file)
        var img = ""
        Log.d("iitt", "$items")
        for (i in 0 until items.length()) {
             img = items.getJSONObject(i).getString("url")
            Log.d("iitt", "$img")

            al.add(img)
            Log.d("aall", "$al")


        }
        rv.adapter?.notifyDataSetChanged()

    }


//    fun Context.readJsonAsset(fileName: String): String {
//        val inputStream = assets.open(fileName)
//        val size = inputStream.available()
//        val buffer = ByteArray(size)
//        inputStream.read(buffer)
//        inputStream.close()
//        return String(buffer, Charsets.UTF_8)
//    }

    }

//     fun loadJSONFromAsset():String?{
//        var json = ""
//        try {
//            var rr = this.assets.open("data.json")
//            var size = rr.available()
//            var buffer:ByteArray = byteArrayOf(size.toByte())
//            rr.read(buffer);
//            rr.close();
//            json = buffer.toString();
//        } catch (e:Exception ) {
//            println("loadJSONFromAsset $e" );
//            return null;
//        }
//        return json;
//    }



