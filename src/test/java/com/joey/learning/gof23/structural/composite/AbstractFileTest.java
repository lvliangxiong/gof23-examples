package com.joey.learning.gof23.structural.composite;

import org.junit.jupiter.api.Test;

class AbstractFileTest {

    @Test
    void killVirus() {
        AbstractFile f1, f2, f3, f4, f5, f6, f7;
        Folder folder1, folder2;
        f1 = new ImageFile("love.jpg");
        f2 = new TextFile("hello.txt");
        f3 = new ImageFile("joey.png");
        f4 = new VideoFile("Evelyn.avi");
        f5 = new ImageFile("sky.jpg");
        f6 = new TextFile("love.md");
        f7 = new VideoFile("sunshine.mp4");

        folder1 = new Folder("My fav");
        folder2 = new Folder("Video");
        folder1.add(f1);
        folder1.add(f3);
        folder1.add(f5);
        folder1.add(f7);

        folder2.add(f2);
        folder2.add(f4);
        folder2.add(f6);

        folder1.add(folder2);

        folder1.killVirus();
    }
}