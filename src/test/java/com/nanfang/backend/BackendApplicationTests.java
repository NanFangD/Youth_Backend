package com.nanfang.backend;

import org.springframework.boot.test.context.SpringBootTest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;


@SpringBootTest
class BackendApplicationTests {
    /**
     *
     * @param args
     * @throws IOException
     */
    final String str="src/test/java/com/nanfang/backend/";
    public static void main(String[] args) throws IOException {
        BackendApplicationTests thumbnailatorTest = new BackendApplicationTests();
        thumbnailatorTest.test_();
//        thumbnailatorTest.test1();
//        thumbnailatorTest.test2();
//        thumbnailatorTest.test3();
//        thumbnailatorTest.test4();
//        thumbnailatorTest.test5();
//        thumbnailatorTest.test6();
//        thumbnailatorTest.test7();
//        thumbnailatorTest.test8();
//        thumbnailatorTest.test9();
    }


    private void test_() throws IOException {

    }
    /**
     * 指定大小进行缩放
     *
     * @throws IOException
     */
    private void test1() throws IOException {
        /*
         * size(width,height) 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         */

        Thumbnails.of(str+"test.jpg").size(200, 300).toFile(
                str+"test_200x300.jpg");
        Thumbnails.of(str+"test.jpg").size(2560, 2048).toFile(
                str+"test_2560x2048.jpg");
    }

    /**
     * 按照比例进行缩放
     *
     * @throws IOException
     */
    private void test2() throws IOException {
        /**
         * scale(比例)
         */
        Thumbnails.of(str+"test.jpg").scale(0.30f)
                .toFile(str+"image_50%.jpg");
        Thumbnails.of(str+"test.jpg").scale(1.10f).toFile(
                str+"image_110%.jpg");
    }

    /**
     * 不按照比例，指定大小进行缩放
     *
     * @throws IOException
     */
    private void test3() throws IOException {
        /**
         * keepAspectRatio(false) 默认是按照比例缩放的
         */
        Thumbnails.of(str+"test.jpg").size(120, 120).keepAspectRatio(false)
                .toFile(str+"image_120x120.jpg");
    }

    /**
     * 旋转
     *
     * @throws IOException
     */
    private void test4() throws IOException {
        /**
         * rotate(角度),正数：顺时针 负数：逆时针
         */
        Thumbnails.of(str+"test.jpg").size(1280, 1024).rotate(90).toFile(
                str+"image+90.jpg");
        Thumbnails.of(str+"test.jpg").size(1280, 1024).rotate(-90).toFile(
                str+"image-90.jpg");
    }

    /**
     * 水印
     *
     * @throws IOException
     */
    private void test5() throws IOException {
        /**
         * watermark(位置，水印图，透明度)
         */
        Thumbnails.of(str+"test.jpg").size(1280, 1024).watermark(
                Positions.BOTTOM_RIGHT,
                ImageIO.read(new File(str+"test.png")), 0.5f)
                .outputQuality(0.8f).toFile(
                str+"image_watermark_bottom_right.jpg");
        Thumbnails.of(str+"test.jpg").size(1280, 1024).watermark(
                Positions.CENTER,
                ImageIO.read(new File(str+"test.png")), 0.5f)
                .outputQuality(0.8f).toFile(str+"image_watermark_center.jpg");
    }

    /**
     * 裁剪
     *
     * @throws IOException
     */
    private void test6() throws IOException {
        /**
         * 图片中心400*400的区域
         */
        Thumbnails.of(str+"test.jpg").sourceRegion(Positions.CENTER, 400,
                400).size(200, 200).keepAspectRatio(false).toFile(
                str+"image_region_center.jpg");
        /**
         * 图片右下400*400的区域
         */
        Thumbnails.of(str+"test.jpg").sourceRegion(Positions.BOTTOM_RIGHT,
                400, 400).size(200, 200).keepAspectRatio(false).toFile(
                str+"image_region_bootom_right.jpg");
        /**
         * 指定坐标
         */
        Thumbnails.of(str+"test.jpg").sourceRegion(600, 500, 400, 400).size(
                200, 200).keepAspectRatio(false).toFile(
                str+"image_region_coord.jpg");
    }

    /**
     * 转化图像格式
     *
     * @throws IOException
     */
    private void test7() throws IOException {
        /**
         * outputFormat(图像格式)
         */
        Thumbnails.of(str+"test.jpg").size(1280, 1024).outputFormat("png")
                .toFile(str+"image_1280x1024.png");
        Thumbnails.of(str+"test.jpg").size(1280, 1024).outputFormat("gif")
                .toFile(str+"image_1280x1024.gif");
    }

    /**
     * 输出到OutputStream
     *
     * @throws IOException
     */
    private void test8() throws IOException {
        /**
         * toOutputStream(流对象)
         */
        OutputStream os = new FileOutputStream(
                str+"image_1280x1024_OutputStream.png");
        Thumbnails.of(str+"test.jpg").size(1280, 1024).toOutputStream(os);
    }

    /**
     * 输出到BufferedImage
     *
     * @throws IOException
     */
    private void test9() throws IOException {
        /**
         * asBufferedImage() 返回BufferedImage
         */
        BufferedImage thumbnail = Thumbnails.of(str+"test.jpg").size(1280,
                1024).asBufferedImage();
        ImageIO.write(thumbnail, "jpg", new File(
                str+"image_1280x1024_BufferedImage.jpg"));
    }
}


