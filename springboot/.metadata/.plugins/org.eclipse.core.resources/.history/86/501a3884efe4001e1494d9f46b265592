package com.bitc.kdh.common;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.kdh.dto.GametalkPostFileDto;

@Component
public class PostFiles {
	public List<GametalkPostFileDto> parseFileInfo(int postIdx, MultipartHttpServletRequest multiFiles) throws Exception {

		if (ObjectUtils.isEmpty(multiFiles)) {
			return null;
		}

		List<GametalkPostFileDto> fileList = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
		String absolutePath = new File("").getAbsolutePath() + "\\";
		String path = "/post_file/" + current.format(format);
		File file = new File(path);
		if (file.exists() == false) {
			file.mkdirs();
		}

		Iterator<String> iterator = multiFiles.getFileNames();
		String newFileName;
		String originalFileExtension;
		String contentType;

		while (iterator.hasNext()) {
			String name = iterator.next();
			List<MultipartFile> list = multiFiles.getFiles(name);

			for (MultipartFile mFile : list) {
				if (mFile.isEmpty() == false) {
					contentType = mFile.getContentType();
					if (ObjectUtils.isEmpty(contentType)) {
						break;
					} else {
						if (contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						} else if (contentType.contains("image/png")) {
							originalFileExtension = ".png";
						} else if (contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						} else {
							break;
						}
					}

					newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

					GametalkPostFileDto postFile = new GametalkPostFileDto();
					postFile.setPostIdx(postIdx);
					postFile.setFileSize(Long.toString(mFile.getSize()));
					postFile.setOriginalName(mFile.getOriginalFilename());
					postFile.setFilePath(absolutePath + path + "/" + newFileName);
					fileList.add(postFile);

					file = new File(path + "/" + newFileName);
					mFile.transferTo(file);
				}
			}
		}

		return fileList;
	}
}
