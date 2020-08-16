package com.kim344.rxsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observer : Observer<Int> = object : Observer<Int>{
            override fun onComplete() {
                println("onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe() - $d")
            }

            override fun onNext(item: Int) {
                println("onNext() - $item")
            }

            override fun onError(e: Throwable) {
                println("onNext() - ${e.message}")
            }
        }

        Observable.range(1,3).subscribe(observer)
    }
}