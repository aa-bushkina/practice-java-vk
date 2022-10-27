plugins {
    java
    id("io.freefair.lombok") version "6.5.1"
}

allprojects {

    group = "ru.vk"
    version = "1.0-SNAPSHOT"

    apply(plugin = "java")
    apply(plugin = "io.freefair.lombok")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks {
        test {
            useJUnitPlatform()
        }
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
        implementation("com.intellij:annotations:12.0")
        implementation("com.google.code.gson:gson:2.9.1")
        implementation("com.google.inject:guice:5.1.0")
        testImplementation("org.mockito:mockito-core:4.8.1")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
        implementation("com.google.inject.extensions:guice-assistedinject:5.1.0")
    }

    repositories {
        mavenCentral()
    }
}

