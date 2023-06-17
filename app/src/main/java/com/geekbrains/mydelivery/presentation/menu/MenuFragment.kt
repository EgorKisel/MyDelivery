package com.geekbrains.mydelivery.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.mydelivery.R
import com.geekbrains.mydelivery.common.makeToast
import com.geekbrains.mydelivery.databinding.FragmentMenuNewBinding
import com.geekbrains.mydelivery.presentation.menu.adapter.MyMenuAdapter
import kotlinx.android.synthetic.main.fragment_menu.recycler

class MenuFragment : Fragment() {

    private val adapter = MyMenuAdapter()
    private val viewModel: ViewModelMenu by lazy {
        ViewModelProvider(this)[ViewModelMenu::class.java]
    }

    private var _binding: FragmentMenuNewBinding? = null
    private val binding: FragmentMenuNewBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(context)
        recycler.setHasFixedSize(true)
        viewModel.getLiveData().observe(viewLifecycleOwner) { renderData(it) }
        viewModel.getAllMenu()
    }

    private fun renderData(appState: ViewModelMenu.AppState) {
        when (appState) {
            is ViewModelMenu.AppState.Error -> {
                makeToast(R.string.something_went_wrong)
            }

            ViewModelMenu.AppState.Loading -> {}
            is ViewModelMenu.AppState.Success -> {
                adapter.setData(appState.categoryDTO)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MenuFragment()
    }
}