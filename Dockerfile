# --- STAGE 1: Build ---
# Gunakan image Maven yang sudah berisi JDK untuk melakukan build
FROM maven:3.9.8-eclipse-temurin-17 AS builder

# Tentukan direktori kerja
WORKDIR /app

# Copy file pom.xml dulu untuk optimasi cache Docker.
# Jika dependency tidak berubah, Docker tidak akan mengunduh ulang.
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy sisa source code aplikasi Anda
COPY src ./src

# Jalankan proses build untuk membuat file JAR
# -DskipTests untuk mempercepat proses build di Docker
RUN mvn package -DskipTests


# --- STAGE 2: Final Image ---
# Mulai dari base image yang sangat kecil, hanya berisi Java Runtime (JRE)
FROM eclipse-temurin:17-jre-focal

# Tentukan direktori kerja
WORKDIR /app

# Port yang akan digunakan oleh aplikasi Spring Boot
EXPOSE 8080

# Copy HANYA file .jar yang sudah jadi dari stage 'builder'
COPY --from=builder /app/target/*.jar app.jar

# Perintah untuk menjalankan aplikasi saat container dimulai
ENTRYPOINT ["java","-jar","app.jar"]