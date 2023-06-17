package com.geekbrains.mydelivery.presentation.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.mydelivery.data.model.MenuDTO
import com.geekbrains.mydelivery.data.repoimpl.RepositoryMenuImpl
import com.geekbrains.mydelivery.domain.RepositoryMenu

class ViewModelMenu(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryMenu = RepositoryMenuImpl()
): ViewModel() {

    fun getLiveData() = liveData

    fun getAllMenu() {
        repository.getAllMenu(callback)
    }

    private val callback = object : Callback {
        override fun onResponse(menu: MenuDTO) {
            liveData.postValue(AppState.Success(menu))
        }

        override fun onFail() {
            liveData.postValue(AppState.Error(Throwable()))
        }
    }

    interface Callback {
        fun onResponse(menu: MenuDTO)
        fun onFail()
    }

    sealed class AppState {
        object Loading: AppState()
        data class Success(val categoryDTO: MenuDTO): AppState()
        data class Error(val error: Throwable): AppState()
    }
}