package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityCreateInvoiceBinding

class CreateInvoiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateInvoiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateInvoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.btnAddInvoice.setOnClickListener {
            Toast.makeText(this, "Invoice Added Successfully", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnSelectClient.setOnClickListener {
            Toast.makeText(this, "Select Client clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnSaveDraft.setOnClickListener {
            Toast.makeText(this, "Draft Saved", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Bottom Navigation in Create Invoice
        binding.btnDashboard.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.btnInvoicesNav.setOnClickListener {
            startActivity(Intent(this, InvoicesActivity::class.java))
            finish()
        }
    }
}
