package com.example.myapplicationchannapatnatoys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            MaterialTheme {

                ToyApp()
            }
        }
    }
}

data class Toy(

    val id: String,

    val name: String,

    val artisan: String,

    val artisanPhoto: String,

    val category: String,

    val price: String,

    val image: String
)

@Composable
fun ToyApp() {

    var currentScreen by remember {

        mutableStateOf("welcome")
    }

    val toys = listOf(

        Toy(
            "123456",
            "Wooden Elephant",
            "Ramesh",
            "https://images.unsplash.com/photo-1564349683136-77e08dba1ef7",
            "Animal Toys",
            "₹500",
            "https://images.unsplash.com/photo-1564349683136-77e08dba1ef7"
        ),

        Toy(
            "223456",
            "Wooden Horse",
            "Suresh",
            "https://images.unsplash.com/photo-1517849845537-4d257902454a",
            "Animal Toys",
            "₹650",
            "https://images.unsplash.com/photo-1517849845537-4d257902454a"
        ),

        Toy(
            "323456",
            "Wooden Train",
            "Mahesh",
            "https://images.unsplash.com/photo-1518770660439-4636190af475",
            "Vehicle Toys",
            "₹700",
            "https://images.unsplash.com/photo-1518770660439-4636190af475"
        ),

        Toy(
            "423456",
            "Wooden Car",
            "Ravi",
            "https://images.unsplash.com/photo-1503376780353-7e6692767b70",
            "Vehicle Toys",
            "₹450",
            "https://images.unsplash.com/photo-1503376780353-7e6692767b70"
        ),

        Toy(
            "523456",
            "Wooden Doll",
            "Lakshmi",
            "https://images.unsplash.com/photo-1515886657613-9f3515b0c78f",
            "Kids Toys",
            "₹350",
            "https://images.unsplash.com/photo-1515886657613-9f3515b0c78f"
        )
    )

    when (currentScreen) {

        "welcome" -> {

            WelcomeScreen {

                currentScreen = "login"
            }
        }

        "login" -> {

            LoginScreen {

                currentScreen = "home"
            }
        }

        "home" -> {

            HomeScreen(toys)
        }
    }
}

@Composable
fun WelcomeScreen(onNext: () -> Unit) {

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(

                Brush.verticalGradient(

                    listOf(
                        Color(0xFFFFCC80),
                        Color.White
                    )
                )
            ),

        contentAlignment = Alignment.Center
    ) {

        Column(

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(

                text = "ಚನ್ನಪಟ್ಟಣ ಆಟಿಕೆಗಳು",

                fontSize = 36.sp,

                fontWeight = FontWeight.Bold,

                color = Color(0xFFBF360C)
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(

                text = "Channapatna Toys",

                fontSize = 30.sp,

                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Traditional Wooden Toy Heritage"
            )

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            Button(

                onClick = onNext,

                colors =
                    ButtonDefaults.buttonColors(
                        containerColor =
                            Color(0xFFBF360C)
                    )
            ) {

                Text("Get Started")
            }
        }
    }
}

@Composable
fun LoginScreen(onLogin: () -> Unit) {

    var email by remember {

        mutableStateOf("")
    }

    var password by remember {

        mutableStateOf("")
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center
    ) {

        Text(

            text = "Login",

            fontSize = 30.sp,

            fontWeight = FontWeight.Bold,

            color = Color(0xFFBF360C)
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(

            value = email,

            onValueChange = {

                email = it
            },

            label = {

                Text("Email")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(

            value = password,

            onValueChange = {

                password = it
            },

            label = {

                Text("Password")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(

            onClick = onLogin,

            modifier = Modifier.fillMaxWidth(),

            colors =
                ButtonDefaults.buttonColors(

                    containerColor =
                        Color(0xFFBF360C)
                )
        ) {

            Text("Login")
        }
    }
}

@Composable
fun HomeScreen(toys: List<Toy>) {

    var searchId by remember {

        mutableStateOf("")
    }

    var selectedToy by remember {

        mutableStateOf<Toy?>(null)
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF3E0))
            .verticalScroll(
                rememberScrollState()
            )
    ) {

        Text(

            text = "Toy Verification",

            fontSize = 30.sp,

            fontWeight = FontWeight.Bold,

            color = Color(0xFFBF360C),

            modifier = Modifier.padding(16.dp)
        )

        OutlinedTextField(

            value = searchId,

            onValueChange = {

                if (it.length <= 6)

                    searchId = it
            },

            label = {

                Text("Enter 6 Digit Toy ID")
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Button(

            onClick = {

                selectedToy = toys.find {

                    it.id == searchId
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),

            colors =
                ButtonDefaults.buttonColors(

                    containerColor =
                        Color(0xFFBF360C)
                )
        ) {

            Text("Verify Toy")
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        selectedToy?.let { toy ->

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                shape = RoundedCornerShape(24.dp),

                elevation =
                    CardDefaults.cardElevation(10.dp)
            ) {

                Column(

                    modifier =
                        Modifier.padding(16.dp),

                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Image(

                        painter =
                            rememberAsyncImagePainter(
                                toy.image
                            ),

                        contentDescription = null,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .clip(
                                RoundedCornerShape(20.dp)
                            ),

                        contentScale =
                            ContentScale.Crop
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(

                        text = toy.name,

                        fontSize = 26.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Text("Toy ID: ${toy.id}")

                    Text("Category: ${toy.category}")

                    Text("Price: ${toy.price}")

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(

                        text = "Artisan Details",

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold,

                        color = Color(0xFFBF360C)
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Image(

                        painter =
                            rememberAsyncImagePainter(
                                toy.artisanPhoto
                            ),

                        contentDescription = null,

                        modifier = Modifier
                            .size(120.dp)
                            .clip(
                                RoundedCornerShape(100.dp)
                            ),

                        contentScale =
                            ContentScale.Crop
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(

                        text = toy.artisan,

                        fontSize = 20.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Button(

                        onClick = { },

                        modifier = Modifier.fillMaxWidth(),

                        colors =
                            ButtonDefaults.buttonColors(

                                containerColor =
                                    Color(0xFFBF360C)
                            )
                    ) {

                        Text("Shop Now")
                    }
                }
            }
        }

        Text(

            text = "Educational Section",

            fontSize = 28.sp,

            fontWeight = FontWeight.Bold,

            modifier = Modifier.padding(16.dp),

            color = Color(0xFFBF360C)
        )

        EducationCard(

            "Wood Craft",

            "Channapatna toys are made using Aale Mara wood."
        )

        EducationCard(

            "Lac Coloring",

            "Natural lac colors are used for eco-friendly toys."
        )

        EducationCard(

            "Traditional Process",

            "Toys are handcrafted using traditional lathe machines."
        )

        Text(

            text = "Available Toys",

            fontSize = 28.sp,

            fontWeight = FontWeight.Bold,

            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(

            modifier = Modifier.height(1200.dp)
        ) {

            items(toys) { toy ->

                Card(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),

                    shape = RoundedCornerShape(20.dp),

                    elevation =
                        CardDefaults.cardElevation(8.dp)
                ) {

                    Row(

                        modifier =
                            Modifier.padding(12.dp)
                    ) {

                        Image(

                            painter =
                                rememberAsyncImagePainter(
                                    toy.image
                                ),

                            contentDescription = null,

                            modifier = Modifier
                                .size(120.dp)
                                .clip(
                                    RoundedCornerShape(16.dp)
                                ),

                            contentScale =
                                ContentScale.Crop
                        )

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column {

                            Text(

                                text = toy.name,

                                fontSize = 22.sp,

                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                "ID: ${toy.id}"
                            )

                            Text(
                                "Price: ${toy.price}"
                            )

                            Text(
                                "Category: ${toy.category}"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EducationCard(

    title: String,

    description: String
) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),

        shape = RoundedCornerShape(20.dp),

        elevation =
            CardDefaults.cardElevation(6.dp)
    ) {

        Column(

            modifier =
                Modifier.padding(16.dp)
        ) {

            Text(

                text = title,

                fontSize = 22.sp,

                fontWeight = FontWeight.Bold,

                color = Color(0xFFBF360C)
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(description)
        }
    }
}
