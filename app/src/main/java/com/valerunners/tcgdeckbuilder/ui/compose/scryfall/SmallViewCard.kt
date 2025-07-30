package com.valerunners.tcgdeckbuilder.ui.compose.scryfall

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.navOptions
import coil.compose.AsyncImage
import com.valerunners.tcgdeckbuilder.ScryfallCard
import com.valerunners.tcgdeckbuilder.ui.LargeCardView
import com.valerunners.tcgdeckbuilder.ui.SmallCardList
import com.valerunners.tcgdeckbuilder.utilities.GetManaSymbolDrawableId

@Composable
fun SmallViewCard(card: ScryfallCard? = null, navController: NavController, innerPadding: PaddingValues) {
    Log.d("SmallViewCard", card.toString())
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp,
        ),
        modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
        onClick = { navController.navigate(
            route = LargeCardView(name = card!!.name ?: "", imageUrl = card.imageUrls!!.large ?: ""),
            navOptions =  navOptions {
                popUpTo<SmallCardList>{ saveState = true }
                restoreState = true
            }
        )  }
    ) {
        Row(Modifier
            .fillMaxWidth()
        ) {
            Column {
                if(card!!.imageUrls != null) {
                    AsyncImage(
                        modifier = Modifier.size(100.dp),
                        contentScale = ContentScale.Crop,
                        model = card.imageUrls!!.artCrop,
                        contentDescription = card!!.name,
                    )
                }
            }
            Column(Modifier.padding(5.dp, 0.dp, 5.dp, 0.dp)) {
                card!!.name?.let {
                    Text(
                        fontSize = 16.sp,
                        text = it
                    )
                }
                card.typeLine?.let {
                    Text(
                        fontSize = 12.sp,
                        text = it
                    )
                }
                if(!card.typeLine?.contains("land", ignoreCase = true)!!){
//                    card.manaCost?.let {Text(
//                        fontSize = 12.sp,
//                        text = it
//                    )}
                    Row {
                        if (!card.manaCost.isNullOrEmpty()) {
                            val manaSymbolsSplit = card.manaCost.split("}")
                            for (manaSymbol in manaSymbolsSplit) {
                                if (!manaSymbol.isNullOrEmpty()) {
                                    val manaSymbolId = GetManaSymbolDrawableId(manaSymbol)
                                    Image(
                                        painter = painterResource(id = manaSymbolId),
                                        contentDescription = card.manaCost,
                                        modifier = Modifier.size(10.dp)
                                    )
                                    Spacer(modifier = Modifier.size(5.dp))
                                }
                            }
                        }
                    }
                }
                if(card.typeLine.contains("creature", ignoreCase = true)) {
                    var textString = ""
                    if (!card.power.isNullOrEmpty() || card.toughness.isNullOrEmpty()) {
                        textString = "${card.power} / ${card.toughness}"
                    } else if (!card.loyality.isNullOrEmpty()) {
                        textString = card.loyality
                    }
                    Text(
                        fontSize = 12.sp,
                        text = textString
                    )
                }
//                Text(text = card.oracleText)
//                Text(text = card.flavorText)
            }
        }
    }
}