package com.addtrycatch;

import com.quinn.hunter.transform.asm.BaseWeaver;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;

/**
 * @author xc
 * @time 19-2-28.
 */
class AddTryCatchWeaver extends BaseWeaver {
    boolean buildInWindows = File.separator.equals("\\");

    @Override
    public boolean isWeavableClass(String fullQualifiedClassName) {
        if (buildInWindows && fullQualifiedClassName.contains("\\")) {
            fullQualifiedClassName = fullQualifiedClassName.substring(fullQualifiedClassName.indexOf("classes") + 8).replace("\\", ".");
        }
        boolean match = Config.getInstance().extension.hookPoint.containsKey(fullQualifiedClassName.replace(".class", ""));
        if (match) {
            System.out.println("add try catch class :" + fullQualifiedClassName);
        }
        return match;
    }

    @Override
    protected ClassVisitor wrapClassWriter(ClassWriter classWriter) {
        return new AddTryCatchClassAdapter(classWriter);
    }
}
