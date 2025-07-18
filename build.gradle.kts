plugins {
    kotlin("jvm") version "2.2.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

subprojects {

    apply {
        plugin("kotlin")
        plugin("com.github.johnrengelman.shadow")
    }
    repositories {
        maven("https://maven.elmakers.com/repository")
        maven("https://libraries.minecraft.net")
        maven("https://nexus.cyanbukkit.cn/repository/maven-public/") {
             //加载失败跳过这个站点
            content {
                excludeGroup("com.mojang") //排除spigot
            }
        }
    }

    dependencies {
        compileOnly(kotlin("stdlib-jdk8"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

}
