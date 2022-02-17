package com.digimaster.finalproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digimaster.finalproject.di.DaggerAppComponent
import com.digimaster.finalproject.model.login.LoginResponse
import com.digimaster.finalproject.model.requestLogin.RequestLogin
import com.digimaster.finalproject.repository.AppRepository
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class LoginViewModel : ViewModel() {
    private val list = MutableLiveData<LoginResponse>()
    private val compositeDisposable = CompositeDisposable()
    private val isError = MutableLiveData<Boolean>()

    @Inject
    lateinit var repository: AppRepository

    init {
        DaggerAppComponent.create().injectLogin(this)
    }

    fun postLogin(requestLogin: RequestLogin) {
        compositeDisposable.add(
            repository.postLogin(requestLogin)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<LoginResponse>() {
                    override fun onSuccess(t: LoginResponse) {
                        if (t.code == 200) {
                            list.value = t
                        } else {
                            isError.value = true
                        }
                    }

                    override fun onError(e: Throwable) {
                        isError.value = true
                        if (e is HttpException) {
                            val errorBody = (e as HttpException).response()?.errorBody()
                            val gson = Gson()
                            val error = gson.fromJson(
                                errorBody?.string(),
                                LoginResponse::class.java
                            )
                        }
                    }

                })
        )
    }

    fun listResponse(): MutableLiveData<LoginResponse> {
        return list
    }

    fun getIsError(): MutableLiveData<Boolean> {
        return isError
    }
}