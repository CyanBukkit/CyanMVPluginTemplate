
plugins {
    java
}

dependencies {
    // 抽象开发包不导入任何东西 他只Java原生的东西
    compileOnly(kotlin("stdlib-jdk8"))
}