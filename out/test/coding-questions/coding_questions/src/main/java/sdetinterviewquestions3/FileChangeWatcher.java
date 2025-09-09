package sdetinterviewquestions3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileChangeWatcher {

    private static final Path WATCH_DIR = Paths.get("src/test"); // or any directory
    private static final String FILE_FILTER = ".java"; // change to ".feature", ".xml" etc.

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        WATCH_DIR.register(watchService, java.nio.file.StandardWatchEventKinds.ENTRY_CREATE,
                java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY,
                java.nio.file.StandardWatchEventKinds.ENTRY_DELETE);

        System.out.println("👀 Watching for file changes in: " + WATCH_DIR.toAbsolutePath());

        while (true) {
            WatchKey key = watchService.take(); // waits for events

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path changedFile = (Path) event.context();

                if (changedFile.toString().endsWith(FILE_FILTER)) {
                    System.out.printf("🔄 File %s: %s\n", kind.name(), changedFile);

                    // Trigger your tests (run Maven, Gradle, etc.)
                    triggerTests();
                }
            }

            boolean valid = key.reset();
            if (!valid) break;
        }
    }

    private static void triggerTests() {
        try {
            System.out.println("🚀 Running tests...");
            ProcessBuilder builder = new ProcessBuilder("mvn", "test");
            builder.inheritIO(); // Redirect output to console
            Process process = builder.start();
            int exitCode = process.waitFor();
            System.out.println("✅ Tests finished with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            System.err.println("❌ Failed to run tests: " + e.getMessage());
        }
    }
}
