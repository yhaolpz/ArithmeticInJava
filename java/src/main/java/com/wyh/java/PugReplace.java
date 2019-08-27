package com.wyh.java;

import java.io.File;

/**
 * @author WangYingHao
 * @since 2019-07-02
 */
public class PugReplace {


    private void replaceClass(File file) {
        if (!file.exists()) {
            return;
        }


    }


    private void replaceDir(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    replaceDir(file);
                } else {
                    replaceClass(file);
                }
            }
        }
    }

    public void replace(String path) {
        replaceDir(new File(path));
    }
}
