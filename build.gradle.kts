plugins {

    id("com.android.application")

    id("org.jetbrains.kotlin.android")

    id("org.jetbrains.kotlin.plugin.compose")

    id("com.google.gms.google-services")
}

android {

    namespace = "com.example.myapplicationchannapatnatoys"

    compileSdk = 34

    defaultConfig {

        applicationId =
            "com.example.myapplicationchannapatnatoys"

        minSdk = 24

        targetSdk = 34

        versionCode = 1

        versionName = "1.0"
    }

    buildFeatures {

        compose = true
    }

    composeOptions {

        kotlinCompilerExtensionVersion = "1.5.14"
    }

    compileOptions {

        sourceCompatibility =
            JavaVersion.VERSION_11

        targetCompatibility =
            JavaVersion.VERSION_11
    }

    kotlinOptions {

        jvmTarget = "11"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")

    implementation("androidx.activity:activity-compose:1.9.0")

    implementation(
        platform(
            "androidx.compose:compose-bom:2024.06.00"
        )
    )

    implementation("androidx.compose.material3:material3")

    implementation(
        "androidx.compose.material:material-icons-extended"
    )

    implementation(
        "io.coil-kt:coil-compose:2.6.0"
    )

    implementation(
        "com.google.firebase:firebase-database-ktx:21.0.0"
    )
}