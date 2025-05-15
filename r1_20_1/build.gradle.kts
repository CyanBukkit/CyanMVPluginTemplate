dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:spigot:1.20.1-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:minecraft-server:1.20.1-R0.1-SNAPSHOT")
    compileOnly("com.mojang:datafixerupper:6.0.8")
    compileOnly("com.mojang:brigadier:1.2.9")
    compileOnly("com.mojang:logging:1.1.1")
    compileOnly(kotlin("stdlib-jdk8"))
    implementation(project(":interface"))
}

repositories {
    maven("https://maven.elmakers.com/repository")
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.encoding = "UTF-8"
}