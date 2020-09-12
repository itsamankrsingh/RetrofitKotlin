package com.magician.retrofitkotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.magician.retrofitkotlin.repo.Repo

class MainViewModelFactory(private val repo:Repo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }

}