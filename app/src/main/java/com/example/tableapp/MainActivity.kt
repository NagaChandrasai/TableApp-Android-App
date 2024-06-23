package com.example.tableapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var num:EditText?= null
    var butn:Button?=null
    var result:TextView?=null
    var start:EditText?=null
    var End:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num=findViewById(R.id.number)
        butn=findViewById(R.id.btn)
        result=findViewById(R.id.resulttxt)
        start=findViewById(R.id.strt)
        End=findViewById(R.id.end)

        butn?.setOnClickListener {

            var temp:String=num?.text.toString()
            var temp1:String=start?.text.toString()
            var temp2:String=End?.text.toString()

            if (temp.isEmpty() && temp1.isEmpty() && temp2.isEmpty())
            {
                num?.error="Enter all Requirements"
                start?.error="Enter all Requirements"
                End?.error="Enter all Requirements"
                Toast.makeText(this,"Enter All Requirements",Toast.LENGTH_LONG).show()
            }else if (temp.isEmpty()&& temp1.isEmpty() && temp2.isNotEmpty()){
                num?.error="Enter all Requirements"
                start?.error="Enter all Requirements"
                Toast.makeText(this,"Enter All Requirements",Toast.LENGTH_LONG).show()

            }else if (temp.isEmpty()&& temp1.isNotEmpty() && temp2.isEmpty()){
                num?.error="Enter all Requirements"
                End?.error="Enter all Requirements"
                Toast.makeText(this,"Enter All Requirements",Toast.LENGTH_LONG).show()

            }else if (temp.isEmpty()&& temp1.isNotEmpty() && temp2.isNotEmpty()){
                num?.error="Enter all Requirements"
                Toast.makeText(this,"Enter All Requirements",Toast.LENGTH_LONG).show()

            }else if (temp.isNotEmpty() && temp1.isEmpty() && temp2.isEmpty()) {
                start?.error="Enter all Requirements"
                End?.error="Enter all Requirements"
                Toast.makeText(this,"Enter All Requirements",Toast.LENGTH_LONG).show()
                var number:Int=temp.toInt()
                var strtnumber:Int=1
                var endnumber:Int=20

                multiplication(number,strtnumber,endnumber)
            }else if (temp.isNotEmpty() && temp1.isEmpty() && temp2.isNotEmpty()){
                start?.error="Enter all Requirements"
                Toast.makeText(this,"Enter All Requirements",Toast.LENGTH_LONG).show()
                var number:Int=temp.toInt()
                var strtnumber:Int=1
                var endnumber:Int=temp2.toInt()

                multiplication(number,strtnumber,endnumber)

            }else if (temp.isNotEmpty() && temp1.isNotEmpty() && temp2.isEmpty()){
                End?.error="Enter all Requirements"
                Toast.makeText(this,"Enter All Requirements",Toast.LENGTH_LONG).show()
                var number:Int=temp.toInt()
                var strtnumber:Int=temp1.toInt()
                var endnumber:Int=20

                multiplication(number,strtnumber,endnumber)
            } else{
                var number:Int=temp.toInt()
                var strtnumber:Int=temp1.toInt()
                var endnumber:Int=temp2.toInt()

                multiplication(number,strtnumber,endnumber)

            }
        }
    }

    fun multiplication(number:Int,strtnumber: Int,endnumber: Int){
        result?.text=""
        if (strtnumber>endnumber){
            End?.error="Enter number greater than $strtnumber"
            result?.append("Enter Start and End table values correctly8")
        }else{
            for ( i in strtnumber..endnumber){
                result?.append("$number x $i ="+(number*i)+"\n")
            }
        }

    }
}