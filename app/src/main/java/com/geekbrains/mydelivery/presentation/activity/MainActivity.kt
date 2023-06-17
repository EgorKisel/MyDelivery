package com.geekbrains.mydelivery.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.geekbrains.mydelivery.R
import com.geekbrains.mydelivery.databinding.ActivityMainBinding
import com.geekbrains.mydelivery.presentation.BasketFragment
import com.geekbrains.mydelivery.presentation.ContactsFragment
import com.geekbrains.mydelivery.presentation.menu.MenuFragment
import com.geekbrains.mydelivery.presentation.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?){
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_bottom_view_menu -> {
                    showFragment(MenuFragment.newInstance(), true)
                    true
                }
                R.id.action_bottom_profile -> {
                    showFragment(ProfileFragment.newInstance(), true)
                    true
                }
                R.id.contacts -> {
                    showFragment(ContactsFragment.newInstance(), true)
                    true
                }
                R.id.basket -> {
                    showFragment(BasketFragment.newInstance(), true)
                    true
                }
                else -> {
                    true
                }
            }
        }
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.action_bottom_view_menu
        }
        binding.bottomNavigationView.setOnItemReselectedListener {
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.bottomNavigationView.selectedItemId = R.id.action_bottom_view_menu
    }

    private fun showFragment(fragment: Fragment, stack: Boolean) {
        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.slide_in,
            R.anim.fade_out,
            R.anim.slide_in,
            R.anim.slide_out
        )
            .replace(R.id.fragment_container, fragment).apply {
                if (stack) addToBackStack("")
            }.commit()
    }

    override fun onBackPressed() {
        if (binding.bottomNavigationView.selectedItemId == R.id.action_bottom_view_menu) {
            finish()
        } else {
            binding.bottomNavigationView.selectedItemId = R.id.action_bottom_view_menu
        }
    }


}
