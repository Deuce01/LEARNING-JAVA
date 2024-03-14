import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader {
    public static void main(String[] args) {
        String fileUrl = "https://example.com/samplefile.txt"; // URL of the file to download
        String saveDir = "downloads"; // Directory to save the downloaded file

        try {
            downloadFile(fileUrl, saveDir);
            System.out.println("File downloaded successfully.");
        } catch (IOException e) {
            System.out.println("Error downloading file: " + e.getMessage());
        }
    }

    public static void downloadFile(String fileUrl, String saveDir) throws IOException {
        URL url = new URL(fileUrl);
        URLConnection conn = url.openConnection();
        InputStream inputStream = conn.getInputStream();
        OutputStream outputStream = new FileOutputStream(saveDir + File.separator + getFileName(fileUrl));

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.close();
        inputStream.close();
    }

    public static String getFileName(String fileUrl) {
        String fileName = "";
        int slashIndex = fileUrl.lastIndexOf('/');
        if (slashIndex != -1) {
            fileName = fileUrl.substring(slashIndex + 1);
        }
        return fileName;
    }
}
