package utilities;

import java.io.File;
import org.openqa.selenium.Platform;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static ExtentReports extent;
    public static Platform platform;
    private static final String reportFileName = "ExtentReports.html";

    private static final String macPath = System.getProperty("user.dir") + "/TestReport";
    private static final String ubuntuPath = System.getProperty("user.dir") + "/TestReport";
    private static final String windowsPath = System.getProperty("user.dir") + "\\TestReport";

    private static final String macReportFileLoc = macPath + "/" + reportFileName;
    private static final String ubuntuReportFileLoc = ubuntuPath + "/" + reportFileName;
    private static final String winReportFileLoc = windowsPath + "\\" + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() {
        platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Functional Test Execution Summary");
        htmlReporter.config().setTimelineEnabled(true);  
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Environment", "QA");
        return extent;
    }

    private static String getReportFileLocation(Platform platform) {
        String reportFileLocation = null;

        switch (platform) {
            case MAC:
                reportFileLocation = macReportFileLoc;
                createReportPath(macPath);
                System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
                break;

            case LINUX:
                reportFileLocation = ubuntuReportFileLoc;
                createReportPath(ubuntuPath);
                System.out.println("ExtentReport Path for Ubuntu/Linux: " + ubuntuPath + "\n");
                break;

            case WINDOWS:
                reportFileLocation = winReportFileLoc;
                createReportPath(windowsPath);
                System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
                break;

            default:
                System.out.println("Unknown platform! ExtentReport path not set.\n");
                break;
        }

        return reportFileLocation;
    }

    private static void createReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory created: " + path);
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        }

        File screenshotsDirectory = new File(path + "/Screenshots");
        if (!screenshotsDirectory.exists()) {
            if (screenshotsDirectory.mkdir()) {
                System.out.println("Screenshots directory created!");
            }
        }
    }

    private static Platform getCurrentPlatform() {
        if (platform == null) {
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("win")) {
                platform = Platform.WINDOWS;
            } else if (osName.contains("mac")) {
                platform = Platform.MAC;
            } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
                platform = Platform.LINUX;  // Treat Ubuntu as Linux
            }
        }
        return platform;
    }
}
