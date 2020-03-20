package com.truecaller.janhavi_singh

import com.spotify.mobius.Connectable
import com.spotify.mobius.Connection
import com.spotify.mobius.functions.Consumer

class TrueCallerEffectHandler(private val viewActions: TrueCallerViewActions) :
    Connectable<TrueCallerEffect, TrueCallerEvent> {
    override fun connect(output: Consumer<TrueCallerEvent>): Connection<TrueCallerEffect> {
        return object : Connection<TrueCallerEffect> {
            override fun accept(value: TrueCallerEffect) {
                when (value) {
                    is ShowHitUrlFailedErrorMessage ->
                        viewActions.showHitUrlFailedErrorMessage()
                }
            }

            override fun dispose() {
            }
        }
    }
}
