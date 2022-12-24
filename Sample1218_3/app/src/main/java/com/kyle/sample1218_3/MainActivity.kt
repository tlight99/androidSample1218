package com.kyle.sample1218_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    internal var result : Int? = null

    // 숫자 버튼 10개 배열화 시킨다.
    internal var numButtons = ArrayList<Button>(10)

    // 10개 버튼 id 값 배열
    internal var numBtnIDs = arrayOf(R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4,
        R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9)
    internal var i : Int = 0 // for문에 의해 값을 1씩 증가, 증가 한 값을 변수에 대입하여 사용한다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)

        textResult = findViewById(R.id.textResult)

        btnAdd.setOnTouchListener{ view, motionEvent -> // motionEvent는 cursor를 의미한다.
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = "결과 : " + result.toString()
            false
        }

        btnSub.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = "결과 : " + result.toString()
            false
        }

        btnMul.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = "결과 : " + result.toString()
            false
        }

        btnDiv.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            textResult.text = "결과 : " + result.toString()
            false
        }

        // 버튼을 대입한다.(for문)
        for (i in 0..9 step 1){
            numButtons.add(findViewById<Button>(numBtnIDs[i]))
        }

        // 버튼에 관한 이벤트 실행
        for(i in 0..numBtnIDs.size-1 step 1){ // numBtnIDs.size-1은 길이 값에 -1한 값이다.
            numButtons[i].setOnClickListener {
                if(edit1.isFocused == true){ // isFocused는 cursor가 깜빡거리는 위치이다.
                    num1 = edit1.text.toString() + numButtons[i].getText().toString()
                    edit1.setText(num1)
                }else if(edit2.isFocused == true){
                    num2 = edit2.text.toString() + numButtons[i].getText().toString()
                    edit2.setText(num2)
                }else{
                    Toast.makeText(applicationContext, "입력될 에디트텍스트 선택", Toast.LENGTH_SHORT)
                }
            }

        }

    }
}