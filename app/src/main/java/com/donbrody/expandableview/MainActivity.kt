package com.donbrody.expandableview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.donbrody.expandableview.components.expandableView.ExpandableState
import com.donbrody.expandableview.components.expandableView.ExpandableStateListener
import com.donbrody.expandableview.components.expandableView.ExpandableView

/**
 * Created by Don.Brody on 7/22/18.
 */
class MainActivity: AppCompatActivity() {
    private lateinit var expandableButtonPanel: ExpandableView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionButton: Button = findViewById(R.id.actionButton)
        expandableButtonPanel = findViewById(R.id.expandableButtonPanel)

        actionButton.setOnClickListener({
            expandableButtonPanel.translateLayout()
        })

        expandableButtonPanel.registerListener(object: ExpandableStateListener {
            override fun onStateChange(state: ExpandableState) {
                when(state) {
                    ExpandableState.EXPANDING -> {
                        actionButton.isEnabled = false
                    }
                    ExpandableState.EXPANDED -> {
                        actionButton.isEnabled = true
                        setButtonText(actionButton)
                    }
                    ExpandableState.COLLAPSING -> {
                        actionButton.isEnabled = false
                    }
                    ExpandableState.COLLAPSED -> {
                        actionButton.isEnabled = true
                        setButtonText(actionButton)
                    }
                }
            }
        })

        setButtonText(actionButton)
    }

    private fun setButtonText(button: Button) {
        button.text = if (expandableButtonPanel.isExpanded) {
            "Collapse ExpandableButtonPanel"
        } else {
            "Expand ExpandableButtonPanel"
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}