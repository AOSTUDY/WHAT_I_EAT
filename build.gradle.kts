// Top-level build file where you can add configuration options common to all sub-projects/modules.
apply(plugin = "org.jlleitschuh.gradle.ktlint")

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktlintVersion}")
        classpath(ClassPathPlugins.hilt)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent
    repositories {
        // Required to download KtLint
        mavenCentral()
    }
    // Optionally configure plugin
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> { debug.set(true) }
    afterEvaluate {
        project.apply("$rootDir/gradle/common.gradle")
    }
}
