package com.geekbrains.mydelivery.domain

import com.geekbrains.mydelivery.presentation.menu.ViewModelMenu

interface RepositoryMenu {
    fun getAllMenu(callback: ViewModelMenu.Callback)
}