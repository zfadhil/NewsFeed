package com.zfadhil.muslimmedia

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.squareup.picasso.Picasso
import com.zfadhil.muslimmedia.data.ArticlesItem
import com.zfadhil.muslimmedia.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra(EXTRA_DATA, ArticlesItem::class.java)

//        binding.apply {
//            tvDetailTitle.text = data?.title
//            tvDetailAuthor.text = data?.author
//            tvDetailDate.text = data?.publishedAt
//            Picasso.get().load(data?.urlToImage).into(imgDetail)
//        }
        setWebView(data)
    }

    private fun setWebView(data: ArticlesItem?) {
        var loadingFinished = true
        var redirect = false

        binding.wvDetail.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (!loadingFinished) {
                    redirect = true
                }
                loadingFinished = false
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                loadingFinished = true
                binding.loadingView.root.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                if (!redirect) {
                    binding.loadingView.root.visibility = View.GONE
                } else {
                    redirect = false
                }
            }
        }
        data?.url?.let { binding.wvDetail.loadUrl(it) }
    }

    companion object {
        const val EXTRA_DATA = "data"
    }
}