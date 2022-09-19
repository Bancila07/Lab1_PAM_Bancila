package com.example.lab1_pam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.lab1_pam.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener { getResult() }
    }
    private fun calculateOccurance(txt: String, ch: Char) : Int
    {
        val strArray = txt.split(" ".toRegex()).toTypedArray()
        val matcher = Pattern.compile(ch.toString()).matcher(txt)
        var word = 0
        for (a in strArray) {
            if (a != "" && matcher.find()) {
                word++
            }
        }
        return word
    }
    private fun getResult() {
        val validText = binding.textInputLayout.helperText == null
        if (validText)
            showResult()
    }
    private fun showResult()
    {
        val txt = binding.txt1.text.toString()
        val message = "Sunt: " + calculateOccurance(txt, 'a') + " litere de 'a'"
        AlertDialog.Builder(this)
            .setTitle("Rezultatul")
            .setMessage(message)
            .show()
    }

}