import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("plugin.allopen") version "1.4.10"
	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
	kotlin("plugin.jpa") version "1.4.10"
}

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("io.springfox:springfox-swagger2:2.9.2")
	implementation("io.springfox:springfox-swagger-ui:2.9.2")
	implementation("com.h2database:h2:1.4.197")
	implementation("org.testng:testng:6.14.3")

	//comunda
	implementation("org.springframework.boot:spring-boot-dependencies:2.4.0")
	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:7.14.0")
	implementation("com.sun.xml.bind:jaxb-impl:2.2.3")
	implementation("org.springframework.boot:spring-boot-maven-plugin:2.4.0")

	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("junit", "junit", "4.12")
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

tasks {
	compileKotlin {
		kotlinOptions.jvmTarget = "11"
	}
	compileTestKotlin {
		kotlinOptions.jvmTarget = "11"
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
