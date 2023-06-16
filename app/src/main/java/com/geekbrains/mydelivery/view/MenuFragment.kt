package com.geekbrains.mydelivery.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.mydelivery.databinding.FragmentMenuBinding
import com.geekbrains.mydelivery.databinding.FragmentMenuNewBinding
import com.geekbrains.mydelivery.model.MenuDTOItem
import com.geekbrains.mydelivery.model.common.Common
import com.geekbrains.mydelivery.model.retrofit.RetrofitServices
import com.geekbrains.mydelivery.view.adapter.MyMenuAdapter
import com.geekbrains.mydelivery.view.behavior.FadeBehavior
import kotlinx.android.synthetic.main.fragment_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuFragment : Fragment() {

    private lateinit var mService: RetrofitServices
    private lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMenuAdapter

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

        mService = Common.retrofitService
        recycler.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layoutManager

        getAllMovieList()
        //(binding.pizzas.layoutParams as CoordinatorLayout.LayoutParams).behavior = FadeBehavior()
    }

    private fun getAllMovieList() {
        mService.getMenuList().enqueue(object : Callback<MutableList<MenuDTOItem>> {
            override fun onFailure(call: Call<MutableList<MenuDTOItem>>, t: Throwable) {

            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<MutableList<MenuDTOItem>>,
                response: Response<MutableList<MenuDTOItem>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val menuItems = response.body() as MutableList<MenuDTOItem>
                    adapter = MyMenuAdapter(requireActivity().applicationContext, menuItems)
                    adapter.notifyDataSetChanged()
                    recycler.adapter = adapter
                } else {
                    // Обработка неуспешного ответа или пустого тела
                    //binding.responseErrorMessage.text = "Sorry, You have exceeded the MONTHLY quota for Requests on your current plan, BASIC. Upgrade your plan at https://rapidapi.com/kaushiksheel9/api/pizza-and-desserts"
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MenuFragment()
    }
}