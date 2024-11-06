plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    `maven-publish`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


group = "io.devload"
version = "1.0"
extra["pomName"] = "주렁주렁 라이브러리 테스트-Animal"
description = "라이브러리야 주렁주렁"

publishing {
    publications {
        create<MavenPublication>("mavenJava") {

            artifactId = "Animal-Android"

            groupId = group.toString()
            version = version.toString()
//            from(components["java"]) // Java 컴포넌트를 아티팩트에 포함
//            artifact(tasks["customJar"])
            artifact(tasks.getByName("jar"))

            pom {
                name.set(extra["pomName"].toString())
                description.set(project.description)
                url.set("https://github.com/your-repo")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("developer-id")
                        name.set("Your Name")
                        email.set("your-email@example.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/your-repo.git")
                    developerConnection.set("scm:git:ssh://github.com:your-repo.git")
                    url.set("https://github.com/your-repo")
                }

            }



        }
    }
    repositories {

        maven {

            credentials.username = "admin" // Nexus 로그인 계정
            credentials.password = "1234" // Nexus 로그인 비밀번호

            name = "nexus"
            url = uri("http://localhost:8081/repository/maven-releases/") // Nexus repository URL
            isAllowInsecureProtocol = true // HTTP 허용 설정
        }
    }
}
