package com.arkonq.pixelweather

import com.arkonq.pixelweather.utils.IconUrlUtils

import org.junit.Test

import org.junit.Assert.assertEquals


class IconUrlUtilsTest {

    @Test
    fun getIconUrlTest() {
        val icon = "02d"
        val expectedResult = "http://openweathermap.org/img/w/02d.png"

        assertEquals(expectedResult, IconUrlUtils.getIconUrl(icon))
    }
}
