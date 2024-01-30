//plugins {
//    kotlin("jvm") version "1.8.21"
//}

repositories {
    maven("https://nexus.cyanbukkit.cn/repository/maven-public")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.15-R0.1-SNAPSHOT")
    // Papi
    compileOnly(kotlin("stdlib-jdk8"))
}



kotlin {
    jvmToolchain(8)
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.encoding = "UTF-8"
}
