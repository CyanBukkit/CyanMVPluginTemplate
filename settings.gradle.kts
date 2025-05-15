pluginManagement {
    repositories {
        maven("https://nexus.cyanbukkit.cn/repository/maven-public/")
        gradlePluginPortal()
        mavenCentral()
    }
}

include(":core")
include(":interface")
include(":r1_8_8")
include(":r1_12_2")
include(":r1_19")
include(":r1_19_2")
include(":r1_19_4")
include(":r1_20_1")
include(":r1_20_4")

// 此处修改名字
rootProject.name = "CyanMultiVersionPluginTemplate"


/**
 *          总项目
 *            |     \
 *            |    抽象与API
 *            1.8   /
 *            1.12  /
 */