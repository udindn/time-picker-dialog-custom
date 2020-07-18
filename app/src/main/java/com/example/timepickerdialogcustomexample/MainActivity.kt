package com.example.timepickerdialogcustomexample

import android.graphics.*
import android.graphics.drawable.*
import android.os.*
import android.view.*
import androidx.appcompat.app.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.time_picker_dialog.*
import kotlinx.android.synthetic.main.time_picker_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_change_time.setOnClickListener {
            showComingSoonDialog()
        }
    }

    private fun showComingSoonDialog() {
        val mDialogView = LayoutInflater.from(this)
            .inflate(R.layout.time_picker_dialog, findViewById(android.R.id.content), false)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        val mAlertDialog = mBuilder.show()
        mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mDialogView.time_picker.setIs24HourView(true)
        mDialogView.tv_cancel.setOnClickListener {
            mAlertDialog.dismiss()
        }
        mDialogView.tv_ok.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                tv_set_time.text = String.format("%02d:%02d", mAlertDialog.time_picker.hour, mAlertDialog.time_picker.minute)
            }
            mAlertDialog.dismiss()
        }
    }
}
