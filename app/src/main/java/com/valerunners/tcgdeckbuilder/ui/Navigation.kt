package com.valerunners.tcgdeckbuilder.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.valerunners.tcgdeckbuilder.ui.compose.scryfall.LargeViewCard
import com.valerunners.tcgdeckbuilder.ui.compose.scryfall.SmallCardListView
import com.valerunners.tcgdeckbuilder.viewmodels.MainActivityViewModel
import kotlinx.serialization.Serializable

@Serializable
object SmallCardList
@Serializable
object SmallCardView
@Serializable
data class LargeCardView(val name: String? = null, val imageUrl: String? = null)

@Composable
fun NavigationSetup(innerPadding: PaddingValues, mainActivityViewModel: MainActivityViewModel, navController: NavHostController) {
    NavHost(navController = navController, startDestination = SmallCardList) {
        composable<SmallCardList> {
            SmallCardListView(
                innerPadding = innerPadding,
                navController = navController
            )
            mainActivityViewModel.updateAppBarTitle("TCG Deck Builder")
        }
        composable<LargeCardView>{ backStackEntry ->
            val largeCardView: LargeCardView = backStackEntry.toRoute()
            LargeViewCard(name = largeCardView.name!!.toString(), imageUrl = largeCardView.imageUrl!!.toString())
            mainActivityViewModel.updateAppBarTitle(largeCardView.name.toString())
        }
        composable<SmallCardView>{

        }
    }
}