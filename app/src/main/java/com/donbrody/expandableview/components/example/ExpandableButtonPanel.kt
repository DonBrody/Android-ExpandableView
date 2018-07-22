package com.donbrody.expandableview.components.example

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import com.donbrody.expandableview.R
import com.donbrody.expandableview.components.expandableView.ExpandableView

/**
 * Created by Don.Brody on 7/22/18.
 */
class ExpandableButtonPanel(context: Context, attr: AttributeSet): ExpandableView(context, attr) {

    init {
        setPadding(0, 0, 0, 500.toDp)
    }

    override fun configureSelf() {
        val wrapper = createButtonWrapper()
        wrapper.addView(createButton("Button One"))
        wrapper.addView(createButton("Button Two"))
        wrapper.addView(createButton("Button Three"))
        addView(wrapper)
    }

    private fun createButtonWrapper(): LinearLayout {
        val wrapper = LinearLayout(context)
        val lp = RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        )
        wrapper.layoutParams = lp
        wrapper.orientation = LinearLayout.HORIZONTAL
        wrapper.gravity = Gravity.CENTER
        return wrapper
    }

    private fun createButton(text: String): Button {
        val button = Button(context)
        val lp = LinearLayout.LayoutParams(
                (measuredWidth * 0.20f).toInt(),
                LayoutParams.WRAP_CONTENT
        )
        lp.marginStart = (measuredWidth * 0.05f).toInt()
        lp.marginEnd = (measuredWidth * 0.05f).toInt()
        button.layoutParams = lp
        button.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
        button.setTextColor(Color.WHITE)
        button.text = text

        button.setOnClickListener({
            Toast.makeText(context, "$text clicked", Toast.LENGTH_LONG).show()
        })

        return button
    }
}