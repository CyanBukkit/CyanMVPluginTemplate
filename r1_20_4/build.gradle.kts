


repositories {
    maven("https://maven.elmakers.com/repository")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:spigot:1.20.4-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:minecraft-server:1.20.4-R0.1-SNAPSHOT")
    compileOnly(kotlin("stdlib-jdk8"))
    implementation(project(":interface"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.encoding = "UTF-8"
}