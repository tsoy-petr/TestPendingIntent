package com.example.testpendingintent

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.testpendingintent.ui.main.SectionsPagerAdapter
import com.example.testpendingintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener { view ->

            val uploadWorkRequest =
                OneTimeWorkRequestBuilder<SyncWork>()
                    .build()

            WorkManager
                .getInstance(applicationContext)
                .beginUniqueWork(
                    "sync",
                    ExistingWorkPolicy.KEEP,
                    uploadWorkRequest
                )
                .enqueue()
        }


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

    }

    companion object{
        const val NOTIFICATION_ACTION = "hootor.open.fr1"
        const val NOTIFICATION_REQUEST_CODE = 201
        const val NOTIFICATION_CHANNEL = "test"
    }
}