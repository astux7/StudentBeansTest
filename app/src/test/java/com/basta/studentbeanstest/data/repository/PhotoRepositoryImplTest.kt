package com.basta.studentbeanstest.data.repository

import com.basta.studentbeanstest.data.remote.PhotoApi
import com.basta.studentbeanstest.data.remote.invalidPhotoResponse
import com.basta.studentbeanstest.data.remote.validPhotoResponse
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PhotoRepositoryImplTest {
    private lateinit var repository: PhotoRepositoryImpl
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: PhotoApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()

        api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(PhotoApi::class.java)

        repository = PhotoRepositoryImpl(
            api = api
        )
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Get photos valid response, returns list of photos`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().setResponseCode(200)
                .setBody(validPhotoResponse)
        )

        val result = repository.getPhotos()

        Assert.assertTrue(result.isSuccess == true)
    }

    @Test
    fun `Get photos invalid code, returns list and error`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().setResponseCode(403)
                .setBody(validPhotoResponse)
        )

        val result = repository.getPhotos()

        Assert.assertTrue(result.isFailure)
    }

    @Test
    fun `Get photos invalid response, returns error`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().setResponseCode(403)
                .setBody(invalidPhotoResponse)
        )

        val result = repository.getPhotos()

        Assert.assertTrue(result.isFailure)
    }
}