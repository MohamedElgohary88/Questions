package com.example.questions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class Second : AppCompatActivity() {
    var val_ques: Array<String>? = null
    var val_ans:Array<String>? = null
    var index:Int? = null
    var default_text = "Press A Button For Answer"
    var TtoS:TextToSpeech? = null
    var res:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        TtoS = TextToSpeech(this, object : TextToSpeech.OnInitListener {
            override fun onInit(p0: Int) {
               res = TtoS!!.setLanguage(Locale.ENGLISH)

            }
        }
    )

       val_ans = resources.getStringArray(R.array.ans)
       val_ques = resources.getStringArray(R.array.ques)
       index = 0

      tv_question.text = "${val_ques!![index!!]}"
      tv_answer.text = default_text

      tv_xx.text = "${index!!+1}"
      tv_yy.text = "${val_ques!!.size }"


    }
    fun showAction(v:View?){
        when(v?.id){
            R.id.btn_left  -> {
               try {
                   tv_answer.text = default_text
                   index = index!! - 1
                   tv_question.text = "${val_ques!![index!!]}"
                   tv_xx.text = (index!!+1 ).toString()
               }catch (ex:Exception){
                   index =val_ques!!.size - 1
                   tv_question.text = "${val_ques!![index!!]}"
                   tv_xx.text = (index!!+1 ).toString()
               }
            }
            R.id.btn_answer -> {
                tv_answer.text = "${val_ans!![index!!]}"
            }
            R.id.btn_right  -> {
                try {
                    tv_answer.text = default_text
                    index = index!! +1
                    tv_question.text = "${ val_ques!! [index!!] }"
                    tv_xx.text = (index!! + 1 ).toString()
                }catch (ex:Exception){
                    index = 10 - val_ques!!.size
                    tv_question.text = "${val_ques!![index!!]}"
                    tv_xx.text = (index!!+1 ).toString()
                }
            }
            R.id.btn_voice -> {
                if(res==TextToSpeech.LANG_NOT_SUPPORTED || res ==TextToSpeech.LANG_MISSING_DATA){
                    Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
                }else{
                    TtoS!!.speak(tv_question.text,TextToSpeech.QUEUE_FLUSH,null,null)
                }
            }
        }
    }
}