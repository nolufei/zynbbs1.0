package com.zynbbs.hook;

import org.aspectj.lang.annotation.Pointcut;

public class FileUtilHook {

    @Pointcut("execution(public * com.zynbbs.util.FileUtil.upload(..))")
    public void upload() {
    }

}
