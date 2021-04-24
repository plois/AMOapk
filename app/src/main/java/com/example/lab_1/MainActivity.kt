package com.example.lab_1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_1.fragments.Fragment1
import com.example.lab_1.fragments.Fragment2
import com.example.lab_1.fragments.Fragment3
import com.example.lab_1.fragments.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTabs()
    }

    @SuppressLint("SetTextI18n")
    fun calc1(view:View) {
        val txt1: EditText? = findViewById(R.id.editText) as? EditText
        val txt2: EditText? = findViewById(R.id.editText2) as? EditText
        val txt3: EditText? = findViewById(R.id.editText3) as? EditText
        val txt4: EditText? = findViewById(R.id.editText4) as? EditText
        val txt5: TextView? = findViewById(R.id.textView5) as? TextView

        val aStr: String = txt1?.text.toString()
        val bStr: String = txt2?.text.toString()
        val cStr: String = txt3?.text.toString()
        val dStr: String = txt4?.text.toString()

        try {

            val a: Double = aStr.toDouble()
            val b: Double = bStr.toDouble()
            val c: Double = cStr.toDouble()
            val d: Double = dStr.toDouble()

            val y: Double = round((((sqrt(a)+b.pow(2))/(sqrt(b)-a.pow(2)))+ sqrt((a*b)/(c*d))) * 1000.0) / 1000.0

            if (y.isNaN() || y.isInfinite()){txt5?.text = "Помилка!\nДілення на 0"} else{txt5?.text =
                "Y1 = $y" }

        } catch (e : NumberFormatException){txt5?.text = "Дані введені невірно\nабо не  введені\nвзагалі"} }

    @SuppressLint("SetTextI18n")
    fun calc2(view:View) {
        val txt1: EditText? = findViewById(R.id.editText12) as? EditText
        val txt2: EditText? = findViewById(R.id.editText22) as? EditText
        val txtk: EditText? = findViewById(R.id.editTextk) as? EditText
        val txt5: TextView? = findViewById(R.id.textView52) as? TextView

        try{

        val aStr: String = txt1?.text.toString()
        val cStr: String = txt2?.text.toString()
        val kStr: String = txtk?.text.toString()

        val a: Double = aStr.toDouble()
        val c: Double = cStr.toDouble()
        val k: Double = kStr.toDouble()
        if (k<10){txt5?.text ="y = %10.4f".format(round(((a+c).pow(4)+(a-c).pow(2)) *1000.0)/1000.0)}
        else{txt5?.text ="y = %10.4f".format(round(((a-c).pow(3)+(a+c).pow(2)) *1000.0)/1000.0)} }
        catch (e : NumberFormatException){txt5?.text = "Дані введені невірно\nабо не  введені\nвзагалі"}}

    @SuppressLint("SetTextI18n")
    fun calc3(view:View) {
        val txt1: EditText? = findViewById(R.id.editText13) as? EditText
        val txt2: EditText? = findViewById(R.id.editText23) as? EditText
        val txt3: EditText? = findViewById(R.id.editText33) as? EditText
        val txt5: TextView? = findViewById(R.id.textView53) as? TextView

        val aStr: String = txt1?.text.toString()
        val bStr: String = txt2?.text.toString()
        val pStr: String = txt3?.text.toString()

        try{

        val a: Double = aStr.toDouble()
        val b: Double = bStr.toDouble()
        val p: Int = pStr.toInt()

        var f = 0.0

        for(i in 1..p){for (j in 1..p){for (k in 1..p){f += i*(i*j*(i*j*k* sqrt(a+b)))}}}
        txt5?.text = "f = %10.4f".format(round(f*1000.0)/1000.0) }
        catch (e : NumberFormatException){txt5?.text = "Дані введено невірно\nабо не  введено\nвзагалі"}}

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Fragment1(), "Алгоритм 1" )
        adapter.addFragment(Fragment2(),"Алгоритм 2")
        adapter.addFragment(Fragment3(),"Алгоритм 3")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_filter_1_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_filter_2_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_filter_3_24)
    }
}