

val group = "cn.cyanbukkit.example" // 先更改这里
version = "0.1"

bukkit {
    name = rootProject.name // 设置插件的名字 已设置跟随项目名
    description = "An example plugin for CyanBukkit" // 设置插件的描述
    authors = listOf("Your Name") // 设置插件作者
    website = "https://cyanbukkit.cn" // 设置插件的网站
    main = "${group}.launcher.CyanPluginLauncher" // 设置插件的主类 修改请到group修改
}

plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}


dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    compileOnly(fileTree("libs") { include("*.jar") })
    implementation(project(":interface"))
    implementation(project(":r1_8_8"))
    implementation(project(":r1_12_2"))
    implementation(project(":r1_19"))
    implementation(project(":r1_19_2"))
    implementation(project(":r1_19_4"))
    implementation(project(":r1_20_1"))
    implementation(project(":r1_20_4"))
//    compileOnly("com.zaxxer:HikariCP:5.1.0") // Java 11+
//    compileOnly("com.zaxxer:HikariCP:4.0.3") // Java 8
//    compileOnly("com.zaxxer:HikariCP:2.4.13") // Java 7
//    compileOnly("com.zaxxer:HikariCP:2.3.13") // Java 6
    implementation(kotlin("stdlib-jdk8"))
}

kotlin {
    jvmToolchain(8)
}

java {
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }

    shadowJar {
        archiveFileName.set("${rootProject.name}-${version}.jar")
    }
}
