plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

repositories {
    maven("https://nexus.cyanbukkit.cn/repository/maven-public")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    // Papi
    compileOnly(kotlin("stdlib-jdk8"))
}



kotlin {
    jvmToolchain(8)
}



group = "cn.cyanbukkit"
version = "1.0"



bukkit {
    main = "cn.cyanbukkit.${rootProject.name.lowercase()}.PluginStart"
    apiVersion = "1.8"
    name = rootProject.name
}


tasks {

    test {
        useJUnitPlatform()
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    shadowJar {
        archiveFileName.set("${rootProject.name}-${version}.jar")
    }

}