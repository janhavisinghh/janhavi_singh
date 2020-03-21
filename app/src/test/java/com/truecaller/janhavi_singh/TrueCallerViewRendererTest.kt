package com.truecaller.janhavi_singh

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import org.junit.Test

class TrueCallerViewRendererTest {
    private val initModel = TrueCallerModel.INIT
    private val trueCallerView = mock<TrueCallerView>()
    private val viewRenderer = TrueCallerViewRenderer(trueCallerView)
    private val urlResponse = "This is for testing"

    @Test
    fun `it should render truecaller ui tasks`() {
        viewRenderer.render(initModel.hitUrlSuccessful(urlResponse))

        verify(trueCallerView).displayEveryTenthCharRequest(urlResponse)
        verify(trueCallerView).displayTenthCharRequest(urlResponse)
        verify(trueCallerView).displayWordCounterRequest(urlResponse)

        verifyZeroInteractions(trueCallerView)
    }
}