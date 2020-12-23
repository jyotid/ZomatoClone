object Version{
    val MinSDK = 21
    val CompileSDK = 30
    val TargetSDK = 30
    val VersionCode = 1
    val VersionName = "1.0"
    val Kotlin = "1.4.10"
    val KotlinCompilerExtensionVersion = "1.0.0-alpha06"
    val Compose = "1.0.0-alpha06"
    val Navigation = "1.0.0-alpha01"
    val Retrofit = "2.6.2"
    val Dagger = "2.10"
}
object Dependencies {
    val Rx = "io.reactivex.rxjava3:rxjava:3.0.0"
    val Material = "com.google.android.material:material:1.2.1"

}
object Compose{
    val Ui = "androidx.compose.ui:ui:${Version.Compose}"
    val Material = "androidx.compose.material:material:${Version.Compose}"
    val Tooling = "androidx.ui:ui-tooling:${Version.Compose}"
    val Icons = "androidx.compose.material:material-icons-extended:${Version.Compose}"
    val Livedata =  "androidx.compose.runtime:runtime-livedata:${Version.Compose}"
    val Navigation = "androidx.navigation:navigation-compose:${Version.Navigation}"
}

object AndroidX{
    val Core = "androidx.core:core-ktx:1.3.2"
    val AppCompat = "androidx.appcompat:appcompat:1.2.0"
    val ConstraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
}

object Kotlin{
    val STDLib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin}"
}

object Retrofit{
    val Lib = "com.squareup.retrofit2:retrofit:${Version.Retrofit}"
    val Converter = "com.squareup.retrofit2:converter-moshi:${Version.Retrofit}"
    val Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Version.Retrofit}"
}
object Dagger{
    val Lib = "com.google.dagger:dagger:${Version.Dagger}"
    val AnnotationProcessor = "com.google.dagger:dagger-compiler:${Version.Dagger}"
}

