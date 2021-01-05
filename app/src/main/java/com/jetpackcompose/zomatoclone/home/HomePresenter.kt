package com.jetpackcompose.zomatoclone.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.home.HomePresenter.Item.*
import com.jetpackcompose.zomatoclone.home.HomePresenter.SectionType.CuisineSection
import javax.inject.Inject

class HomePresenter @Inject constructor() {
    private var _uiState: MutableLiveData<HomePageUiState> =
            MutableLiveData(HomePageUiState.Loading)
    val uiState: LiveData<HomePageUiState> = _uiState
    private val filterItems = mutableListOf(
            FilterItem(1, "Filter", R.drawable.ic_filter),
            FilterItem(2, "Bookmarks", R.drawable.ic_bookmark),
            FilterItem(1, "Rating: 4.0+", null),
            FilterItem(2, "Safe and hygenice", null)
    )

    val categoryItem = mutableListOf(
            CategoryItem(1, "Pure Veg", R.drawable.ic_veg),
            CategoryItem(2, "Max Safety", R.drawable.ic_safety),
            CategoryItem(1, "Pro", R.drawable.ic_pro),
            CategoryItem(1, "Trending", R.drawable.ic_trending)

    )
    val cuisines = mutableListOf(
            CuisineItem(1, "Pasta", R.drawable.pasta),
            CuisineItem(1, "Salad", R.drawable.salad),
            CuisineItem(1, "french", R.drawable.french),
            CuisineItem(1, "Pasta", R.drawable.pasta),
            CuisineItem(1, "Salad", R.drawable.salad),
            CuisineItem(1, "french", R.drawable.french),
            CuisineItem(1, "Pasta", R.drawable.pasta),
            CuisineItem(1, "Salad", R.drawable.salad),
            CuisineItem(1, "french", R.drawable.french),
            CuisineItem(1, "Pasta", R.drawable.pasta),
            CuisineItem(1, "Salad", R.drawable.salad),
            CuisineItem(1, "french", R.drawable.french)
    )
    init {
        _uiState.value = HomePageUiState.Success(getItems())
    }

    fun onFilterItemClicked(item: Item) {
        when(item){
            is FilterItem ->{
                val currentState = uiState.value as HomePageUiState.Success
                val currentFilterItemState = currentState.items[SectionType.FilterSection] as SectionNew.FilterSection
                val filters = currentFilterItemState.list.toMutableList()
                val index = filters.indexOf(item)
                val modifiedItem = item.copy(isSelected = !item.isSelected)
                filters.removeAt(index)
                filters.add(index, modifiedItem)
                val currentMap= currentState.items as MutableMap
                currentMap[SectionType.FilterSection] = currentFilterItemState.copy(list = filters)
                val item = filters.find{ it.isSelected }
                if(item!=null){
                    currentMap.remove(SectionType.CategorySection)
                    currentMap.remove(SectionType.CuisineSection)
                }else{
                    currentMap[SectionType.CategorySection] = SectionNew.CategorySection(categoryItem)
                    currentMap[SectionType.CuisineSection] = SectionNew.CuisineSection(cuisines,false)
                }
                _uiState.value = HomePageUiState.Success(currentMap)

            }
            is CategoryItem ->{


            }
            is CuisineItem ->{

            }
            is Restaurant->{

            }
        }
    }

    fun onShowMoreClick(){
        val currentState = uiState.value as HomePageUiState.Success
        val currentCuisineItemState = currentState.items[CuisineSection] as SectionNew.CuisineSection
        val currentMap= currentState.items as MutableMap
        currentMap[CuisineSection] = currentCuisineItemState.copy(isExpanded = !currentCuisineItemState.isExpanded)
        _uiState.value = HomePageUiState.Success(currentMap)
    }

    private fun getItems(): Map<SectionType, SectionNew> {


        val restaurants = mutableListOf(
                Restaurant(
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
                Restaurant(
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
                Restaurant(
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
                Restaurant(
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
                Restaurant(
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
        return mapOf(SectionType.FilterSection to SectionNew.FilterSection(filterItems),
                SectionType.CategorySection to SectionNew.CategorySection(categoryItem),
                CuisineSection to SectionNew.CuisineSection(cuisines,false),
                SectionType.RestaurantSection to SectionNew.RestaurantSection(restaurants, false)
        )
    }

    sealed class HomePageUiState {
        class Success(val items: Map<SectionType, SectionNew>) : HomePageUiState()
        object Loading : HomePageUiState()
        object Error : HomePageUiState()
    }

    enum class SectionType {
        FilterSection, CategorySection, CuisineSection, RestaurantSection
    }

    sealed class SectionNew{
        data class FilterSection(val list: List<FilterItem>) : SectionNew()
        data class CategorySection(val list : List<CategoryItem>) : SectionNew()
        data class CuisineSection(val list : List<CuisineItem>, val isExpanded : Boolean) : SectionNew()
        data class RestaurantSection(val list : List<Restaurant>, val isLoading : Boolean) : SectionNew()

    }
    sealed class Item{
        data class FilterItem(val id: Int, val label: String, val drawableRes: Int?, var isSelected: Boolean = false) : Item()
        data class CategoryItem(val id: Int, val label: String, val drawableRes: Int) : Item()
        data class CuisineItem(val id: Int, val label: String, val drawableRes: Int) : Item()
        data class Restaurant(
                val id: Int,
                val name : String,
                val rating: String,
                val costEstimate: String,
                val offer: String,
                val estimatedDeliveryTime : String,
                val drawableRes: Int,
                val isBookMarked : Boolean,
                val isPromoted : Boolean
        ): Item()
    }



}
