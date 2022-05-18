package com.orbitalsonic.baseproject.helpers.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
//import com.hstechapps.livesatellite.gps.navigation.earthmap.R
//import com.hstechapps.livesatellite.gps.navigation.earthmap.databinding.ItemHomeBinding
//import com.orbitalsonic.baseproject.helpers.datamodel.HomeItem
//import com.orbitalsonic.baseproject.helpers.interfaces.OnItemClickListener
//import com.orbitalsonic.baseproject.helpers.listeners.OnClickListeners.setSafeOnClickListener
//
//class AdapterHome :
//    ListAdapter<HomeItem, AdapterHome.HomeViewHolder>(DATA_COMPARATOR) {
//
//    private var mListener: OnItemClickListener? = null
//
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        mListener = listener
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding: ItemHomeBinding = DataBindingUtil.inflate(
//            inflater,
//            R.layout.item_home, parent, false
//        )
//        return HomeViewHolder(binding, mListener!!)
//
//    }
//
//    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
//        val currentItem = getItem(position)
//        holder.bind(currentItem)
//    }
//
//
//    class HomeViewHolder(binding: ItemHomeBinding, listener: OnItemClickListener) :
//        RecyclerView.ViewHolder(binding.root) {
//        private val mBinding = binding
//
//        init {
//            mBinding.item.setSafeOnClickListener {
//                val mPosition = adapterPosition
//                listener.onItemClick(mPosition)
//            }
//
//        }
//
//        fun bind(mCurrentItem: HomeItem) {
//            Glide.with(mBinding.root.context)
//                .load(mCurrentItem.itemImage)
//                .placeholder(R.drawable.bg_glide_white)
//                .centerCrop()
//                .transition(DrawableTransitionOptions.withCrossFade(200))
//                .into(mBinding.itemImage)
//            mBinding.itemName.text = mCurrentItem.itemName
//        }
//
//
//    }
//
//
//    companion object {
//        private val DATA_COMPARATOR = object : DiffUtil.ItemCallback<HomeItem>() {
//            override fun areItemsTheSame(
//                oldItem: HomeItem,
//                newItem: HomeItem
//            ): Boolean {
//                return oldItem == newItem
//            }
//
//            override fun areContentsTheSame(
//                oldItem: HomeItem,
//                newItem: HomeItem
//            ): Boolean {
//                return oldItem.itemName == newItem.itemName
//            }
//        }
//    }
//
//}