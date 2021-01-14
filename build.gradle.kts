val setup = tasks.register("setup")
tasks {
    "setup" {
        dependsOn(":shared:build")
        finalizedBy(":client:build", ":server:build")
    }
}