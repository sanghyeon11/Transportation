package org.main.util;

import lombok.extern.slf4j.Slf4j;
import org.main.component.AppComponent;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

@Slf4j
public class FileUtils {
    private String UPLOAD_DIR;


    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "파일을 선택하세요.");
            return "redirect:/uploadResult";
        }

        try {
            // 업로드 디렉터리 생성
            Path uploadPath = Path.of(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectory(uploadPath);
            }

            // 파일 업로드
            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            redirectAttributes.addFlashAttribute("message", "파일 업로드 성공: " + file.getOriginalFilename());
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "파일 업로드 실패: " + file.getOriginalFilename());
        }
        return "redirect:/uploadResult";
    }

    public static boolean CreateFile(String log_path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(log_path + "test.log"))) {
            // 로그 파일에 내용 작성
            writer.write("로그 파일에 저장할 내용 1");
            writer.newLine(); // 새로운 라인
            writer.write("로그 파일에 저장할 내용 2");
            writer.newLine();
            writer.write("로그 파일에 저장할 내용 3");
        } catch (IOException e) {
            log.error("Failed CreateFile ", e);
            return false;
        }
        log.info("로그 파일이 생성되었습니다: - {}", log_path);
        return true;
    }
}
