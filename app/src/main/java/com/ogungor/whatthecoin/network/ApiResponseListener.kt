package com.ogungor.whatthecoin.network

interface ApiResponseListener<T> {

    fun onSuccess(model : T)

    fun onFail()

}