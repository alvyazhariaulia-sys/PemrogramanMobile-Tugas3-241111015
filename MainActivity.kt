package com.utama.tugasmandiri3

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView
    private lateinit var tvUsername: TextView
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvWelcome = findViewById(R.id.tvWelcome)
        tvUsername = findViewById(R.id.tvUsername)
        bottomNav = findViewById(R.id.bottom_navigation)

        // Ambil data username dari Login
        val username = intent.getStringExtra("username")
        tvWelcome.text = "Selamat Datang"
        tvUsername.text = username ?: "User"

        // Logika Klik Menu
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> {
                    Toast.makeText(this, "Halaman Profil", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_info -> {
                    Toast.makeText(this, "Halaman Info", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_settings -> {
                    Toast.makeText(this, "Halaman Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_logout -> {
                    // Logout balik ke LoginActivity
                    val intentLogout = Intent(this, LoginActivity::class.java)
                    startActivity(intentLogout)
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}
