//import org.jetbrains.kotlin.gradle.dsl.JvmTarget
//
//plugins {
//	id("org.springframework.boot") version "3.3.0"
//	id("io.spring.dependency-management") version "1.1.5"
//	kotlin("jvm") version "1.9.24"
//	kotlin("plugin.spring") version "1.9.24"
//	kotlin("plugin.serialization") version "1.9.24"
//}
//
//group = "jp.ac.it_college.std.s23012.message.board"
//version = "0.0.1-SNAPSHOT"
//
//java {
//	sourceCompatibility = JavaVersion.VERSION_21
//}
//
//repositories {
//	mavenCentral()
//}
//
//val exposedVersion: String by project
//dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	implementation("org.bouncycastle:bcprov-jdk18on:1.78.1")
//	implementation("org.springframework.session:spring-session-data-redis")
//	runtimeOnly("redis.clients:jedis")
//	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json")
//	implementation("org.jetbrains.kotlin:kotlin-reflect")
//	implementation("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")
//	implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")
//	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	implementation ("org.springframework.boot:spring-boot-starter-web")
//	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation ("org.springframework.boot:spring-boot-starter-security")
//	implementation ("com.fasterxml.jackson.module:jackson-module-kotlin")
//	runtimeOnly ("org.springframework.boot:spring-boot-devtools")
//	runtimeOnly ("com.h2database:h2") // 例えばH2データベースを使用する場合
//	testImplementation ("org.springframework.boot:spring-boot-starter-test")
//	implementation("org.jetbrains.exposed:exposed-core:0.41.1")
//	implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
//	implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
//	implementation("org.jetbrains.exposed:exposed-java-time:0.41.1")
//	implementation("com.h2database:h2")
//	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation("org.springframework.boot:spring-boot-starter-validation")
//	implementation("org.springframework.security:spring-security-crypto")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.springframework.security:spring-security-test")
//	implementation("org.jetbrains.exposed:exposed-core:0.31.1")
//	implementation("org.jetbrains.exposed:exposed-datetime:0.31.1")
//}
//
//kotlin {
//	compilerOptions {
//		freeCompilerArgs.addAll("-Xjsr305=strict")
//		jvmTarget = JvmTarget.JVM_21
//	}
//}
//
//tasks.withType<Test> {
//	useJUnitPlatform()
//}

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
	kotlin("plugin.serialization") version "1.9.24"
}

group = "jp.ac.it_college.std.s23012.message.board"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		sourceCompatibility = JavaVersion.VERSION_21
	}
}

repositories {
	mavenCentral()
}

val exposedVersion: String by project
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.bouncycastle:bcprov-jdk18on:1.78.1")
	implementation("org.springframework.session:spring-session-data-redis")
	runtimeOnly("redis.clients:jedis")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")
	implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.0")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
		jvmTarget = JvmTarget.JVM_21
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}