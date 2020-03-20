package com.truecaller.janhavi_singh

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.spotify.mobius.Connection
import com.spotify.mobius.test.RecordingConsumer
import org.junit.After
import org.junit.Before
import org.junit.Test

class TrueCallerEffectHandlerTest {
    private val viewActions = mock<TrueCallerViewActions>()
    private val effectHandler = TrueCallerEffectHandler(viewActions)
    private val consumer = RecordingConsumer<TrueCallerEvent>()
    private lateinit var connection: Connection<TrueCallerEffect>

    @Before
    fun setup() {
        connection = effectHandler.connect(consumer)
    }

    @After
    fun dispose() {
        connection.dispose()
    }

    @Test
    fun `when truecaller url hit is failed, then show error message`() {
        connection.accept(ShowHitUrlFailedErrorMessage)
        verify(viewActions).showHitUrlFailedErrorMessage()
    }
}