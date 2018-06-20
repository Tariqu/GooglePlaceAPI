package com.obaap.googleplaceapi

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Icon
import android.graphics.drawable.Icon.createWithFilePath
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import retrofit2.http.Url
import java.net.URI
import java.net.URL
import java.net.URLConnection
import android.graphics.BitmapFactory
import android.graphics.drawable.Icon.createWithAdaptiveBitmap


class MyAdapter:BaseAdapter{
    var context:Context?=null
    var list:List<ResultsItem>?=null
    var inflater:LayoutInflater?=null
    constructor(mainActivity: MainActivity,list: List<ResultsItem>?){
    context=mainActivity
        this.list=list
        inflater= LayoutInflater.from(context!!)
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var v=inflater!!.inflate(R.layout.customlayout,null)
        var tview1=v.findViewById<TextView>(R.id.tview1)
        var tview2 =v.findViewById<TextView>(R.id.tview2)
        tview1.text=list!!.get(p0).name
        tview2.text=list!!.get(p0).vicinity
        /*var iview = v.findViewById<ImageView>(R.id.iview)
        var im=list!!.get(p0).icon
        var i=URL(im)
        val bmp = BitmapFactory.decodeStream(i.openConnection().getInputStream())
        iview.setImageBitmap(bmp)*/


        return v
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return this.list!!.size
    }

}