package com.jetpackcompose.zomatoclone.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.home.HomePresenter.Section.*
import javax.inject.Inject

class HomePresenter @Inject constructor() {
    private var _uiState: MutableLiveData<HomePageUiState> =
            MutableLiveData(HomePageUiState.Loading)
    val uiState: LiveData<HomePageUiState> = _uiState

    init {
        _uiState.value = HomePageUiState.Success(getItems())
    }

    fun onFilterItemClicked(item: Section) {
        when(item){
            is Filter ->{
                val state = uiState.value as HomePageUiState.Success
                val filters = state.items[SectionType.Filter]?: mutableListOf()
                val index = filters.indexOf(item)
                val modifiedItem = item.copy(isSelected = !item.isSelected)
                filters.removeAt(index)
                filters.add(index, modifiedItem)
                val currentMap= state.items as MutableMap
                currentMap[SectionType.Filter] = filters
                _uiState.value = HomePageUiState.Success(currentMap)
            }
            is Category ->{


            }
            is Cuisine ->{

            }
            is Restaurants->{

            }
        }

    }

    private fun getItems(): Map<SectionType, MutableList<Section>> {
        val filterItems = mutableListOf<Section>(
                Filter(1, "Filter", R.drawable.ic_filter),
                Filter(2, "Bookmarks", R.drawable.ic_bookmark),
                Filter(1, "Rating: 4.0+", null),
                Filter(2, "Safe and hygenice", null)
        )
        val categoryItem = mutableListOf<Section>(
                Category(1, "Pure Veg", R.drawable.ic_veg),
                Category(2, "Max Safety", R.drawable.ic_safety),
                Category(1, "Pro", R.drawable.ic_pro),
                Category(1, "Trending", R.drawable.ic_trending)

        )
        val cuisine = mutableListOf<Section>(
                Cuisine(1, "Pasta", R.drawable.pasta),
                Cuisine(1, "Salad", R.drawable.salad),
                Cuisine(1, "french", R.drawable.french),
                Cuisine(1, "Pasta", R.drawable.pasta),
                Cuisine(1, "Salad", R.drawable.salad),
                Cuisine(1, "french", R.drawable.french),
                Cuisine(1, "Pasta", R.drawable.pasta),
                Cuisine(1, "Salad", R.drawable.salad),
                Cuisine(1, "french", R.drawable.french),
                Cuisine(1, "Pasta", R.drawable.pasta),
                Cuisine(1, "Salad", R.drawable.salad),
                Cuisine(1, "french", R.drawable.french)
        )

        val restaurants = mutableListOf<Section>(
                Restaurants(
                        1,
                        "The Pizza box",
                        "4.5",
                        "100 for two",
                        "40%",
                        "35 mins",
                        R.drawable.pasta,
                        false,
                        true
                ),
                Restaurants(
                        1,
                        "The Burger King",
                        "4.5",
                        "100 for 2",
                        "40%",
                        "35 mins",
                        R.drawable.pasta,
                        false,
                        true
                ),
                Restaurants(
                        1,
                        "Punjabi dhaba",
                        "4.5",
                        "100 for 2",
                        "40%",
                        "35 mins",
                        R.drawable.pasta,
                        false,
                        true
                ),
                Restaurants(
                        1,
                        "The China town",
                        "4.5",
                        "100 for 2",
                        "40%",
                        "35 mins",
                        R.drawable.pasta,
                        false,
                        true
                ),
                Restaurants(
                        1,
                        "Vasanth bhavan",
                        "4.5",
                        "100 for 2",
                        "40%",
                        "35 mins",
                        R.drawable.pasta,
                        false,
                        true
                )
        )
        return mapOf(SectionType.Filter to filterItems, SectionType.Category to categoryItem, SectionType.Cuisine to cuisine, SectionType.Restaurant to restaurants)
    }

    sealed class HomePageUiState {
        class Success(val items: Map<SectionType, MutableList<Section>>) : HomePageUiState()
        object Loading : HomePageUiState()
        object Error : HomePageUiState()
    }

    enum class SectionType {
        Filter, Category, Cuisine, Restaurant
    }

    sealed class Section {
        data class Filter(val id: Int, val label: String, val drawableRes: Int?, var isSelected: Boolean = false) : Section()
        data class Category(val id: Int, val label: String, val drawableRes: Int) : Section()
        data class Cuisine(val id: Int, val label: String, val drawableRes: Int) : Section()
        data class Restaurants(
                val id: Int,
                val name : String,
                val rating: String,
                val costEstimate: String,
                val offer: String,
                val estimatedDeliveryTime : String,
                val drawableRes: Int,
                val isBookMarked : Boolean,
                val isPromoted : Boolean
        ): Section()
    }

}
