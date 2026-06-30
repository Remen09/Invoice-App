package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_dashboard1)

            // Setup Navigation Buttons
            findViewById<LinearLayout>(R.id.btnCreateInvoice)?.setOnClickListener {
                startActivity(Intent(this, CreateInvoiceActivity::class.java))
            }

            findViewById<LinearLayout>(R.id.btnViewInvoices)?.setOnClickListener {
                startActivity(Intent(this, InvoicesActivity::class.java))
            }

            findViewById<LinearLayout>(R.id.btnViewClients)?.setOnClickListener {
                startActivity(Intent(this, OrdersActivity::class.java))
            }

            findViewById<TextView>(R.id.tvViewAll)?.setOnClickListener {
                startActivity(Intent(this, InvoicesActivity::class.java))
            }

            // Setup Bottom Navigation
            val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
            bottomNav?.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_invoices -> {
                        startActivity(Intent(this, InvoicesActivity::class.java))
                        true
                    }
                    R.id.nav_orders -> {
                        startActivity(Intent(this, OrdersActivity::class.java))
                        true
                    }
                    else -> true
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // If the complex layout fails, show a simple one so it doesn't "disconnect"
            val tv = TextView(this)
            tv.text = "Error loading Dashboard. Check Logcat."
            setContentView(tv)
        }
    }
}
