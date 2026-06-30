package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityInvoiceBinding

class InvoicesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInvoiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInvoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back button
        binding.ivBack.setOnClickListener {
            finish()
        }

        // Quick Action Buttons at the bottom
        binding.btnCreateInvoice.setOnClickListener {
            startActivity(Intent(this, CreateInvoiceActivity::class.java))
        }

        binding.btnViewInvoices.setOnClickListener {
            // Already here, maybe scroll to top
        }

        binding.btnViewClients.setOnClickListener {
            startActivity(Intent(this, OrdersActivity::class.java))
        }

        // Bottom Navigation Bar
        binding.bottomNavigation.selectedItemId = R.id.nav_invoices
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    true
                }
                R.id.nav_orders -> {
                    startActivity(Intent(this, OrdersActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}
