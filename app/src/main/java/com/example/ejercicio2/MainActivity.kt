package com.example.ejercicio2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombreEditText: EditText = findViewById(R.id.nombreEditText)
        val salarioBaseEditText: EditText = findViewById(R.id.salarioBaseEditText)
        val calcularButton: Button = findViewById(R.id.calcularButton)
        val salarioNetoTextView: TextView = findViewById(R.id.salarioNetoTextView)

        calcularButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val salarioBase = salarioBaseEditText.text.toString().toDouble()

            val salarioNeto = calcularSalarioNeto(salarioBase)

            val resultado = "El salario neto de $nombre es: $salarioNeto"

            salarioNetoTextView.text = resultado
        }
    }

    private fun calcularSalarioNeto(salarioBase: Double): Double {
        val ISSS = salarioBase * 0.03
        val AFP = salarioBase * 0.04
        val RENTA = salarioBase * 0.05

        return salarioBase - ISSS - AFP - RENTA
    }
}
