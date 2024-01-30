pluginManagement {
    repositories {
        maven("https://nexus.cyanbukkit.cn/repository/maven-public/")
        gradlePluginPortal()
        mavenCentral()
    }
}
// 多模块
for (i in 8..22) {
    include(":r1_$i")
}
include(":CorePlugin")
include(":Interface")
rootProject.name = "MyMultiModuleProject"