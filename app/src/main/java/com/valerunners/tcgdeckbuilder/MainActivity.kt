package com.valerunners.tcgdeckbuilder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.valerunners.tcgdeckbuilder.ui.NavigationSetup
import com.valerunners.tcgdeckbuilder.ui.theme.TCGDeckbuilderTheme
import com.valerunners.tcgdeckbuilder.viewmodels.MainActivityViewModel

class MainActivity : ComponentActivity() {
//    private lateinit var edhrecRetService: EdhrecApiService
private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TCGDeckbuilderTheme {
                AppUI(mainActivityViewModel)
            }
        }

//        edhrecRetService = EdhrecRetrofitInstance
//            .getEdhrecRetrofitInstance()
//            .create(EdhrecApiService::class.java)
//
//        lifecycleScope.launch {
//            val response = edhrecRetService.getCommander("Zedruu the Greathearted".replace(" ", "-").lowercase())
//            if(response.isSuccessful){
//                val data = response.body()
//                Log.d("Main", data.toString())
//            } else {
//                Log.d("Main", response.toString())
//                Log.d("Main", response.message())
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    TCGDeckbuilderTheme {
//        LargeViewCard(modifier = Modifier)
    }
}

@Composable
fun AppUI(mainActivityViewModel: MainActivityViewModel){
    val navController = rememberNavController()
    Scaffold(
        topBar = {TopAppBarMain(mainActivityViewModel, navController)},
        modifier = Modifier.fillMaxWidth(),
        content = { innerPadding ->
            NavigationSetup(
                innerPadding = innerPadding,
                mainActivityViewModel,
                navController
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarMain(mainActivityViewModel: MainActivityViewModel, navController: NavHostController){
    val title: String by mainActivityViewModel.appBarTitle.observeAsState("TCG Deck Builder")
    TopAppBar(
        title = {
            title.let { Text(it) }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.DarkGray,
            titleContentColor = Color.White,
        ),
        navigationIcon = {
            IconButton(onClick = { navigateBack(mainActivityViewModel, navController) }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
//        actions = {
//            IconButton(onClick = {/* Do Something*/ }) {
//                Icon(Icons.Filled.Share, null)
//            }
//            IconButton(onClick = {/* Do Something*/ }) {
//                Icon(Icons.Filled.Settings, null)
//            }
//        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}

fun navigateBack(mainActivityViewModel: MainActivityViewModel, navController: NavHostController){
    navController.navigateUp()
}

