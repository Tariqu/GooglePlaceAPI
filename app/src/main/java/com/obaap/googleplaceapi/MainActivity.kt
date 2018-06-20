package com.obaap.googleplaceapi

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var sp1:Spinner?=null
    var lview:ListView?=null
    var bt1:Button?=null
    var pDialog:ProgressDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp1=findViewById(R.id.sp1)
        lview=findViewById(R.id.lview)
        bt1=findViewById(R.id.bt1)
        this.pDialog = ProgressDialog(this@MainActivity)
        pDialog!!.setTitle("Message")
        pDialog!!.setMessage("please wait Loading...");
        bt1!!.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                pDialog!!.show()
                var r=Retrofit.Builder().baseUrl("https://maps.googleapis.com/").
                        addConverterFactory(GsonConverterFactory.create()).build()
                var api:PlacesAPI=r.create(PlacesAPI::class.java)
                var call=api.getPlaces(sp1!!.selectedItem.toString())
                call.enqueue(object : Callback<PlacesPOJO>{
                    override fun onFailure(call: Call<PlacesPOJO>?, t: Throwable?) {
                        Toast.makeText(this@MainActivity,"Check Network Connection",Toast.LENGTH_SHORT).show()
                        pDialog!!.dismiss()
                    }

                    override fun onResponse(call: Call<PlacesPOJO>?, response: Response<PlacesPOJO>?) {
                        var pojo =    response!!.body()
                        var list:List<ResultsItem>? = pojo!!.results
                        lview!!.adapter = MyAdapter(this@MainActivity,list)
                        pDialog!!.dismiss()
                    }

                })
            }

        })
    }
}
