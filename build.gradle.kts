val bundle = tasks.register("bundle")
tasks {
    "bundle" {
        dependsOn(":shared:build")
        finalizedBy(":client:build", ":server:build")
    }
}