package com.ramz.mvp.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;

/**
 * Created by munnaz on 20/12/16.
 * Util Class for Mvp example of file operation
 * List the files in the selected files
 */

public class GetFilesUtil {


    /**
     * FileFilter option for hiddenfiles
     */
    public static final FileFilter DEFAULT_FILE_FILTER = new FileFilter()
    {

        @Override
        public boolean accept(File pathname)
        {
            return pathname.isHidden() == false;
        }
    };

    /**
     * Gets files in the selected folder
     */
    public File[] getFilesInDirectory(File files)
    {
        return files.listFiles();
    }

    public static class FileSizeComparator extends FileNameComparator
    {
        private final boolean ascending = false;

        @Override
        public int compare(File lhs, File rhs)
        {
            if (lhs.isDirectory() || rhs.isDirectory())
                return super.compare(lhs, rhs);

            if (lhs.length() > rhs.length())
                return ascending ? SECOND : FIRST;
            else if (lhs.length() < rhs.length())
                return ascending ? FIRST : SECOND;
            else return super.compare(lhs, rhs);
        }
    }


    /**
     * Compares files by name, where directories come always first
     */
    public static class FileNameComparator implements Comparator<File>
    {
        protected final static int
                FIRST = -1,
                SECOND = 1;
        @Override
        public int compare(File lhs, File rhs)
        {
            if (lhs.isDirectory() || rhs.isDirectory())
            {
                if (lhs.isDirectory() == rhs.isDirectory())
                    return lhs.getName().compareToIgnoreCase(rhs.getName());
                else if (lhs.isDirectory()) return FIRST;
                else return SECOND;
            }
            return lhs.getName().compareToIgnoreCase(rhs.getName());
        }
    }



    /**
     * Compares files by extension.
     * Falls back to sort by name if extensions are the same or one of the objects is a Directory
     * *
     */
    public static class FileExtensionComparator extends FileNameComparator
    {
        @Override
        public int compare(File lhs, File rhs)
        {
            if (lhs.isDirectory() || rhs.isDirectory())
                return super.compare(lhs, rhs);

            String ext1 = getFileExtension(lhs),
                    ext2 = getFileExtension(rhs);

            if (ext1.equals(ext2))
                return super.compare(lhs, rhs);
            else
                return ext1.compareToIgnoreCase(ext2);
        }
    }


    public static String getFileExtension(File file)
    {
        return getFileExtension(file.getName().toLowerCase());
    }

    /**
     * Gets extension of the file name excluding the . character
     */
    public static String getFileExtension(String fileName)
    {
        if (fileName.contains("."))
            return fileName.substring(fileName.lastIndexOf('.')+1);
        else
            return "";
    }
}
