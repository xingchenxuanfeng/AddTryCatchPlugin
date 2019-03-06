package com.addtrycatch;

import com.quinn.hunter.transform.asm.BaseWeaver;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author xc
 * @time 19-2-28.
 */
class AddTryCatchWeaver extends BaseWeaver {
    @Override
    public boolean isWeavableClass(String fullQualifiedClassName) {
        if (File.separator.equals("\\") & fullQualifiedClassName.contains("\\")) {//windows workaround
            fullQualifiedClassName = fullQualifiedClassName.replace("\\", ".");
            for (Map.Entry<String, List<String>> entry : Config.getInstance().extension.hookPoint.entrySet()) {
                boolean contains = fullQualifiedClassName.contains(entry.getKey());
                if (contains) return true;
            }
            return false;
        }

        return Config.getInstance().extension.hookPoint.containsKey(fullQualifiedClassName.replace(".class", ""));
    }

    @Override
    protected ClassVisitor wrapClassWriter(ClassWriter classWriter) {
        return new AddTryCatchClassAdapter(classWriter);
    }
}
