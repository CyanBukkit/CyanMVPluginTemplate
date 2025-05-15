dependencies {
    compileOnly("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:minecraft-server:1.12.2-SNAPSHOT")
    compileOnly("org.bukkit:craftbukkit:1.12.2-R0.1-SNAPSHOT")
    compileOnly(kotlin("stdlib-jdk8"))
    implementation(project(":interface"))
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