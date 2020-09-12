package com.example.ecommerce

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.e_product_row.view.*

@Suppress("DEPRECATION")
class EProductAdapter(var context: Context,
                      var arrayList:ArrayList<EProduct>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        val productView = LayoutInflater.from(context).inflate(R.layout.e_product_row,parent,false)
        return ProductViewHolder(productView)

    }

    override fun getItemCount(): Int{
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    {
        (holder as ProductViewHolder).initializeRowUIComponents(arrayList.get(position).id,
            arrayList.get(position).name,arrayList.get(position).price,
            arrayList.get(position).brand,arrayList.get(position).picture)
    }


    inner class ProductViewHolder(pView: View):RecyclerView.
    ViewHolder(pView)
    {
        fun initializeRowUIComponents(id:Int,name:String,price:Int,brand:String,picName:String){
            itemView.txtId.text= id.toString()
            itemView.txtName.text=name
            itemView.txtBrand.text=brand
            itemView.txtPrice.text=price.toString()

            val picUrl= "http://192.168.43.182/images/"
            Picasso.get().load(picUrl+ picName).into(itemView.imgProduct)

            itemView.imgAdd.setOnClickListener {

                Person.addToCartProductID = id

                var amountF = AmountFragment()
                var fragmentManager = (itemView.context as Activity).fragmentManager
                amountF.show(fragmentManager,"TAG")
            }
        }
    }
}