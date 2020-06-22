package com.kim344.rxsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable


class MainActivity : AppCompatActivity() {

    private val api by lazy { provideMyApi() }

    private val disposable = CompositeDisposable()

    private val TAG = "RxSample"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disposable.add(api.getAnswers().subscribe {
            Log.e(TAG,it.has_more.toString())
            Log.e(TAG,it.quota_max.toString())
            Log.e(TAG,it.quota_remaining.toString())
        })
    }
}
