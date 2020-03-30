package com.oraganisation.stonedstation.utilities
//
//
//import android.content.Context
//import com.globallogic.offerings.configurations.IConfigurationManager
//import com.globallogic.offerings.data.AuthenticationRepository
//import com.globallogic.offerings.data.HomeRepository
//import com.globallogic.offerings.data.SuccessStoryRepository
//import com.globallogic.offerings.data.client.FirebaseAuthClient
//import com.globallogic.offerings.data.contracts.AuthRepositoryContract
//import com.globallogic.offerings.data.contracts.HomeRepositoryContract
//import com.globallogic.offerings.data.remote.*
//import com.globallogic.offerings.usecases.*
//import com.globallogic.offerings.viewmodels.AuthViewModelFactory
//import com.globallogic.offerings.viewmodels.HomeViewModelFactory
//import com.globallogic.offerings.viewmodels.SuccessStoryViewModelFactory
//import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.ktx.Firebase
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
///**
// * Provides objects needed by classes
// */
//object DependencyProvider {
//    /**
//     *
//     */
//    fun provideLoginViewModelFactory(context: Context): AuthViewModelFactory {
//        val useCase = getAuthUseCase(context)
//        return AuthViewModelFactory(useCase)
//    }
//
//    fun provideHomeViewModelFactory(context:Context): HomeViewModelFactory {
//    val usecase=getHomeUseCase(context)
//    return HomeViewModelFactory(usecase)
//    }
//    fun provideSuccessStoryViewModelFactory(context: Context):SuccessStoryViewModelFactory
//    {
//        val useCase=getSuccessStoryUseCase(context)
//        return SuccessStoryViewModelFactory(useCase)
//    }
//
//    private fun getSuccessStoryUseCase(context: Context): SuccessStoryUseCase {
//      return SuccessStoryInteractor(getSuccessStoryRepository(context))
//    }
//
//
//    private fun getHomeUseCase(context: Context): HomeUseCase {
//     return HomeInteractor(getHomeRepository(context))
//    }
//
//    private fun getSuccessStoryRepository(context: Context):SuccessStoryRepository
//    {
//    return SuccessStoryRepository.getInstance(provideSuccessStoryDataSource(provideSuccessStoryApiService()))
//    }
//
//    private fun provideSuccessStoryApiService(): SuccesStoryService {
//   return provideService(SuccesStoryService::class.java)
//    }
//
//    private fun provideSuccessStoryDataSource(succesStoryService: SuccesStoryService): SuccessStoryRemoteDataSource {
//  return SuccessStoryRemoteDataSource(succesStoryService)
//    }
//
//    private fun getHomeRepository(context: Context): HomeRepositoryContract {
//     return HomeRepository.getInstance(provideHomeDataSource(provideHomeApiService()))
//    }
//
//    private fun provideHomeDataSource(homeService: HomeService): HomeremoteDataSource {
//      return HomeremoteDataSource(homeService)
//    }
//
//    private fun provideHomeApiService(): HomeService {
//     return provideService(HomeService::class.java)
//    }
//
//    private fun getAuthUseCase(context: Context): AuthUseCase {
//        return AuthInteractor(getAuthenticationRepository(context))
//    }
//
//    /**
//     *
//     */
//    private fun getAuthenticationRepository(context: Context): AuthRepositoryContract {
//        return AuthenticationRepository.getInstance(provideLoginRemoteDataSource(FirebaseAuthClient()))
//    }
//
//    /**
//     *
//     */
//    private fun provideLoginRemoteDataSource(authService: AuthService) = AuthRemoteDataSource(authService)
//
//    /**
//     *
//     */
//    private fun provideAuthAPIService() = provideService(FirebaseAuthClient::class.java)
//
//    /**
//     *
//     */
//    fun provideConfigurationManager(): IConfigurationManager {
//        return ConfigurationManager.getInstance(provideFireStore())
//    }
//
//    /**
//     *
//     */
//    private fun provideFireStore(): FirebaseFirestore {
//        return Firebase.firestore
//    }
//
//    /**
//     *
//     */
//    private fun createRetrofit(): Retrofit {
//        val okHttpClient = OkHttpClient.Builder().build()
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//    }
//
//    /**
//     *
//     */
//    private fun <T> provideService(clazz: Class<T>): T {
//        return createRetrofit().create(clazz)
//    }
//}