package com.basta.studentbeanstest.domain.use_case.get_photos

import com.basta.studentbeanstest.data.remote.PhotoApi
import com.basta.studentbeanstest.data.remote.validPhotoResponse
import com.basta.studentbeanstest.data.repository.PhotoRepositoryImpl
import com.basta.studentbeanstest.domain.models.Photo
import com.basta.studentbeanstest.domain.repository.PhotoRepository
import com.basta.studentbeanstest.presentation.image_list.Resource
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetPhotosUseCaseTest {
    private lateinit var useCase: GetPhotosUseCase
    private lateinit var repository: PhotoRepository
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        val api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoApi::class.java)
        repository = PhotoRepositoryImpl(api)
        useCase = GetPhotosUseCase(repository)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `emit Success when repository returns photos`() = runBlocking {
        // Enqueue a mock response
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(validPhotoResponse)
        mockWebServer.enqueue(mockResponse)

        // Invoke the use case
        val flow = useCase()

        // Verify that Resource.Loading is emitted first
        assertThat(flow.first()).isEqualTo(Resource.Loading<List<Photo>>(null as List<Photo>?))

        // Verify that Resource.Success is emitted with the correct data
        assertThat(flow.drop(1).take(1).single()).isEqualTo(
            Resource.Success(
                listOf(
                    Photo(
                        1,
                        "https://via.placeholder.com/150/92c952",
                        "accusamus beatae ad facilis cum similique qui sunt"
                    ),
                    Photo(
                        2,
                        "https://via.placeholder.com/150/771796",
                        "reprehenderit est deserunt velit ipsam"
                    ),
                    Photo(
                        3,
                        "https://via.placeholder.com/150/24f355",
                        "officia porro iure quia iusto qui ipsa ut modi"
                    ),
                )
            )
        )
    }

    @Test
    fun `emit Error when repository returns an error`() = runBlocking {
        // Enqueue a mock error response
        val mockResponse = MockResponse().setResponseCode(500)
        mockWebServer.enqueue(mockResponse)

        // Invoke the use case
        val flow = useCase()

        // Verify that Resource.Loading is emitted first
        assertThat(flow.first()).isEqualTo(Resource.Loading<List<Photo>>(null))

        // Verify that Resource.Error is emitted with the correct message
        assertThat(flow.drop(1).take(1).single()).isEqualTo(
            Resource.Error<List<Photo>>("Internal server error", null)
        )
    }

}