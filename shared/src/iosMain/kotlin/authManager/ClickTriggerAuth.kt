package authManager

import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIApplication
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GoogleAuthenticator {
    @OptIn(ExperimentalForeignApi::class)
    suspend fun login() = suspendCoroutine<String?> { continuation ->
        val rootUiView = UIApplication.sharedApplication
            .keyWindow?.rootViewController

        if (rootUiView == null) {
            continuation.resume(null)
        } else {
            GIDSignIn.sharedInstance.signInWithPresentingViewController(rootUiView) { gidSignInResult, nsError ->
                if (nsError != null) {

                } else {
                    val idToken = gidSignInResult?.user?.idToken
                    val profile = gidSignInResult?.user?.profile
                    if (idToken != null) {
                        println(idToken.toString())
                    } else {
                        continuation.resume(null)
                    }
                }
            }
        }
    }
}