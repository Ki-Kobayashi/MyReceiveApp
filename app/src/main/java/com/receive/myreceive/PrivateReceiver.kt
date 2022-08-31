package com.receive.myreceive

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.os.bundleOf
import com.receive.myreceive.commom.consts.Constants

/**
 * Created by K.Kobayashi on 2022/08/29.
 */
class PrivateReceiver : BroadcastReceiver() {
    override fun onReceive(ctx: Context, intent: Intent) {
        val dataStr = intent.getStringExtra(Constants.PRIVATE_BC_MSG)
        Toast.makeText(
            ctx,
            String.format(ctx.getString(R.string.private_receive_msg), dataStr),
            Toast.LENGTH_SHORT
        ).show()

//        // 以下でブロードキャストを送信した場合に、返信・ブロードキャスト停止として下の処理が必要
//        // sendOrderedBroadcast(intent, null, mResultReceiver, null, 0, null, null)
//        setResult(
//            Activity.RESULT_OK,
//            "setResult_data",
//            bundleOf(Constants.PRIVATE_BC_MSG to "bundleOf__かえってきた")
//        )
//        abortBroadcast()
    }
}