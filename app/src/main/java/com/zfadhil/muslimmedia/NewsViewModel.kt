package com.zfadhil.muslimmedia

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.zfadhil.muslimmedia.data.NewsResponse
import com.zfadhil.muslimmedia.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class NewsViewModel: ViewModel() {
    // expose screen ui state
    private var _commonMuslimNews = MutableLiveData<NewsResponse>()
    val commonMuslimNews get() = _commonMuslimNews as LiveData<NewsResponse>

    private var _aboutQuranNews = MutableLiveData<NewsResponse>()
    val aboutQuranNews get() = _aboutQuranNews as LiveData<NewsResponse>

    private var _aljazeeraNews = MutableLiveData<NewsResponse>()
    val aljazeeraNews get() = _aljazeeraNews as LiveData<NewsResponse>

    private var _warningNews = MutableLiveData<NewsResponse>()
    val warningNews get() = _warningNews as LiveData<NewsResponse>

    private var _searchNews = MutableLiveData<NewsResponse>()
    val searchNews get() = _searchNews as LiveData<NewsResponse>

    // handle business logic
    fun getCommonMuslimNews() {
        ApiClient.getApiService().getCommonMuslimNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    Log.i("ViewModel", "onResponse: ${response.body()}")
                    _commonMuslimNews.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error with http status code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage)
            }
        })
    }

    fun getAboutQuranNews() {
        ApiClient.getApiService().getAboutQuranNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    Log.i("ViewModel", "onResponse: ${response.body()}")
                    _aboutQuranNews.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error with http status code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage)
            }
        })
    }

    fun getAlJazeeraNews() {
        ApiClient.getApiService().getAlJazeeraNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    Log.i("ViewModel", "onResponse: ${response.body()}")
                    _warningNews.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error with http status code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage)
            }
        })
    }

    fun getWarningForMuslimNews() {
        ApiClient.getApiService().getWarningForIslam().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    Log.i("ViewModel", "onResponse: ${response.body()}")
                    _aboutQuranNews.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error with http status code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage)
            }
        })
    }

    fun searchNews(query: String) {
        ApiClient.getApiService().searchNews(query).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful){
//                    _searchNews.value = response.body()
                    _searchNews.postValue(response.body())
                } else Log.e("NewsViewModel", "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("NewsViewModel", "onFailure: ${t.localizedMessage}")
            }
        })
    }
}