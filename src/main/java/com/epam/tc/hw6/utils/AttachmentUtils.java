package com.epam.tc.hw6.utils;


import io.qameta.allure.Attachment;

public class AttachmentUtils {

    private AttachmentUtils() {
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] addScreenshotAttachment(String name, byte[] resource) {
        return resource;
    }
}
