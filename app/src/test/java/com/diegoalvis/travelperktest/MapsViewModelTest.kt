package com.diegoalvis.travelperktest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.diegoalvis.core.entities.VenueEntity
import com.diegoalvis.core.usecases.GetVenuesUseCase
import com.diegoalvis.travelperktest.ui.MapsViewModel
import com.diegoalvis.travelperktest.ui.models.MapUiModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.Exception


@OptIn(ExperimentalCoroutinesApi::class)
class MapsViewModelTest {

    @get:Rule
    val mainThread = InstantTaskExecutorRule()

    lateinit var getVenuesUseCase: GetVenuesUseCase
    lateinit var viewModel: MapsViewModel


    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        getVenuesUseCase = mockk()
        viewModel = MapsViewModel(getVenuesUseCase = getVenuesUseCase)
    }

    @After
    fun finish() {
        Dispatchers.resetMain()
    }


    @Test
    fun `load venues fetches venues is successful`() {
        val venuesList = (1..10).map {
            VenueEntity(
                "", null, it.toDouble(), it.toDouble()
            )
        }
        coEvery { getVenuesUseCase.execute(any()) } returns Result.success(venuesList)


        viewModel.loadVenues()

        coVerify(exactly = 1) { getVenuesUseCase.execute(any()) }
        assertThat(viewModel.uiModel.value, instanceOf(MapUiModel.Success::class.java))

    }

    @Test
    fun `load venues fetches venues is not succesful`() {
        coEvery { getVenuesUseCase.execute(any()) } returns Result.failure(Exception())

        viewModel.loadVenues()

        coVerify(exactly = 1) { getVenuesUseCase.execute(any()) }
        assertThat(viewModel.uiModel.value, instanceOf(MapUiModel.Failure::class.java))
    }

}