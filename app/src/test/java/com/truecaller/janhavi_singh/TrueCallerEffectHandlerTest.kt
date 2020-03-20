package com.truecaller.janhavi_singh

import com.spotify.mobius.Connection
import com.spotify.mobius.test.RecordingConsumer
import org.junit.After
import org.junit.Before

class TrueCallerEffectHandlerTest {
    private val effectHandler = TrueCallerEffectHandler()
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
}