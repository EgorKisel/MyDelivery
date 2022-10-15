package com.geekbrains.mydelivery.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.mydelivery.databinding.FragmentMenuBinding
import com.geekbrains.mydelivery.model.MenuDTOItem
import com.geekbrains.mydelivery.model.common.Common
import com.geekbrains.mydelivery.model.retrofit.RetrofitServices
import com.geekbrains.mydelivery.view.adapter.MyMenuAdapter
import kotlinx.android.synthetic.main.fragment_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuFragment: Fragment() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMenuAdapter

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mService = Common.retrofitService
        recycler.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layoutManager

        getAllMovieList()

    }

    private fun getAllMovieList() {
        mService.getMenuList("9fb3046c93msh8851f1973697936p1e60e5jsnf451c9ebd530").enqueue(object : Callback<MutableList<MenuDTOItem>> {
            override fun onFailure(call: Call<MutableList<MenuDTOItem>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<MenuDTOItem>>, response: Response<MutableList<MenuDTOItem>>) {
                adapter = MyMenuAdapter(requireActivity().applicationContext, response.body() as MutableList<MenuDTOItem>)
                adapter.notifyDataSetChanged()
                recycler.adapter = adapter
            }
        })
    }

    companion object{
        @JvmStatic
        fun newInstance() =
            MenuFragment()
    }
}