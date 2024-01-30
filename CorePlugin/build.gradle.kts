plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

repositories {
    maven("https://nexus.cyanbukkit.cn/repository/maven-public")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
//    把项目:r1_8到:r1_22的shadow进行了合并
    for (i in 8..22) {
        implementation(project(":r1_$i"))
    }
//    implementation(project("Interface"))
    // Papi
    implementation(kotlin("stdlib-jdk8"))
}



kotlin {
    jvmToolchain(8)
}

version = "1.0.0"


bukkit {
    main = "cn.cyanbukkit.${rootProject.name.lowercase()}.PluginStart"
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