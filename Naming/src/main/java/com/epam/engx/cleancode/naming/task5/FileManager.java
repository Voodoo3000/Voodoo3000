package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidDirectoryException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidFileTypeException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.PropertyUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class FileManager {

    private static final String[] IMG_TYPES = {"jpg", "png"};
    private static final String[] DOC_TYPES2 = {"pdf", "doc"};

    private static final String BASE_PATH = PropertyUtil.loadProperty("basePath");

    public File retrieveFile(String fileName) {
        validateFileType(fileName);
        final String dirPath = BASE_PATH + File.separator;
        return Paths.get(dirPath, fileName).toFile();
    }

    public List<String> getAllImages() {
        return getFiles(IMG_TYPES);
    }

    public List<String> getAllDocumentFiles() {
        return getFiles(DOC_TYPES2);
    }

    private void validateFileType(String fileName) {
        if (isInvalidFileType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidFileType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        FileExtensionPredicator imageExtensionsPredicate = new FileExtensionPredicator(IMG_TYPES);
        return !imageExtensionsPredicate.test(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        FileExtensionPredicator documentExtensionsPredicate = new FileExtensionPredicator(DOC_TYPES2);
        return !documentExtensionsPredicate.test(fileName);
    }

    private List<String> getFiles(String[] allowedExtensions) {
        final FileExtensionPredicator predicator = new FileExtensionPredicator(allowedExtensions);
        return Arrays.asList(Objects.requireNonNull(getDirectory().list(getFilenameFilterByPredicate(predicator))));
    }

    private FilenameFilter getFilenameFilterByPredicate(final FileExtensionPredicator predicator) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String str) {
                return predicator.test(str);
            }
        };
    }

    private File getDirectory() {
        File directory = new File(FileManager.BASE_PATH);
        validateDirectory(directory);
        return directory;
    }

    private void validateDirectory(File directoryInstance) {
        if (isNotDirectory(directoryInstance)) {
            throw new InvalidDirectoryException("Invalid getDirectory found: " + directoryInstance.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File directoryInstance) {
        return !directoryInstance.isDirectory();
    }

}