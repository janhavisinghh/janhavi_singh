package com.truecaller.janhavi_singh

import com.spotify.mobius.test.NextMatchers.hasEffects
import com.spotify.mobius.test.NextMatchers.hasNoModel
import com.spotify.mobius.test.UpdateSpec
import com.spotify.mobius.test.UpdateSpec.assertThatNext
import org.junit.Test

class TrueCallerUpdateTest {
    @Test
    fun `when truecaller url button is clicked, then hit url`() {
        val updateSpec = UpdateSpec<TrueCallerModel, TrueCallerEvent, TrueCallerEffect>(TrueCallerUpdate())

        updateSpec.given(TrueCallerModel.INIT)
            .whenEvent(TrueCallerUrlButtonClicked as TrueCallerEvent)
            .then(
                assertThatNext(
                    hasNoModel(),
                    hasEffects(HitTrueCallerUrl as TrueCallerEffect)
                )
            )
    }
}
