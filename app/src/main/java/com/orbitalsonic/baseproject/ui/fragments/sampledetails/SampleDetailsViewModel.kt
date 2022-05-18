package com.orbitalsonic.baseproject.ui.fragments.sampledetails

import androidx.lifecycle.ViewModel

class SampleDetailsViewModel : ViewModel() {
//    private val handler = CoroutineExceptionHandler { _, exception ->
//        exception.recordException("HomeListTag")
//        ALog.e("testingList", "$exception")
//    }
//
//    var homeItemList:ArrayList<HomeItem> = ArrayList()
//
//    fun getHomeItemList(callback: () -> Unit){
//        if (homeItemList.isEmpty()){
//            GlobalScope.launch(Dispatchers.Main + handler) {
//                async(Dispatchers.IO + handler) {
//                    homeItemList = DataProvider.homeItemList
//                }.await()
//                callback.invoke()
//            }
//        }else{
//            callback.invoke()
//        }
//
//    }
//
//    fun cleanList(){
//        homeItemList.clear()
//        homeItemList = ArrayList()
//    }
}