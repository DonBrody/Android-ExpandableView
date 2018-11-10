package com.donbrody.expandableview.components.utilities

import android.content.Context
import android.util.TypedValue

/**
 * Created by Don.Brody on 11/10/18.
 */
class ComponentUtils {
    companion object {
        fun dpToPx(context: Context, dp: Int): Int {
            val px = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    dp.toFloat(),
                    context.resources.displayMetrics)

            val density = context.resources.displayMetrics.density
            return (px / density).toInt()
        }

        fun pxToDp(context: Context, px: Int): Int {
            val dp = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_PX,
                    px.toFloat(),
                    context.resources.displayMetrics)

            val density = context.resources.displayMetrics.density
            return (dp * density).toInt()
        }
    }
}