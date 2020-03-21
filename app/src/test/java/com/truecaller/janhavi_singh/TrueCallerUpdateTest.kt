package com.truecaller.janhavi_singh

import com.spotify.mobius.test.NextMatchers.*
import com.spotify.mobius.test.UpdateSpec
import com.spotify.mobius.test.UpdateSpec.assertThatNext
import org.junit.Test

class TrueCallerUpdateTest {
    private val updateSpec = UpdateSpec<TrueCallerModel, TrueCallerEvent, TrueCallerEffect>(TrueCallerUpdate())
    private val init = TrueCallerModel.INIT

    @Test
    fun `when truecaller url button is clicked, then hit url`() {
        updateSpec.given(init)
            .whenEvent(TrueCallerUrlButtonClicked as TrueCallerEvent)
            .then(
                assertThatNext(
                    hasNoModel(),
                    hasEffects(HitTrueCallerUrl as TrueCallerEffect)
                )
            )
    }

    @Test
    fun `when truecaller url hit failed, then show error`() {
        updateSpec.given(init.hitUrlFailed())
            .whenEvent(HitUrlFailed as TrueCallerEvent)
            .then(
                assertThatNext(
                    hasNoModel(),
                    hasEffects(ShowHitUrlFailedErrorMessage as TrueCallerEffect)
                )
            )
    }

    @Test
    fun `when truecaller url hit succeeds, then save response in the model`() {
        val urlResponse = "<p> Hello this is a test string </p>"
        updateSpec.given(init)
            .whenEvent(HitUrlSuccessful(urlResponse) as TrueCallerEvent)
            .then(
                assertThatNext(
                    hasModel(init.hitUrlSuccessful(urlResponse)),
                    hasNoEffects()
                )
            )
    }
}
