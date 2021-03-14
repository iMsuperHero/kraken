package com.cornerjob.marvelheroes.presentation.heroeslist

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.cornerjob.marvelheroes.R
import com.cornerjob.marvelheroes.presentation.util.Navigator
import kotlinx.android.synthetic.main.item_hero.view.*
import com.cornerjob.marvelheroes.domain.model.Result

class MarvelMainAdapter(private val heroes: ArrayList<Result>
) : RecyclerView.Adapter<MarvelMainAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Result) {
            itemView.heroTitle.text = data.name
            Glide.with(itemView.context)
                    .asBitmap()
                    .load(data.thumbnail.path + "." + data.thumbnail.extension)
                    .listener(object : RequestListener<Bitmap> {
                        override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            resource?.let { loadColorsFromBitmap(it) }
                            return false
                        }

                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?, isFirstResource: Boolean): Boolean {
                            return false
                        }
                    })
                    .into(itemView.heroImage)
            itemView.heroTitle.setOnClickListener {
                Navigator.goToHeroDetail((it.context as Activity), data, itemView.heroImage)
            }
            itemView.setOnLongClickListener {
                shareIntent(itemView.context, data.name, data.description)
                true
            }
        }

        fun shareIntent(context: Context, name: String, description: String) {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, name + description);
            context.startActivity(Intent.createChooser(shareIntent, context.resources.getString(R.string.action_share)))
        }

        fun loadColorsFromBitmap(bitmap: Bitmap) {
            with(itemView) {
                Palette.from(bitmap).generate { palette ->
                    val vibrant = palette?.vibrantSwatch
                    vibrant?.let {
                        heroTitle.setBackgroundColor(vibrant.rgb)
                        heroTitle.setTextColor(vibrant.bodyTextColor)
                    }
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DataViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.item_hero, parent,
                            false
                    )
            )

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
            holder.bind(heroes[position])

    fun addData(list: List<Result>) {
        heroes.addAll(list)
    }
}