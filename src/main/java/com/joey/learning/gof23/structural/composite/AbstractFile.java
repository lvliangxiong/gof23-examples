package com.joey.learning.gof23.structural.composite;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象组件，代表文件和文件夹的公共接口
 */
public interface AbstractFile {
    void killVirus();
}


/**
 * 容器组件，代表文件夹
 */
@Slf4j
class Folder implements AbstractFile {
    List<AbstractFile> children = new ArrayList<>();

    String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        log.info("checking virus in folder {}", name);

        for (AbstractFile f :
                children) {
            f.killVirus();
        }
    }

    void add(AbstractFile f) {
        children.add(f);
    }

    void remove(AbstractFile f) {
        children.remove(f);
    }

    AbstractFile getChild(int index) {
        return children.get(index);
    }


}


/**
 * 叶子组件的实现类
 */
@Slf4j
class VideoFile implements AbstractFile {
    String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        log.info("checking virus in video file ", name);
    }
}

@Slf4j
class ImageFile implements AbstractFile {
    String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        log.info("checking virus in image file ", name);
    }
}

@Slf4j
class TextFile implements AbstractFile {
    String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        log.info("checking virus in text file ", name);
    }
}
