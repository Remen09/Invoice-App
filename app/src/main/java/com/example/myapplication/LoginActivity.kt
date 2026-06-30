package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_login)
            
            val btnLogin = findViewById<Button>(R.id.btnLogin)

            btnLogin?.setOnClickListener {
                Toast.makeText(this, "Attempting to Login...", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(this, "Crash starting Dashboard: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Login Load Error: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}
