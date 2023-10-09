package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.foursquare.android.nativeoauth.FoursquareOAuth

class AuthActivity : AppCompatActivity() {
    private val clientId = "FMOHJVYS3P34HKNKKD5QGMM1L0QHTRL5TOJRXKRIZPVPUYHF"
    var REQUEST_CODE_FSQ_CONNECT = 1

    val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {result ->
        if (result.resultCode == Activity.RESULT_OK) {
            println(result.data)
        }
        println(Activity.RESULT_OK)
        println(result.resultCode)
    }

    private lateinit var connectButton: Button
    private val connector = Connector(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        connectButton = findViewById(R.id.connectionButton)




        connectButton.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                    connector.register()
//
//            }
            val connectIntent = FoursquareOAuth.getConnectIntent(this, clientId)
          //  startActivityForResult(connectIntent, REQUEST_CODE_FSQ_CONNECT)
            //launcher.
                 launcher.launch(connectIntent)

        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (requestCode) {
//            REQUEST_CODE_FSQ_CONNECT -> CoroutineScope(Dispatchers.IO).launch{
//                val codeResponse = FoursquareOAuth.getAuthCodeFromResult(resultCode, data)
//                println(codeResponse.code)
//            }
//        }
//        //val codeResponse = FoursquareOAuth.getAuthCodeFromResult(resultCode, data)
//      //  println(codeResponse.code)
//       // println(codeResponse.exception)
//        println(requestCode)
//        println(resultCode)
//        println(data?.data)
//    }
}