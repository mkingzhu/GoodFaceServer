package com.winchance.wechat.goodface.server.biz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import com.winchance.wechat.goodface.server.biz.config.ImageConfig;
import com.winchance.wechat.goodface.server.dao.ImageDao;
import com.winchance.wechat.goodface.server.model.Image;

public class ImageBiz {
    @Autowired
    private ImageDao imageDao;

    @Autowired
    private ImageConfig imageConfig;

    public void insert(Image image) {
        FileOutputStream out = null;
        try {
            Base64 base64 = new Base64();
            byte[] imageContent = base64.decode(image.getImageString());

            long now = new Date().getTime();
            String fileName = image.getUserId() + now + new Random(now).nextLong() + ".png";
            File imageFile = new File(imageConfig.getImageBaseDir() + fileName);
            out = new FileOutputStream(imageFile);
            out.write(imageContent);

            image.setUrl(fileName);
            imageDao.save(image.toImageDo());

            image.setUrl(imageConfig.getImageUrlPrefix() + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out)
                try {
                    out.close();
                } catch (IOException ignore) {
                }
        }
    }
}
