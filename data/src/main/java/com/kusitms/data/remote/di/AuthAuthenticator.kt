package com.kusitms.data.remote.di

import com.kusitms.data.local.AuthDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class AuthAuthenticator@Inject constructor(
    private val authDataStore: AuthDataStore
):Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val refreshToken = runBlocking {
            authDataStore.refreshToken.first()
        }

        if (refreshToken == null || refreshToken == "LOGIN") {
            response.close()
            return null
        }
        return newRequestWithToken(refreshToken, response.request)
    }

    private fun newRequestWithToken(token: String, request: Request): Request =
        request.newBuilder()
            .header("Authorization", token)
            .build()


}