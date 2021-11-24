package com.zapata.bm_jetpackcompose.data.models

import androidx.compose.ui.graphics.Color
import com.zapata.bm_jetpackcompose.ui.theme.HighPriorityColor
import com.zapata.bm_jetpackcompose.ui.theme.LowPriorityColor
import com.zapata.bm_jetpackcompose.ui.theme.MediumPriorityColor
import com.zapata.bm_jetpackcompose.ui.theme.NonePriorityColor

/* 
 * @author Alberto Zapata
 *  nov 2021
 */
enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}