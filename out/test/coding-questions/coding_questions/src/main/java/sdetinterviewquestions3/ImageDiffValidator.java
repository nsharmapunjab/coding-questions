package sdetinterviewquestions3;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageDiffValidator {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // Load native OpenCV lib
    }

    public static void main(String[] args) {
        String baselinePath = "baseline.png";
        String actualPath = "actual.png";
        String diffOutputPath = "diff.png";

        Mat baseline = Imgcodecs.imread(baselinePath);
        Mat actual = Imgcodecs.imread(actualPath);

        if (baseline.empty() || actual.empty()) {
            System.err.println("❌ Failed to load images. Check paths.");
            return;
        }

        if (!baseline.size().equals(actual.size())) {
            System.err.println("❌ Images are of different sizes.");
            return;
        }

        Mat diff = new Mat();
        Core.absdiff(baseline, actual, diff);

        Mat gray = new Mat();
        Imgproc.cvtColor(diff, gray, Imgproc.COLOR_BGR2GRAY);

        Mat thresh = new Mat();
        Imgproc.threshold(gray, thresh, 30, 255, Imgproc.THRESH_BINARY);

        int nonZeroPixels = Core.countNonZero(thresh);
        boolean match = nonZeroPixels == 0;

        if (match) {
            System.out.println("✅ Images match perfectly.");
        } else {
            System.out.printf("⚠️ Images differ! Pixels changed: %d\n", nonZeroPixels);

            // Optional: highlight the diff in red
            Mat contours = new Mat();
            Imgproc.cvtColor(thresh, contours, Imgproc.COLOR_GRAY2BGR);
            Core.addWeighted(actual, 0.5, contours, 0.5, 0, contours);

            Imgcodecs.imwrite(diffOutputPath, contours);
            System.out.println("🖼️ Diff image saved to: " + diffOutputPath);
        }
    }
}
