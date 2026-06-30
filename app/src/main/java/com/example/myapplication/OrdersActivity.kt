package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityOrdersBinding

class OrdersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrdersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back button
        binding.ivBack.setOnClickListener {
            finish()
        }

        // Bottom Navigation Bar
        binding.bottomNavigation.selectedItemId = R.id.nav_orders
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    true
                }
                R.id.nav_invoices -> {
                    startActivity(Intent(this, InvoicesActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}
