import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("org.antora") version "1.0.0"
}

node {
    version.set("22.13.0")
}

tasks.named("antora") {
    dependsOn("buildUI")
}

tasks.register<NpmTask>("installUI") {
    workingDir.set(projectDir.resolve("ui"))
    npmCommand.set(listOf("install"))
    inputs.file("ui/package.json")
    inputs.file("ui/package-lock.json")
    outputs.dir("ui/node_modules")
}

tasks.register<NpmTask>("buildUI") {
    dependsOn("installUI")
    workingDir.set(projectDir.resolve("ui"))
    npmCommand.set(listOf("run", "build"))
    inputs.file("ui/gulpfile.js")
    inputs.dir("ui/src")
    inputs.dir("ui/gulp.d")
    outputs.dir("ui/build")
}

tasks.register<NpmTask>("previewUI") {
    dependsOn("installUI")
    workingDir.set(projectDir.resolve("ui"))
    npmCommand.set(listOf("run", "start"))
}
