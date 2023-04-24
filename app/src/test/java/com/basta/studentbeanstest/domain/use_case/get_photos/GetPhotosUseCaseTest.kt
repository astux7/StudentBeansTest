package com.basta.studentbeanstest.domain.use_case.get_photos

import app.cash.turbine.test
import com.basta.studentbeanstest.common.Resource
import com.basta.studentbeanstest.utils.FakeRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert

import org.junit.Before
import org.junit.Test

class GetPhotosUseCaseTest {
    private lateinit var getPhotos: GetPhotosUseCase
    private lateinit var fakeRepo: FakeRepo

    @Before
    fun setUp() {
        fakeRepo = FakeRepo()
        getPhotos = GetPhotosUseCase(fakeRepo)
    }

    @Test
    fun `First is showing loading before data is returned`() = runBlocking {
        getPhotos.invoke().test {
            val loading = awaitItem() // first value of emit is Loading
            Assert.assertTrue(loading is Resource.Loading)

            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `Get all photos from given API`() = runBlocking {
        getPhotos.invoke().test {
            val loading = awaitItem() // first value of emit is Loading
            Assert.assertTrue(loading is Resource.Loading)

            val result = awaitItem() // next value

            Assert.assertTrue(result.data!!.isNotEmpty())

            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `First photo id is 1 with correct data`() = runBlocking {
        getPhotos.invoke().test {
            val loading = awaitItem() // first value of emit is Loading
            Assert.assertTrue(loading is Resource.Loading)

            val result = awaitItem() // next value

            Assert.assertEquals(result.data!!.first().id, 1)
            Assert.assertEquals(result.data!!.first().title, "accusamus beatae ad facilis cum similique qui sunt")
            Assert.assertEquals(result.data!!.first().thumbnailUrl, "https://via.placeholder.com/150/92c952")

            cancelAndConsumeRemainingEvents()
        }
    }
}