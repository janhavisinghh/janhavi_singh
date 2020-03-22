package com.truecaller.janhavi_singh

import com.spotify.mobius.Connectable
import com.spotify.mobius.Connection
import com.spotify.mobius.functions.Consumer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


class TrueCallerEffectHandler(
    private val viewActions: TrueCallerViewActions
) :
    Connectable<TrueCallerEffect, TrueCallerEvent> {
    override fun connect(output: Consumer<TrueCallerEvent>): Connection<TrueCallerEffect> {
        return object : Connection<TrueCallerEffect> {
            override fun accept(value: TrueCallerEffect) {
                when (value) {
                    is ShowHitUrlFailedErrorMessage ->
                        viewActions.showHitUrlFailedErrorMessage()
                    is HitTrueCallerUrl -> {
                        hitTrueCallerUrl(output)
                    }
                }
            }

            override fun dispose() {
            }
        }
    }

    private fun hitTrueCallerUrl(output: Consumer<TrueCallerEvent>) {
        val trueCallerUrl = "https://truecaller.blog/"

        //Retrofit Client Instance
        val retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(trueCallerUrl)
            .build()

        //Executing Retrofit Request
        val scalarService = retrofit.create(GetDataService::class.java)
        val stringCall = scalarService.getStringResponse()

        stringCall.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val responseString = response.body()
                    output.accept(HitUrlSuccessful(responseString!!))
                }

            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                output.accept(HitUrlFailed)
            }
        })
    }
}
