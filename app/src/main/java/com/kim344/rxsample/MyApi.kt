package com.kim344.rxsample

import io.reactivex.Observable
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    /**
     *  POST -> POST 통신할 주소를 입력합니다.

     *  Field -> POST 통신을 위한 파라미터를 입력합니다.

     *

     *  Return 값은 Observable<MyModel> 형태로 되어 있지만

     *  Model이 없는 경우 Observable<Any> 로 적으시면 됩니다.
     */
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    fun getAnswers(): Observable<MyModel>
}