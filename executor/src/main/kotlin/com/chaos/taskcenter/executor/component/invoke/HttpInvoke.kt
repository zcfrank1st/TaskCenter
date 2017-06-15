package com.chaos.taskcenter.executor.component.invoke

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import okhttp3.*

/**
 * Created by zcfrank1st on 14/06/2017.
 */
val component = Kodein {
    bind<OkHttpClient>() with singleton { OkHttpClient.Builder().build() }
}

class HttpInvoke(val task: Task) : Invoke {
    companion object {
        private const val APPLICATION_JSON = "application/json;charset=utf-8"
        private val okhttpClient: OkHttpClient = component.instance()
    }


    override fun invoke(): InvokeStatus {
        val response: Response = okhttpClient.newCall(request()).execute()

        response.use { response ->
            // TODO 返回值判断？？？
            if (response.isSuccessful) return InvokeStatus.SUCCESS else return InvokeStatus.FAILED
        }
    }

    private fun request(): Request {
        val requestBuilder = Request.Builder()

        val requestComponentList = task.taskContent.split(":")
        val requestMethod = requestComponentList[0]
        val requestUrl = requestComponentList[1]

        return when (requestMethod) {
                    "GET"    ->
                        requestBuilder
                                .get()
                                .url(requestUrl)
                                .build()
                    "POST"   ->
                        requestBuilder
                                .addHeader("Content-type", APPLICATION_JSON)
                                .post(RequestBody.create(MediaType.parse(APPLICATION_JSON), task.param))
                                .url(requestUrl)
                                .build()
                    "DELETE" ->
                        requestBuilder
                                .delete()
                                .url(requestUrl)
                                .build()
                    "PUT"    ->
                        requestBuilder
                                .addHeader("Content-type", APPLICATION_JSON)
                                .put(RequestBody.create(MediaType.parse(APPLICATION_JSON), task.param))
                                .url(requestUrl)
                                .build()
                    else     -> throw RuntimeException("not support http method!")
                }
    }
}