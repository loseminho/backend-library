package common;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class FileRename {
	public static String fileRename(String path, String filename) {
		// 파일명만
		String onlyFilename = filename.substring(0, filename.lastIndexOf("."));
		// .확장자만
		String extention = filename.substring(filename.lastIndexOf("."));
		// 실제 업로드할 파일 명
		String filepath = null;
		// 파일명이 중복되는 경우 뒤에 붙일 숫자
		int count = 0;
		while(true) {
			if(count == 0) {
				// 파일 이름 체크 반복 첫 번째인 경우
				filepath = onlyFilename + extention;
			}else {
				filepath = onlyFilename + "_" + count + extention;
			}
			File checkFile = new File(path + filepath);
			if(!checkFile.exists()) {
				// 중복 파일명이 아닌 경우 무한 반복문 탈출
				break;
			}
			count++;
		}
		return filepath;
	}
}
