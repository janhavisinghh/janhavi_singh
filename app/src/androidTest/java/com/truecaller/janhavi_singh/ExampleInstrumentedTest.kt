@file:Suppress("DEPRECATION")

package com.truecaller.janhavi_singh

import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = getTargetContext()
        assertEquals("com.truecaller.janhavi_singh", appContext.packageName)
    }
}
