package ispirer.study.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	public static void shutDown() throws IOException {
		try {
			// Команда для нахождения PID процесса, использующего порт 8080
			String command = "cmd /c netstat -aon | findstr :8080"; // Для Windows

			Process process = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;

			while ((line = reader.readLine()) != null) {
				// Пример строки: "TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       1234"
				// Разбиваем строку по пробелам и получаем PID (последний элемент)
				String[] parts = line.trim().split("\\s+");
				if (parts.length >= 5) { // Убедитесь, что есть достаточно частей
					int pid = Integer.parseInt(parts[parts.length - 1]); // PID обычно последний элемент
					System.out.println("Found PID: " + pid);

					// Завершаем процесс с этим PID
					String killCommand = "taskkill /PID " + pid + " /F"; // Для Windows
					Process killProcess = Runtime.getRuntime().exec(killCommand);
					killProcess.waitFor();
					System.out.println("Process with PID " + pid + " has been terminated.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
